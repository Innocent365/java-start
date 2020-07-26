package io.charstream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

/**
 * OutputStreamWriter
 * 字符输出流，可以将给定的字符串转换为对应的字节然后写出。
 * 字符流都是高级流
 */
public class OutputStreamWriterDemo {
	public static void main(String[] args) throws UnsupportedEncodingException, IOException {
		/*
		 * 向文件中写出一个字符串
		 */
		FileOutputStream fos = new FileOutputStream("osw.txt");
		/*
		 * 使用OSW可以按照指定的字符集方便的写出字符串。
		 */
		OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
		
		osw.write("挖掘机技术哪家强?");
		osw.write("摩擦摩擦是魔鬼的步伐!");
		
		osw.close();
	}
}





