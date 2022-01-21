package cn.itcast.layout;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import cn.itcast.util.FrameUtil;

/*
 ��񲼾ֹ�����(GridLayout)
 
 ע������ ��������������ʹ��ʱ��Ĭ�ϻ���һ�С�
 
 
 */
public class Demo3 {

	public static void main(String[] args) {
		JFrame frame = new JFrame("������");
		//������񲼾ֹ�����
		GridLayout gridLayout = new GridLayout(4, 4, 1, 2);
		
		//�ô��彻����񲼾ֹ���������
		frame.setLayout(gridLayout);
		for(int i = 0 ; i<10; i++){
			frame.add(new JButton(i+""));
		}
		frame.add(new JButton("+"));
		frame.add(new JButton("-"));
		frame.add(new JButton("*"));
		frame.add(new JButton("/"));
		frame.add(new JButton("="));
		frame.add(new JButton("."));
		
//		frame.add(new JButton("aa"));
		
		//��ʼ������
		FrameUtil.initFrame(frame, 300, 300);
		
		
		
	}
	
}
