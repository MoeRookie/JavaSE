package cn.itcast.observer;

import java.util.Random;

public class WeatherMain {

	public static void main(String[] args) throws Exception {
		//����
		Emp e = new Emp("С��");
		Emp e2 = new Emp("�绨");
		
		//ѧ��
		Student s1 = new Student("����");
		Student s2 = new Student("��ʣ");
		
		
		WeatherStation station = new WeatherStation();
		station.addListener(e);
		station.addListener(e2);
		station.addListener(s1);
		station.addListener(s2);
		
		
		
		station.startWork();
		
		
	}
	
}
