package cn.itcast.event;

import java.awt.BorderLayout;
import java.awt.ScrollPane;
import java.awt.Scrollbar;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import cn.itcast.util.FrameUtil;

public class FileSearch {
	
	JFrame frame = new JFrame("�ļ�������");
	
	JPanel panel = new JPanel();
	
	JTextField field = new JTextField("������Ŀ¼��...",15);
	
	JButton button = new JButton("����");
	
	JTextArea area = new JTextArea(15,15);
	
	//������
	ScrollPane bar = new ScrollPane();
	
	
	
	public void init(){
		//�Ȱ�area��� ���������ϡ�
		bar.add(area);
		//�Ȱ������ӵ�panel��
		panel.add(field);
		panel.add(button);
		
		//�����������¼�
		field.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				JTextField field =  (JTextField) e.getSource();
				if(field.getText().equals("������Ŀ¼��...")){
					field.setText("");
				}
			}
		});
		
		//����ť����¼�������
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//��ȡ����������·��
				String path = field.getText();
				//ʹ�������·������һ��FIle����
				File dir = new File(path);
				//�ҵ�Ŀ¼�µ������� �ļ�
				File[] files = dir.listFiles();
				for(File file : files){ // 1208Project  ����
					area.setText(area.getText()+ file.getName()+"\r\n");
				}
			}
		});
		
		
		
		//�������ӵ�frame��
		frame.add(panel,BorderLayout.NORTH);
		frame.add(bar);		
		FrameUtil.initFrame(frame, 300, 400);
	}
	
	public static void main(String[] args) {
		new FileSearch().init();
		
		
	}
	
	
	

}
