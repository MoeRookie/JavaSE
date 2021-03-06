package cn.itcast.factory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import cn.itcast.reflect.Person;

/*
工厂设计模式就是用于产生对象 的。
*/
class Car{}

class BMW extends Car{}

class BSJ extends Car{}



public class Demo1 {

	public static void main(String[] args) throws Exception {
		Person p = (Person) getInstance();
		System.out.println(p);
	}
	
	//需求： 编写一个工厂方法根据配置文件返回对应的对象。
	public static Object getInstance() throws Exception{
		//读取配置文件
		BufferedReader bufferedReader = new BufferedReader(new FileReader("info.txt"));
		//读取第一行 : 读取类文件的信息
		String className = bufferedReader.readLine();
		//通过完整类名获取对应 的Class对象
		Class clazz = Class.forName(className);
		//获取到对应的构造方法
		Constructor constructor = clazz.getDeclaredConstructor(null);
		constructor.setAccessible(true);
		Object o  = constructor.newInstance(null);
		//给对象设置对应的属性值
		String line = null;
		while((line = bufferedReader.readLine())!=null){
			String[] datas = line.split("=");
			Field field =clazz.getDeclaredField(datas[0]);
			//设置可以访问
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
