package cn.itcast.observer;

public class Student implements Weather{
	
	String name;

	public Student(String name) {
		super();
		this.name = name;
	}
	
	
	public void notifyWeather(String weather){
		if("����".equals(weather)){
			System.out.println(name+"�߸����˵�ȥ��ѧ!!");
		}else if("����".equals(weather)){
			System.out.println(name+"��������ȥ��ѧ!");
		}else if("�η�".equals(weather)){
			System.out.println(name+"�ڼ�˯��!");
		}else if("����".equals(weather)){
			System.out.println(name+"�ڼ�˯��!");
		}else if("��ѩ".equals(weather)){
			System.out.println(name+"��������ȥ��ѧ!");
		}
		

	}
	
}
