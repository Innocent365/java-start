package io.charstream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 字符转换流
 * InputStreamReader
 * 字符输入流，可以根据指定的字符集读取字符
 *
 */
public class InputStreamReaderDemo {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("osw.txt");
		/*
		 * 使用该高级流，可以按照给定的字符集读取对应的字符
		 * 第二个参数若不指定，就是按照当前系统默认字符集。
		 */
		InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
		/*
		 * 由于一个字符一个字符读取会提高读取的次数，这样会降低读取的效率。
		 */
//		int d = -1;
//		while((d = isr.read())!=-1){
//			System.out.print((char)d);
//		}
		
		char[] data = new char[1024];
		/*
		 * 与批量读取字节意思一致。
		 * 一次尝试读取data长度的字符量，返回值为
		 * 实际读取到的字符量。若返回值-1表示EOF
		 */
		int len = isr.read(data);
		String str = new String(data,0,len);
		System.out.println(str);

		isr.close();
	}
}






