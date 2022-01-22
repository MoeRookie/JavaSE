package cn.itcast.reflect;

import java.lang.reflect.Method;

/*
 ͨ��Class�����ȡ����Ӧ�ķ�����
 
 �ڷ��似����ʹ����Method�������˷����ġ�
 
 */
public class Demo3 {
	
	public static void main(String[] args) throws Exception {
		//��ȡ����Ӧ��Class����
		Class clazz = Class.forName("cn.itcast.reflect.Person");
		//��ȡ�����й����ķ���
		/*Method[] methods = clazz.getMethods(); // getMethods() ��ȡ���� �Ĺ����������ѡ�
		Method[] methods = clazz.getDeclaredMethods(); //��ȡ�����еķ��������ǲ���������ķ�����
		for(Method method  : methods){
			System.out.println(method);
		}*/
		
		Person p = new Person(110,"����");
		/*	
		Method m = clazz.getMethod("eat", int.class);
		m.invoke(p, 3); //invoke ִ��һ�������� ��һ�������������ĵ��ö��� �ڶ������� ��������Ҫ�Ĳ�����
		
		
		//ִ��˽�еķ���
		Method m =clazz.getDeclaredMethod("sleep",int.class);
		//���÷���Ȩ���������
		m.setAccessible(true);
		m.invoke(null, 6);*/
		
		Method m = clazz.getMethod("sum", int[].class);
		m.invoke(p,new int[]{12,5,9});
		
	}
	

}
