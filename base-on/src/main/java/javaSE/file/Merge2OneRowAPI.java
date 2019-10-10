package javaSE.file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Merge2OneRowAPI {
	public static void main(String[] args) throws IOException {
		/*
		 * 思路:
		 * 首先按行读取文件中的每一行字符串，然后将他们拼接在一起。
		 * 最后在当前文件末尾追加将这一行拼接的
		 * 字符串写出即可。
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\Users\\ss\\IdeaProjects\\basis\\out\\production\\basis\\pw.txt")));
		//记录每次读取出来的一行字符串
		String line = null;
		//记录每行字符串拼接后的效果
		String info = null;
		while((line = br.readLine())!=null){
			info += line;
		}
		br.close();
		
		FileOutputStream fos = new FileOutputStream("pw.txt",true);
		PrintWriter pw
			= new PrintWriter(fos);
		pw.println(info);
		pw.close();
		
	}
}




