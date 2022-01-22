package cn.itcast.copy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
��������¡�� ��������¡�������ö��������������Ѷ�����д���ļ��ϣ�Ȼ���ٶ�ȡ�����
��Ϣ������̾ͳ���Ϊ��������¡��
	
	ObjectInputStream
	ObjectOutputStream 

 */
public class Demo2 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Address address = new Address("����");
		Person p1 = new Person(110,"����",address);
		writeObj(p1);
		Person p2  =readObj();
		
		p2.address.city = "��ɳ";
		System.out.println("p1:"+ p1);
		System.out.println("p2:"+ p2);
		
		
	}
	
	
	//�ٴ��ļ��ж�ȡ�������Ϣ
	public static Person readObj() throws ClassNotFoundException, IOException{
		FileInputStream fileInputStream = new FileInputStream("F:\\obj.txt");
		//�������������������
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		return (Person) objectInputStream.readObject();
	}
	
	
	//��Ҫ�Ѷ���д���ļ��ϡ�
	public static void writeObj(Person p) throws IOException{
		//����һ���ļ� �����������
		FileOutputStream fileOutputStream  = new FileOutputStream("F:\\obj.txt");
		//��������������
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		//�Ѷ���д��
		objectOutputStream.writeObject(p);
		//�ر���Դ
		objectOutputStream.close();
		
	}
	
	
	
}
