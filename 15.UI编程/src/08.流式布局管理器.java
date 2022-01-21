package cn.itcast.layout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import cn.itcast.util.FrameUtil;

/*
��ʽ���ֹ�����(FlowLayout)

��ʽ���ֹ�����Ҫע������
	1. ��ʽ���ֹ�����Ĭ������Ǿ��ж���ġ�
	2. panelĬ�ϵľֲ�����������FlowLayout.
 */
public class Demo2 {

	public static void main(String[] args) {
		JFrame frame = new JFrame("����");
		//�������
		JPanel panel = new JPanel();
		frame.add(panel);
		//����һ����ʽ���ֹ�����
		FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT, 0, 30);// FlowLayout.LEFT ָ������ķ�ʽ��
		//����ʽ���ֹ���������frame����
		panel.setLayout(flowLayout);
		
		panel.add(new JButton("��ť1"));
		panel.add(new JButton("��ť2"));
		panel.add(new JButton("��ť3"));
		panel.add(new JButton("��ť4"));
		
		//��ʼ������
		FrameUtil.initFrame(frame, 300, 300);
		
	}
	
}
