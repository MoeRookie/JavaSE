package cn.itcast.compnent;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
/*
 �˵����
 	
 	�˵���(MenuBar) ��  �˵���Menu�� �� �˵���(MenuItem)
 	
 	�˵���������Ӳ˵�
 	
 	�˵�������Ӳ˵���
 	
 	��ѡ�˵���
 		���Ȳ˵���Ӳ˵� �� �˵���Ӳ˵��
 	
 	
 */
import javax.swing.JTextArea;

import cn.itcast.util.FrameUtil;


public class Demo2 {
	
	JFrame frame = new JFrame("���±�");
	
	//�˵���
	JMenuBar bar = new JMenuBar();
	
	//�ļ��˵�
	JMenu fileMenu = new JMenu("�ļ�");
	JMenu editMenu  = new JMenu("�༭");
	
	JMenu switchMenu = new JMenu("�л�����Ŀ¼");
	
	
	//�˵���
	JMenuItem openMenu = new JMenuItem("��");
	JMenuItem saveMenu = new JMenuItem("����");
 
	JMenuItem aboutMenu = new JMenuItem("����");
	JMenuItem closeMenu = new JMenuItem("�ر�");
	
	
	JMenuItem  workMenu1 = new JMenuItem("0910project");
	JMenuItem  workMenu2 = new JMenuItem("1208project");
	JMenuItem  workMenu3 = new JMenuItem("1110project");
	
	
	
	JTextArea area = new JTextArea(20,30);
	
	public void initNotepad(){
		//�˵���Ӳ˵���Ŀ
		fileMenu.add(openMenu);
		fileMenu.add(saveMenu);
		
		editMenu.add(aboutMenu);
		editMenu.add(closeMenu);
		
		//��ѡ�˵�
		switchMenu.add(workMenu1);
		switchMenu.add(workMenu2);
		switchMenu.add(workMenu3);
		//�˵���Ӳ˵����Ǹ�ѡ�˵�
		fileMenu.add(switchMenu);
		
		
		
		//�˵�����Ӳ˵�
		bar.add(fileMenu);
		bar.add(editMenu);
		
		//��Ӳ˵���
		frame.add(bar,BorderLayout.NORTH);
		frame.add(area);
		FrameUtil.initFrame(frame, 500, 600);
	}
	
	public static void main(String[] args) {
		new Demo2().initNotepad();
	}
	
	
}
