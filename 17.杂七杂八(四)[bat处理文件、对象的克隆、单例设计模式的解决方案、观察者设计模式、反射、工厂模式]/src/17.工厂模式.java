package cn.itcast.factory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import cn.itcast.reflect.Person;

/*
�������ģʽ�������ڲ������� �ġ�
*/
class Car{}

class BMW extends Car{}

class BSJ extends Car{}



public class Demo1 {

	public static void main(String[] args) throws Exception {
		Person p = (Person) getInstance();
		System.out.println(p);
	}
	
	//���� ��дһ�������������������ļ����ض�Ӧ�Ķ���
	public static Object getInstance() throws Exception{
		//��ȡ�����ļ�
		BufferedReader bufferedReader = new BufferedReader(new FileReader("info.txt"));
		//��ȡ��һ�� : ��ȡ���ļ�����Ϣ
		String className = bufferedReader.readLine();
		//ͨ������������ȡ��Ӧ ��Class����
		Class clazz = Class.forName(className);
		//��ȡ����Ӧ�Ĺ��췽��
		Constructor constructor = clazz.getDeclaredConstructor(null);
		constructor.setAccessible(true);
		Object o  = constructor.newInstance(null);
		//���������ö�Ӧ������ֵ
		String line = null;
		while((line = bufferedReader.readLine())!=null){
			String[] datas = line.split("=");
			Field field =clazz.getDeclaredField(datas[0]);
			//���ÿ��Է���
			field.setAccessible(true);
			if(field.getType()==int.class){
				field.set(o, Integer.parseInt(datas[1]));
			}else{
				field.set(o, datas[1]);
			}
		}
		return o;
		
	}
	
	
}
