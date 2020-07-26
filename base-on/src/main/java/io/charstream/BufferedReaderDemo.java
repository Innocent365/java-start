package io.charstream;

import org.junit.Test;

import java.io.*;

/**
 * java.io.BufferedReader
 * 缓冲字符输入流，特点:以行为单位读取字符串
 * @author Administrator
 *
 */
public class BufferedReaderDemo {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("."+File.separator+"src"+File.separator+"day02"+File.separator+"BufferedReaderDemo.java");
		InputStreamReader isr = new InputStreamReader(fis);
		
		BufferedReader br = new BufferedReader(isr);
		
		/*
		 * String readLine()
		 * 该方法会连续读取若干字符，直到读取到换行
		 * 符为止，然后将换行符之前的所有字符组成
		 * 一个字符串返回。需要注意，返回的字符串
		 * 中是不包含这个换行符的。
		 * 若返回值为null表示读取到文件末尾了，再
		 * 没数据可以读取。
		 */
		String line = null;
		while((line = br.readLine())!=null){
			System.out.println(line);
		}
		
		br.close();
	}

	@Test
	public void Merge2OneRowAPI() throws IOException {
		/*
		 * 思路:
		 * 首先按行读取文件中的每一行字符串，然后将他们拼接在一起。
		 * 最后在当前文件末尾追加将这一行拼接的
		 * 字符串写出即可。
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("pw.txt")));
		//记录每次读取出来的一行字符串
		String line = null;
		//记录每行字符串拼接后的效果
		String info = null;
		while((line = br.readLine())!=null){
			info += line;
		}
		br.close();

		FileOutputStream fos = new FileOutputStream("pw.txt",true);
		PrintWriter pw = new PrintWriter(fos);
		pw.println(info);
		pw.close();

	}
}








