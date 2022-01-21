package cn.itcast.snake;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Random;

public class SnakeGame {
	
	//��ͼ�Ŀ�(����)
	public static final int WIDTH = 35;
	
	//��ͼ�ߣ�������
	public static final int HEIGHT = 9;	
	
	
	//��ͼ
	private char[][] background = new char[HEIGHT][WIDTH];
	
	//ʹ�ü��ϱ����߽ڵ��������Ϣ
	LinkedList<Point>  snake = new LinkedList<Point>(); 
	
	
	//ʳ��
	Point	food;
	
	
	//�����ƶ�
	public void moveUp(){
		//��ȡԭ����ͷ 
		Point head = snake.getFirst();
		//����µ���ͷ
		snake.addFirst(new Point(head.x,head.y-1));
		//ɾ����β
		snake.removeLast();
	}
	
	//������
	public void moveDown(){
		//��ȡ��ԭ������ͷ
		Point  head = snake.getFirst();
		//����µ���ͷ
		snake.addFirst(new  Point(head.x,head.y+1));
		//ɾ����β
		snake.removeLast();
	}
	
	
	//������
	public void moveLeft(){
		//��ȡ��ԭ������ͷ
		Point  head = snake.getFirst();
		//����µ���ͷ
		snake.addFirst(new  Point(head.x-1,head.y));
		//ɾ����β
		snake.removeLast();
	}
	
		
		
	//������
	public void moveRight(){
		//��ȡ��ԭ������ͷ
		Point  head = snake.getFirst();
		//����µ���ͷ
		snake.addFirst(new  Point(head.x+1,head.y));
		//ɾ����β
		snake.removeLast();
	}

	
	
	//����ʳ�� 
	public void createFood(){
		//����һ�����������
		Random random = new Random();
		while(true){
			int x = random.nextInt(WIDTH); 
			int y = random.nextInt(HEIGHT);
			if(background[y][x]!='*'){
				food = new Point(x,y);
				break;
			}
		}
	}
	
	//��ʾʳ��
	public void showFood(){
		background[food.y][food.x] ='@';
	}
	

	
	//��ʼ����
	public void initSnake(){
		int x = WIDTH/2;
		int y = HEIGHT/2;
		snake.addFirst(new Point(x-1,y));
		snake.addFirst(new Point(x,y));
		snake.addFirst(new Point(x+1,y));
	}
	
	
	//��ʾ��--->ʵ���Ͼ��ǽ��߽ڵ� ��������Ϣ��������ͼ�ϣ��ڵ�ͼ�ϻ��϶�Ӧ���ַ�����
	public void showSnake(){
		//ȡ����ͷ
		Point head = snake.getFirst();
		background[head.y][head.x] = '$';
		//������
		for(int i =1; i<snake.size() ; i++ ){
			Point body = snake.get(i);
			background[body.y][body.x] = '#';
			
		}
		
	}
	
	
	
	
	//��ʼ����ͼ
	public void initBackground(){
		for(int rows = 0 ; rows<background.length ; rows++){
			for(int cols = 0  ; cols<background[rows].length ; cols++ ){
				if(rows==0||rows==(HEIGHT-1)||cols==0||cols==(WIDTH-1)){  //��һ�С����һ�С� ��һ�������һ��
					background[rows][cols] = '*';
				}else{
					background[rows][cols] = ' ';
				}
			}
		}
	}


	//��ʾ��ͼ��
	public void showBackground() {
		//��ӡ��ά����
		for(int rows = 0 ; rows<background.length ; rows++){ // rows =0 
			for(int cols = 0  ; cols<background[rows].length ; cols++ ){
				System.out.print(background[rows][cols]);
			}
			System.out.println(); //����
		}
	}
	
	//ˢ����Ϸ ��״̬ 
	public void refrash(){
		//�����Ϸ֮ǰ������״̬��Ϣ
		initBackground();
		//�������µ�״̬��������ͼ��
		showSnake();
		//��ʳ�����Ϣ��������ͼ��ɥ��
		showFood();
		//��ʾ��ǰ��ͼ����Ϣ
		showBackground();
		
	}
	
	

	
	public static void main(String[] args) throws Exception {
		SnakeGame snake = new SnakeGame();
		//��ʼ����ͼ
		snake.initBackground();
		//��ʼ����
		snake.initSnake(); 
		//���ߵ���Ϣ��������ͼ��
		snake.showSnake();
		
		//��ʼ������
		snake.createFood();
		//��ʾʳ��
		snake.showFood();
		snake.showBackground();
		
		//��������
		for(int i = 0;  i < 3; i++){
			snake.moveUp();
			snake.refrash();
			Thread.sleep(500);
		}
		
		//��������
		for(int i = 0;  i < 3; i++){
			snake.moveDown();
			snake.refrash();
			Thread.sleep(500);
		}
		
		

		//��������
		for(int i = 0;  i < 3; i++){
			snake.moveRight();
			snake.refrash();
			Thread.sleep(500);
		}
		
		//��������
		for(int i = 0;  i < 3; i++){
			snake.moveLeft();
			snake.refrash();
			Thread.sleep(500);
		}
		
		

		
		
	}

}
