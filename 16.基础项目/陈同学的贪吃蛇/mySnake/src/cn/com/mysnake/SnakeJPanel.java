package cn.com.mysnake;
import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.event.HierarchyBoundsAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.Properties;
import java.util.Random;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListModel;

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
/**
 * 
 * @author ccq
 * ̰ʳ�ߵĻ���
 *
 */
public class SnakeJPanel extends javax.swing.JPanel implements KeyListener
{
	public static final int STARTPOINT_X = 20;//�ڿ�ʼ��X
	public static final int STARTPOINT_Y = 10;//�ڿ�ʼ��Y
	public static final int SIZE_X = 580; //�ڿ򳤶�
	public static final int SIZE_Y = 320; //�ڿ�߶�
	public static final int BOX_GAP = 10; //�����϶
	public static final int SPEED = 500; //���Զ������ٶ�
	
	public static boolean isGameStart = false;//��Ϸ״̬��ʶ
	public static boolean isMorePerson =false;//������Ϸ���
	
	private static SnakeFood food;//ʳ��
	private static Snake snake;//��
	private static LinkedList<Snake> netSnakelist; //���������ߵļ���
	private SnakeMoveThread snakeMoveThread;//���Զ������߳�
	private JList jScoreList;//�б��

	public Color boxColor;//�����ɫ
	public Color boxLowColor;//��ײ�����ɫ
	
	private SnakeServer snakeServer;//������
	private SnakeClient snakeClient;//�ͻ���
	
	private UdpThread udpThread;
	private Properties pro;//�����ļ�
	private LinkedList<String> scoreList;
	
	public SnakeJPanel()
	{
		super();
		initGUI();
		
		scoreList = new LinkedList<String>();
		
		//�����ļ�
		pro = new Properties();
		try {
			File file = new File(".\\snake.config");
			if(!file.exists())//��������ļ�������
			{
				pro.setProperty("name","user");
				pro.store(new FileWriter(file), "snake");
			}
			else
			{
				pro.load(new FileReader(file));	
			}
		} catch (IOException e) {
			System.out.println("�ļ���ȡ�쳣");
		}
		
		this.addKeyListener(this);//��Ӽ����¼�����
		food = new SnakeFood();//����ʳ��
		
		//������
		try {
			snake = new Snake(InetAddress.getLocalHost().toString(),pro.getProperty("name"));//��������Ҫ�������ж�ȡ
		} catch (UnknownHostException e) {
			System.out.println("ϵͳ����������");
		}
		//������·�߿�������
		netSnakelist = new LinkedList<Snake>();
		
		boxColor = new Color(0,0,0);
		boxLowColor = new Color(176,213,210);
		//�������Զ������߳�
		snakeMoveThread = new SnakeMoveThread(this,SPEED);
		snakeMoveThread.start();
		//����udp�߳�
		udpThread = new UdpThread();
		udpThread.start();
	}
	//��ȡ������
	public SnakeServer getServer()
	{
		return this.snakeServer;
	}
	//�����������߳�
	public void startMorePersonGameServerThread()
	{
		snakeServer = new SnakeServer(this);
		snakeServer.start();
	}
	//��ȡ�ͻ���
	public SnakeClient getClient()
	{
		return this.snakeClient;
	}
	//�����ͻ����߳�
	public void startMorePersonGameClientThread(String serverIP)
	{
		snakeClient = new SnakeClient(this,serverIP);
		snakeClient.start();
	}
	
	
	//�����ʼ��
	private void initGUI()
	{
		try {
			this.setPreferredSize(new java.awt.Dimension(620, 440));
			AnchorLayout thisLayout = new AnchorLayout();
			this.setLayout(thisLayout);
			this.setSize(620, 440);
			{
				ListModel scoreListModel = new DefaultComboBoxModel();
				jScoreList = new JList();
				JScrollPane scrollPane = new JScrollPane(jScoreList);
				this.add(scrollPane, new AnchorConstraint(785, 1000, 1001, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jScoreList.setModel(scoreListModel);
				jScoreList.setPreferredSize(new java.awt.Dimension(620, 95));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	//�߿����
	public void paintBox(Graphics g)
	{
		
		//���Ƹ��ӵĵײ���ɫ
		g.setColor(boxLowColor);//������ɫ
		g.fill3DRect(STARTPOINT_X,STARTPOINT_Y,SIZE_X,SIZE_Y,true);
		
		//�������
		g.setColor(this.boxColor);//������ɫ
		g.drawRect(STARTPOINT_X-BOX_GAP, STARTPOINT_Y-BOX_GAP, SIZE_X+BOX_GAP*2,SIZE_Y+BOX_GAP*2);
		g.drawRect(STARTPOINT_X, STARTPOINT_Y,SIZE_X,SIZE_Y);
		
		//���ƺ��
		for(int i = 0 ; i < SIZE_Y/SnakeBody.SIZE;i ++)
		{
			g.drawLine(STARTPOINT_X,STARTPOINT_Y+SnakeBody.SIZE*(i+1),SIZE_X+SnakeBody.SIZE,STARTPOINT_Y+SnakeBody.SIZE*(i+1));
		}
		
		//��������
		for(int i = 0 ; i < SIZE_X/SnakeBody.SIZE;i ++)
		{
			g.drawLine(STARTPOINT_X+SnakeBody.SIZE*(i+1),STARTPOINT_Y,STARTPOINT_X+SnakeBody.SIZE*(i+1),SIZE_Y+SnakeBody.SIZE/2);
		}
	}
	
	//�����µ�ʳ��
	public void createFood()
	{
		food.crateFood();
	}
	
	//�����µ�ʳ��
	public void drawFood(Graphics g)
	{
		if(!this.isMorePerson)
		{
			//���Ƶ�ʳ��������������������ʳ��
			while(this.snake.getList().contains(new SnakeBody(food.getX(), food.getY())))
			{
				this.createFood();
			}
		}
		else if(this.snake.getIsServerSnake())//�ڶ�����Ϸ�л��Ƶ�ʳ��������������������ʳ��
		{	
			//���Ƶ�ʳ��������������������ʳ��
			while(this.snake.getList().contains(new SnakeBody(food.getX(), food.getY())))
			{
				this.createFood();
			}
			
			for(Snake temp:netSnakelist)
			{
				while(temp.getList().contains(new SnakeBody(food.getX(), food.getY())))
				{
					this.createFood();
				}
			}
		}
		//����
		g.setColor(food.foodColor);//������ɫ
		g.fill3DRect(food.getX()*SnakeFood.FOODSIZE + STARTPOINT_X,food.getY()*SnakeFood.FOODSIZE + STARTPOINT_Y,SnakeFood.FOODSIZE,SnakeFood.FOODSIZE,true);
	}
	public static SnakeFood getFood()
	{
		return food;
	}
	public static Snake getSnake()
	{
		return snake;
	}
	//������
	public void createSnake(int x,int y)
	{
		//snake = new Snake();	
		snake.recreat(x,y);
	}
	//���Ƶ�����
	public void drawSingleSnake(Snake snake,Graphics g)
	{
		if(snake.getState())
		{
			LinkedList<SnakeBody> list = snake.getList();
			//��������
			g.setColor(snake.snakeColor); //������ɫ
			for(int i = 1; i < list.size(); i++)
			{	
				g.fill3DRect(list.get(i).getX()*SnakeBody.SIZE + STARTPOINT_X,list.get(i).getY()*SnakeBody.SIZE + STARTPOINT_Y,SnakeBody.SIZE,SnakeBody.SIZE,true);
			}
			//������ͷ
			g.setColor(snake.snakeHeadColor); //������ɫ
			g.fill3DRect(list.get(0).getX()*SnakeBody.SIZE + STARTPOINT_X,list.get(0).getY()*SnakeBody.SIZE + STARTPOINT_Y,SnakeBody.SIZE,SnakeBody.SIZE,true);
		}
	}
	
	//������
	public void drawSnake(Graphics g)
	{
		drawSingleSnake(this.snake,g);
		//����Ƕ�����Ϸ
		if(this.isMorePerson)
		{
			for(int i = 0 ; i < netSnakelist.size() ; i++)
			{
				drawSingleSnake(netSnakelist.get(i),g);
			}
		}
	}
	
	//�������
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		paintBox(g);
		
		if(this.isGameStart)
		{
			//���õ�ǰ�ؼ�Ϊ����
			this.requestFocus(true);
			
			drawFood(g);//����ʳ��		
			drawSnake(g);//������
			updateScore();//���³ɼ�
		}
	}

	public void startGame()
	{
		//����ߵĳɼ�
		this.snake.setScore(0);
		//�������
		this.netSnakelist.clear();
		//����ʳ��
		this.createFood();
		//������
		this.createSnake(10,10);
		//�ı���Ϸ��ʼ��ʶ
		snake.setState(true);
		this.isGameStart = true;
		this.isMorePerson = false;
		
		//���»��ƽ���
		this.repaint();
		
		System.out.println("��Ϸ��ʼ");
	}
	
	//��ʼ������Ϸ
	public void startMorePersonGame()
	{		
		//����ߵĳɼ�
		this.snake.setScore(0);
		//�������
		this.netSnakelist.clear();
		//����ʳ��
		this.createFood();
		//������
		this.createSnake(10,10);
		
		snake.setState(true);
		//��Ϸ��ʼ��־
		isGameStart = true;
		//������Ϸ��־
		isMorePerson = true;
		
		//���»��ƽ���
		this.repaint();
				
		System.out.println("��Ϸ��ʼ");
	}
	//��ȡ�����߿�������
	public static LinkedList<Snake> getList()
	{
		return netSnakelist;
	}
	
	//���³ɼ�
	public void updateScore()
	{
		scoreList.clear();
		scoreList.add(this.snake.getName()+" ����:"+this.snake.getScore());
		
		for(Snake temp : this.netSnakelist)
		{
			scoreList.add(temp.getName()+" ����:"+temp.getScore());
		}
		
		//ListModel GameListModel = new DefaultComboBoxModel(set.toArray());
		jScoreList.setListData(scoreList.toArray());
	}
	
	
	//���̼��� �ӿ�KeyListener��ʵ�ַ���
	public void keyPressed(KeyEvent e)
	{
		if(this.snake.getState())
		{
			switch (e.getKeyCode())
			{
				case KeyEvent.VK_UP: //���ϼ�
				{
					snake.move(0,-1);
					break;
				}
				case KeyEvent.VK_DOWN: //���¼�
				{
					snake.move(0,1);
					break;
				}
				case KeyEvent.VK_LEFT: //�����
				{
					snake.move(-1,0);
					break;
				}
				case KeyEvent.VK_RIGHT: //���Ҽ�
				{
					snake.move(1,0);
					break;
				}
				default:
					break;
			}
		}
		this.repaint();
	}
	//�ӿ�KeyListener��ʵ�ַ���
	public void keyTyped(KeyEvent e)
	{
		
	}
	//�ӿ�KeyListener��ʵ�ַ���
	public void keyReleased(KeyEvent e)
	{
		
	}
}
