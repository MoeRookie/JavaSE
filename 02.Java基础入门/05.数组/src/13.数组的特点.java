/*
数组的特点：
	1. 数组只能存储同一种 数据类型的数据。
	2. 数组是会给存储到数组中 的元素分配一个索引值的，索引值从0开始，最大的索引值是length-1；
	3. 数组一旦初始化，长度固定。
	4. 数组中的元素与元素之间的内存地址是连续的。

*/
class Demo17 
{
	public static void main(String[] args) 
	{
		int[] arr = new int[3];
		arr = new int[4]; 
		System.out.println(arr.length);
	}
}
