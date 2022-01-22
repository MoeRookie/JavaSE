package cn.itcast.observer;

import java.util.ArrayList;
import java.util.Random;
/*
 �۲������ģʽ���۲������ģʽ���������ʱ��һ��������ָ���Ķ���ʱ��Ҫͨ������һ������������Ӧ�Ĵ���
 
���� ��дһ������վ��һ�����������࣬������վ�������� ��ʱ��Ҫ֪ͨ��������Ӧ�Ĵ���
  

 ����1�� ����վ�����˶��������Ȼ���˲���һ�εĴ���
 
����2�� Ŀǰ����վֻ��֪ͨһ���˶��ѡ�

����3�� ����ʵ�����г��˹���Ⱥ��Ҫ��ע���������� ��Ⱥ��Ҳ��Ҫ��ע����


�۲������ģʽ�Ĳ��裺
	1. ��ǰĿǰ������ָ���Ķ����ǣ�Ҫ֪ͨ����һ������������Ӧ�Ĵ�����ʱ��Ӧ�ðѶԷ�����Ӧ�����������ڽӿ��ϡ�
	2. �ڵ�ǰ����ά���ӿڵ����ã�����ǰ������ָ���Ķ�����ʱ�򼴿ɵ��ýӿ��еķ����ˡ�


 */

//����վ
public class WeatherStation {
	
	String[] weathers = {"����","����","�η�","����","��ѩ"};
	
	//��ǰ����
	String  weather ;
	
	//�ü����д洢�Ķ�����Ҫ��������Ԥ������
	ArrayList<Weather> list = new ArrayList<Weather>();  //������ƽ��������---->������Ҫ��һ�����������������һ���ࡣ
	
	
	
	public void addListener(Weather e){
		list.add(e);
	}
	
	
	//��ʼ����
	public void startWork() {
		final Random random = new Random();
		
		new Thread(){	
			@Override
			public void run() {
				while(true){ 
					updateWeather(); // ÿ1~1.5�����һ������  1000~1500
					for(Weather e : list){
						e.notifyWeather(weather);
					}

					int  s = random.nextInt(501)+1000; //  500
					try {
						Thread.sleep(s);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}				
			}
			
		}.start();
		
	}
	
	
	
	//���������� ����
	public void updateWeather(){
		Random random = new Random();
		int index = random.nextInt(weathers.length);
		weather = weathers[index];
		System.out.println("��ǰ�������ǣ� " + weather);
	}
	
}
