package cn.itcast.reflect;

public class Person {
	
	private int id;
	
	String name;
	
	public Person(int id,String name){
		this.id = id;
		this.name = name;
	}
	
	public Person(){}
	
	
	public void eat(int num){
		System.out.println(name+"�Ժ�"+num+"�ﷹ");
	}
	
	private static void sleep(int num){
		System.out.println("����˯��"+num+"Сʱ");
	}
	
	
	public static void  sum(int[] arr){
		System.out.println("�����ǣ�"+ arr.length);
	}
	
	
	@Override
	public String toString() {
		return " ��ţ�"+ this.id +" ������"+ this.name;
	}
	
}
