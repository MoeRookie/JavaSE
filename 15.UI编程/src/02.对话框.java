package cn.itcast.frame;

import java.awt.Dialog;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import cn.itcast.util.FrameUtil;

/*
 �Ի�����(Dialog):
 
 	JDialog(Dialog owner, String title, boolean modal) 
 	
 	owner: ������
 	
 	title : ����
 	
 	modal : modal
 
JOptionPane(�Ի���)
	��Ϣ�Ի���
	����Ի���
	����Ի���
	����Ի���
	ȷ�϶Ի���
	

 
 */
public class Demo2 {

	public static void main(String[] args) {
		/*JFrame frame = new JFrame("����");
		//�����Ի���
		JDialog dialog = new JDialog(frame, "�Ի���",true);
		//ʹ�����Զ���� ���幤����
		FrameUtil.initFrame(frame, 300, 400);
		
		dialog.setBounds(500,300, 100, 200);
		dialog.setVisible(true); //���öԻ���Ŀɼ���
*/		
		
		JFrame frame = new JFrame("����");
		//��ʾһ���Ի���
		FrameUtil.initFrame(frame, 300, 400);
		//��Ϣ�Ի���
		/*JOptionPane.showMessageDialog(frame, "���첻���Ͽ�", "֪ͨ",JOptionPane.INFORMATION_MESSAGE);
		//����Ի���
		JOptionPane.showMessageDialog(frame,"����ĳλͬѧ��������ϰ��Ҫ������","����",JOptionPane.WARNING_MESSAGE);*/
		//����Ի���
//		JOptionPane.showMessageDialog(frame,"��6��","����",JOptionPane.ERROR_MESSAGE);
		
		//�����
	/*	String moeny = JOptionPane.showInputDialog("��������Ҫ���ҵĽ��($)");
		System.out.println("money:"+ moeny);*/
		
		//ȷ�Ͽ�
		int num = JOptionPane.showConfirmDialog(frame, "��ȷ��Ҫж����");
		System.out.println(num);
	}
	
}
