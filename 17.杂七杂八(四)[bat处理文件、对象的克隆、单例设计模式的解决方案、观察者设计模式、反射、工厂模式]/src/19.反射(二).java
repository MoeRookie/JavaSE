package cn.itcast.reflect;

import java.lang.reflect.Constructor;

/*
 ���ͨ��Class�����ȡ���췽����
 */
public class Demo2 {
	
	public static void main(String[] args) throws Exception {
		//��ȡ����Ӧ��Class����
		Class clazz = Class.forName("cn.itcast.reflect.Person");
		
		//ͨ��Class�����ȡ��Ӧ�Ĺ��췽��
		/*Constructor[] constructors = clazz.getConstructors();  // getConstructors()��ȡһ��������й����Ĺ��췽��
		for(Constructor constructor : constructors){
			System.out.println(constructor);
		}
		
		Constructor[] constructors =  clazz.getDeclaredConstructors(); //��ȡ��һ��������й��췽��������˽�е����� ��
		for(Constructor constructor : constructors){
			System.out.println(constructor);
		}
		*/
		
		/*Constructor constructor = clazz.getConstructor(int.class,String.class);  // getConstructor ��ȡ����ָ���Ĺ��췽����
		Person p  = (Person) constructor.newInstance(999,"С��"); // newInstance()����һ������
		System.out.println(p);*/
		
		
		
		//��ȡ˽�еĹ��캯��
		Constructor constructor =  clazz.getDeclaredConstructor(null);
		//��������
		constructor.setAccessible(true);
		Person p  =(Person) constructor.newInstance(null);
		System.out.println(p);
		
		
	}

}
