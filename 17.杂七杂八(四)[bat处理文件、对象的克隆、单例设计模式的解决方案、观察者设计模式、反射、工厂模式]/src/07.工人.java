package cn.itcast.observer;

//�� ��Ҫ��������������Ӧ�Ĵ���ġ�
public class Emp implements Weather{
	
	String name;

	public Emp(String name) {
		this.name = name;
	}
	
	
	//����Ҫ��������������Ӧ�Ĵ���ġ�  "����","����","�η�","����","��ѩ"
	public void notifyWeather(String weather){
		if("����".equals(weather)){
			System.out.println(name+"�߸����˵�ȥ�ϰ�!!");
		}else if("����".equals(weather)){
			System.out.println(name+"�����������ȥ�ϰ�!");
		}else if("�η�".equals(weather)){
			System.out.println(name+"���Ŵ�ʯͷ�����ϰ�!");
		}else if("����".equals(weather)){
			System.out.println(name+"����ͷ�������ϰ�!");
		}else if("��ѩ".equals(weather)){
			System.out.println(name+"���ű��ӹ����ϰ�!");
		}
		

	}

}
