package cn.itcast.compnent;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import cn.itcast.util.FrameUtil;

/*
 ���������:
 */

public class Demo1 {
	
	public static void main(String[] args) {
		JFrame frame= new JFrame("ע��");
		//����һ�����
		JPanel panel = new JPanel();
		frame.add(panel); 
		//�û���
		JLabel nameLabel = new JLabel("�û���");
		//�û����������
		JTextField nameField = new JTextField(12);
		//���û����������ӵ������
		panel.add(nameLabel);
		panel.add(nameField);
		
		//����
		JLabel passLabel= new JLabel("����");
		//�����
		JPasswordField passField = new JPasswordField(12);
		//������������ӵ����
		panel.add(passLabel);
		panel.add(passField);
		
		//�Ա�--��ѡ��
		JLabel sexLabel = new JLabel("�Ա�");
		JRadioButton man = new JRadioButton("��",true);
		JRadioButton woman = new JRadioButton("Ů");
		//����ǵ�ѡ�����Ҫ���з��飬ͬһ����ĵ�ѡ��ֻ��ѡ�����е�һ��
		ButtonGroup group = new ButtonGroup();
		group.add(woman);
		group.add(man);
		//���Ա������ӵ������
		panel.add(sexLabel);
		panel.add(man);
		panel.add(woman);
		
		//���Գ���--->������
		JLabel cityLabel = new JLabel("���Եĳ���");
		Object[]  arr = {"����","�Ϻ�","����","����","տ��"};
		JComboBox citys = new JComboBox(arr);
		panel.add(cityLabel);
		panel.add(citys);
		
		//��Ȥ����---->��ѡ��
		JLabel hobitLabel = new JLabel("��Ȥ����:");
		JCheckBox checkBox1 = new JCheckBox("����",true);
		JCheckBox checkBox2 = new JCheckBox("java",true);
		JCheckBox checkBox3 = new JCheckBox("javascript");
		JCheckBox checkBox4 = new JCheckBox("android");
		panel.add(hobitLabel);
		panel.add(checkBox1);
		panel.add(checkBox2);
		panel.add(checkBox3);
		panel.add(checkBox4);
		
		
		//���˼��
		JLabel jLabel = new JLabel("���˼��");
		JTextArea area = new JTextArea(20, 15);
		area.setLineWrap(true); //�����Զ����� 
		panel.add(jLabel);
		panel.add(area);
		
		FrameUtil.initFrame(frame, 500, 400);
	}
	
	
}
