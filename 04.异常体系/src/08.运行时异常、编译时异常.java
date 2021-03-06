/*

异常体系：
--------| Throwable  所有错误或者异常的父类
--------------| Error（错误）
--------------| Exception(异常) 异常一般都通过代码处理 

------------------| 运行时异常: 如果一个方法内部抛出了一个运行时异常，那么方法上 可以声明也可以不 声明，调用者可以以处理也可以不处理。
------------------| 编译时异常(非运行时异常、受检异常):  如果一个方法内部抛出了一个编译时异常对象，那么方法上就必须要声明，而且调用者也必须要处理。

运行时异常： RuntimeException以及RuntimeException子类 都是属于运行时异常。

编译时异常： 除了运行时异常就是编译异常。


疑问： 为什么java编译器会如此严格要求编译时异常，对运行时异常如此宽松？

	运行时异常都是可以通过程序员良好的编程习惯去避免，所以java编译器就没有严格要求处理运行时异常。


*/
import java.security.acl.*;
class Demo4 
{
	public static void main(String[] args) throws InterruptedException
	{
			int[] arr = null;
			div(4,0,arr);
		
		 Object o = new Object();
		 o.wait();
	}


	public static void div(int a , int b ,int[] arr) {
		if(b==0){
			return;
		}
		int c = a/b;
		System.out.println("c = "+c);

		if(arr!=null){
			System.out.println("数组的长度： "+arr.length);
		}
	}
}
