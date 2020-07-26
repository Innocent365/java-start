package io.charstream;



import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * java.io.PrintWriter
 * 缓冲字符输出流
 * 特点：允许以行单位写出字符串。
 * 提供了很多方便的构造方法，允许我们快速创建该流
 * @author Administrator
 *
 */
public class PrintWriterDemo {
	public static void main(String[] args) throws IOException {
		/*
		 * 支持两个直接向文件中写入数据的构造方法
		 * PrintWriter(File file)
		 * PrintWriter(String filepath)
		 * 
		 * 看似是可以直接向文件中写入，但事实上其构造方法中会创建FOS向文件中写。
		 * 只是我们不用层层嵌套来组装不同的高级流而已。
		 * 
		 * 若希望按照指定的字符集写出字符串到文件中那么以上两个构造方法都支持一个重载，
		 * 重载的构造方法可以传入第二个参数，来指定字符集。
		 */
		PrintWriter pw  = new PrintWriter("pw.txt","UTF-8");
		
		pw.println("摩擦摩擦，是魔鬼的步伐!");
		pw.println("哎呦我去滑板鞋！");
		
		System.out.println();
		
		pw.close();
	}

	@Test//处理其他流
	public void main() throws IOException {
		/*
		 * PrintWriter(OutputStream out) 可以处理给定的"字节"输出流，变为一个缓冲字符输出流
		 *
		 * PrintWriter(Writer out) 处理给定的"字符"输出流，变为一个缓冲字符输出流
		 */
		FileOutputStream fos = new FileOutputStream("pw2.txt");
		//若希望按照指定字符集写出，创建该字符流做转换
		OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");

		PrintWriter pw = new PrintWriter(osw);
		pw.println("啦啦啦啦");

		pw.close();
	}

	@Test//PrintWriter的特点：具有自动行刷新功能
 		//当我们使用PrintWriter去处理一个流的时候，可以将PrintWriter声明为具有自动行刷新功能。
	public void test3() throws IOException {
		FileOutputStream fos = new FileOutputStream("pw3.txt");

		OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
		/*
		 * 当调用的构造方法第一个参数为流时，那么支持传入第二个参数，该参数为boolean类型
		 * 若值为true,那么当前PrintWriter就具有了自动行刷新功能。
		 */
		PrintWriter pw  = new PrintWriter(osw,true);
		/*
		 * 当具有了自动行刷新功能的PW在调用println方法写出字符串的时候会自动调用flush强制写出。
		 */
		pw.println("你好!");
		pw.println("再见!");

		pw.close();
	}
}









