package cn.itcast.file;

import java.io.File;
import java.io.FilenameFilter;
/*
需求1 ：  指定一个文件夹，然后该文件夹下面所有java文件。

需求2： 指定一个文件夹，然后列出文件夹下面的所有子文件与文件夹，但是格式要如下:
 
文件：
	文件名1
	文件名2
	文件名3
	..

文件夹：
	文件夹名1
	文件夹名2
	文件夹名3
	....

	listFiles(FilenameFilter filter)	返回指定当前目录中符合过滤条件的子文件或子目录。对于文件这样操作会返回null。
list(fileNameFilter filter)	返回指定当前目录中符合过滤条件的子文件或子目录。对于文件这样操作会返回null。

*/

// 自定义一个文件名过滤器
class MyFilter implements FilenameFilter{

	@Override
	public boolean accept(File dir, String name) {
		//System.out.println("文件夹:"+dir+" 文件名："+ name);
		return name.endsWith(".java");
	}
	
}



public class Demo7 {
	
	public static void main(String[] args) {
		File dir = new File("F:\\1208\\day06\\代码\\day06");
		listJava2(dir);
		
	}
	
	public static void listJava2(File dir){
		File[] files = dir.listFiles(new MyFilter()); //得到文件夹下面的所有子文件与文件夹。
		for(File file : files){
			System.out.println(file.getName());
		}
	}
	
	
	
	
	//列出所有的java文件
	public static void listJava(File dir){
		File[] files = dir.listFiles(); //获取到了所有的子文件
		for(File file : files){
			String fileName = file.getName();
			/*if(fileName.endsWith(".java")&&file.isFile()){
				System.out.println(fileName);
			}*/
			
			if(fileName.matches(".+\\.java")&&file.isFile()){
				System.out.println(fileName);
			}
			
		}
	}
	
	
	
	public static void listFile(File dir){
		File[] files = dir.listFiles();//获取到所有的子文件
		System.out.println("文件：");
		for(File fileItem : files){
			if(fileItem.isFile()){
				System.out.println("\t"+fileItem.getName());
			}
		}
		
		
		System.out.println("文件假：");
		for(File fileItem : files){
			if(fileItem.isDirectory()){
				System.out.println("\t"+fileItem.getName());
			}
		}
		
		
	}
	
	
	
	
	
	
	
}
