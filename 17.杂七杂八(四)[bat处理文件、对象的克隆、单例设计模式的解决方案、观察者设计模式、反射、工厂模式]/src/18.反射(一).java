package cn.itcast.reflect;
/*
 ���䣺 ��һ���ֽ����ļ����ص��ڴ��ʱ��jvm��Ը��ֽ�����н��ʣ�Ȼ��ᴴ��һ�������Class���󣬰��ֽ����ļ�����Ϣȫ����
 �洢����Class�����У�����ֻҪ��ȡ��Class�������ǾͿ���ʹ���ֽ���������ö�������Ի��ߵ��ö���ķ����Ȳ���....

ע�⣺ �ڷ��似����һ������κγ�Ա���ж�Ӧ �������������  ���磺  ��Ա������Field��   ����----> Method��  

 */
public class Demo1 {
	
	 Person p;
	
	public static void main(String[] args) throws ClassNotFoundException {
		//Person p = new Person(110,"����");
		
		//�Ƽ�ʹ�ã� ��ȡClass����ķ�ʽһ
		Class clazz1 = Class.forName("cn.itcast.reflect.Person");
		System.out.println("clazz1:"+ clazz1);
		
		
		//��ȡClass����ķ�ʽ���� ͨ��������ȡ
		Class clazz2 = Person.class;
		System.out.println("clazz1==clazz2?"+ (clazz1==clazz2));
		
		
		//��ȡClass����ķ�ʽ�� ��ͨ�������ȡ
		Class clazz3 = new Person(110,"����").getClass();
		System.out.println("clazz2==clazz3?"+ (clazz2==clazz3));
		
	}
	
}
