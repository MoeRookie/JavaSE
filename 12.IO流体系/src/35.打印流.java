package cn.itcast.other;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/*
打印流（printStream）  打印流可以打印任意类型的数据，而且打印数据之前都会先把数据转换成字符串再进行打印。
 
 */

class Animal{
	
	String name;
	
	String color;
	
	public Animal(String name,String color){
		this.name = name;
		this.color = color;
	}
	
	@Override
	public String toString() {
		return "名字："+this.name+ " 颜色："+ this.color;
	}
	
}



public class Demo6 {
	
	public static void main(String[] args) throws IOException {
		/*FileOutputStream fileOutputStream = new FileOutputStream("F:\\a.txt");
		fileOutputStream.write("97".getBytes());
		fileOutputStream.close();*/
		
		
		//打印流可以打印任何类型的数据，而且打印数据之前都会先把数据转换成字符串再进行打印。
		File file = new  File("F:\\a.txt");
		//创建一个打印流
		PrintStream printStream = new PrintStream(file);
		/*
		printStream.println(97);
		printStream.println(3.14);
		printStream.println('a');
		printStream.println(true);
		Animal a = new Animal("老鼠", "黑色");
		printStream.println(a);
		
		
		//默认标准的输出流就是向控制台输出的，
		System.setOut(printStream); //重新设置了标准的输出流对象
		System.out.println("哈哈，猜猜我在哪里！！");
		*/
		
		//收集异常的日志信息。
		File logFile = new File("F:\\2015年1月8日.log");
		PrintStream logPrintStream = new PrintStream( new FileOutputStream(logFile,true) );
		try{
			int c = 4/0;
			System.out.println("c="+c);
			int[] arr = null;
			System.out.println(arr.length);
			
		}catch(Exception e){
			e.printStackTrace(logPrintStream);
			
		}
		
		
		
	}

}
