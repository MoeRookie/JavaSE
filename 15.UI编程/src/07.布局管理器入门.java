package cn.itcast.layout;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import cn.itcast.util.FrameUtil;

/*
 ���ֹ�����:���ֹ����������ָ������� �ڷ�λ�õġ�
 
ÿ�ֲ��ֹ����������Լ��İڷŷ�� 
 
BorderLayout(�߿򲼾ֹ�����)

	�ڷŵķ�� �ϱ�  �� ���� �� ������ �Ҷ� �� �� 

Borderlayout Ҫע������
	1. ʹ��Borderlayout��������ʱ�����û��ָ������ķ�λ����ôĬ����ӵ��м��λ���ϡ�
	2. ʹ��BorderLayout��ʱ��������������Ǹ�����û�ж�Ӧ ���������ô�м�λ�õ�����ͻ�ռ�����ȱ��λ�á�
	3. ����Ĭ�ϵĲ��ֹ���������Borderlayout.
	
 */
public class Demo1 {

	public static void main(String[] args) {
		JFrame frame = new JFrame("�߿�ֲ�������");
		//����һ���߿򲼾ֹ�����
		BorderLayout borderLayout = new BorderLayout();
		//��borderlayout����frame���塣
		frame.setLayout(borderLayout);
		
		frame.add(new JButton("��"),BorderLayout.NORTH);
		frame.add(new JButton("��"),BorderLayout.SOUTH);
		frame.add(new JButton("��"),BorderLayout.WEST);
		frame.add(new JButton("��"),BorderLayout.EAST);
		frame.add(new JButton("��"),BorderLayout.CENTER);
		//��ʼ������
		FrameUtil.initFrame(frame, 300, 300);
	}
	
}
