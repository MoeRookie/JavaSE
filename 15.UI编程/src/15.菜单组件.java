package cn.itcast.event;

import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

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


public class Notepad {
	
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
	
	
	
	TextArea area = new TextArea(20,30);
	
	public void initNotepad(){
		//�˵���Ӳ˵���Ŀ
		fileMenu.add(openMenu);
		fileMenu.add(saveMenu);
		
		
		//����������¼�
		saveMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					FileDialog fileDialog = new FileDialog(frame, "��ѡ�񱣴��·��",FileDialog.SAVE);
					fileDialog.setVisible(true);
					
					//��ȡ�û�ѡ���·�����ļ���
					String path = fileDialog.getDirectory();
					String fileName = fileDialog.getFile();
					//����һ���������
					FileOutputStream fileOutputStream = new FileOutputStream(new File(path,fileName));
					
					//��ȡ�ı�������ݣ�������д��
					String content = area.getText();
//					content = content+"\r\n";
//					content = content.replaceAll("\n", "\r\n");
					fileOutputStream.write(content.getBytes());
					//�ر���Դ
					fileOutputStream.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		
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
		new Notepad().initNotepad();
	}
	
	
}
