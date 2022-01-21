package cn.itcast.layout;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import cn.itcast.util.FrameUtil;

/*
��Ƭ���ֹ�����(CardLayout)
 */


public class Demo4 {

	public static void main(String[] args) {
		JFrame frame = new JFrame("��Ƭ���ֹ�����");
		final JPanel panel = new JPanel();
		frame.add(panel);
		
		//����һ����Ƭ���ֹ�����
		final CardLayout cardLayout = new CardLayout();
		panel.setLayout(cardLayout);
		
		//������������
		JButton button = new JButton("����A");
		panel.add(button);
		panel.add(new JButton("����K"));
		panel.add(new JButton("÷��6"));
		panel.add(new JButton("����2"));
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.next(panel);  //��һ��
//				cardLayout.previous(parent);  ��һ��
			}
		});
		
		
		//��ʼ������
		FrameUtil.initFrame(frame,300, 300);
		
		
		
		
		
		
	}
	
}
