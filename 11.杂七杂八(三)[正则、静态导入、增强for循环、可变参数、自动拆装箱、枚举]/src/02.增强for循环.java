package cn.itcast.jdk15;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
jdk1.5出现的新特性---->增强for循环

增强for循环的作用： 简化迭代器的书写格式。(注意：增强for循环的底层还是使用了迭代器遍历。)

增强for循环的适用范围： 如果是实现了Iterable接口的对象或者是数组对象都可以使用增强for循环。

增强for循环的格式：
 	
 	for(数据类型  变量名  :遍历的目标){
 	
 	}

增强for循环要注意的事项：
	1. 增强for循环底层也是使用了迭代器获取的，只不过获取迭代器由jvm完成，不需要我们获取迭代器而已，所以在使用增强for循环变量元素的过程中不准使用集合
	对象对集合的元素个数进行修改。
	2. 迭代器遍历元素与增强for循环变量元素的区别：使用迭代器遍历集合的元素时可以删除集合的元素，而增强for循环变量集合的元素时，不能调用迭代器的remove方法删除元素。
	3. 普通for循环与增强for循环的区别：普通for循环可以没有变量的目标，而增强for循环一定要有变量的目标。

 

 */
public class Demo2 {
	
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();
		//添加元素
		set.add("狗娃");
		set.add("狗剩");
		set.add("铁蛋");
		
		/*
		//使用迭代器遍历Set的集合.
		Iterator<String> it  = set.iterator();
		while(it.hasNext()){
			String temp = it.next();
			System.out.println("元素："+ temp);
			it.remove();
		}
		
		
		//使用增强for循环解决
		for(String item : set){
			System.out.println("元素："+ item);
			
		}
		
		
		
		
		int[] arr = {12,5,6,1};
		
	 	普通for循环的遍历方式
	 	for(int i =  0 ; i<arr.length ; i++){
			System.out.println("元素："+ arr[i]);
		}
		
		//使用增强for循环实现
		for(int item :arr){
			System.out.println("元素："+ item);
		}
		
		
		
		//需求： 在控制台打印5句hello world.
		for(int i = 0 ; i < 5; i++){
			System.out.println("hello world");
		}
		*/
		
		//注意： Map集合没有实现Iterable接口，所以map集合不能直接使用增强for循环，如果需要使用增强for循环需要借助于Collection
		// 的集合。
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("001","张三");
		map.put("002","李四");
		map.put("003","王五");
		map.put("004","赵六");
		Set<Map.Entry<String, String>> entrys = map.entrySet();
		for(Map.Entry<String, String> entry  :entrys){
			System.out.println("键："+ entry.getKey()+" 值："+ entry.getValue());
		}
		
		
	}

}
