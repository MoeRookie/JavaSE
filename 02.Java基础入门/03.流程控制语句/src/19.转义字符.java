/*
转义字符：特殊字符使用”\”把其转化成字符的本身输出，那么使用”\”的字符称作为转移字符。

需求： 在控制台上打印一个 hello" world 

常见的转义字符有：
	\b	Backspace （退格键）
	\t	Tab    制表符(制表符的作用就是为了让一列对齐)  一个tab一般等于四个空格。
	
	\n	换行
	\r	回车  把光标移动到一行的首位置上。
	
注意： 如果是在windows系统上操作文件的时候需要换行，是需要\r\n一起使用的。
如果是在其他的操作系统上需要换行，仅需要\n即可。

*/
import java.io.*;
class Demo16 {

	public static void main(String[] args) throws Exception
	{
		//System.out.println("Hello哈哈\rworld!");

		File file = new File("F:\\a.txt");
		FileWriter  out = new FileWriter(file);
		out.write("大家好\r\n");
		out.write("你们好");
		out.close();


	}
}
