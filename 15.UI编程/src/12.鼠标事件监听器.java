package cn.itcast.event;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import cn.itcast.util.FrameUtil;

/*
 ����¼�������
 
 */
public class Demo2 {

	public static void main(String[] args) {
		JFrame frame = new JFrame("����¼�������");
		JButton button = new JButton("��ť");
		frame.add(button);
		//����ť�������¼�������
		/*button.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("����ɿ�...");
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("��갴��..");
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("����Ƴ�...");
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("������...");
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("��굥��..");
			}
		});
		
		�������������ʱ����ֻʹ�� �������¼�������ĿǰҪ��ʵ�����еķ�������
		��������� ����������������ʵ����MouseListener���������з���������ʵ�ֵķ���ȫ�����ǿ�ʵ�֡�
		*/
		
		button.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
//				System.out.println("��굥����..");
				if(e.getClickCount()==2){
					System.out.println("˫����..");
				}
				
			}
			
			
		});
		
		FrameUtil.initFrame(frame, 300, 300);
		
	}
	
}
