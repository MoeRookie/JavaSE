package cn.itcast.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
/*
 �¼��� ��������ĳ���¼���ʱ�򣬾ͻ�����Ӧ��������
 
 
 	�¼�Դ         ������            �¼�            ������
 
 */



import cn.itcast.util.FrameUtil;


public class Demo1 {

	public static void main(String[] args) {
		JFrame frame = new JFrame("����");
		JButton button = new JButton("���Ұ�");
		frame.add(button);
		//����ť��Ӷ���������     ����ʱ�����������������Լ��ո�����������õġ�
		button.addActionListener(new ActionListener() {
			
			//����ť�������ʱ�򣬾ͻ����actionPerformed�ķ����� 
			@Override
			public void actionPerformed(ActionEvent e) {  // ActionEvent ��ǰ��ť�������ʱ��jvm�ͻ�Ѷ�Ӧ ��ʱ�䴫��ActionEvent�����ҵ���actionPerformed������
				//System.out.println("��ѽ��������...");
				JButton button =(JButton) e.getSource(); //getSource() ��ȡ���¼�Դ
				if(button.getText().equals("���Ұ�")){
					button.setText("������");
				}else{
					button.setText("���Ұ�");
				}
				
			}
		});
		
		
		
		FrameUtil.initFrame(frame, 200, 200);
		
		
		
	}
	
	
}
