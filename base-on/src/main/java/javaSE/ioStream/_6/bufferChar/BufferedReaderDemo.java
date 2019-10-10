package javaSE.ioStream._6.bufferChar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

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
}








