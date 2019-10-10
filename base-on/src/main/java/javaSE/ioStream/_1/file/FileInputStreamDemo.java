package javaSE.ioStream._1.file;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * java.io.FileInputStream
 * 用于从文件中读取数据的流，同样的是一个低级流。
 * @author Administrator
 *
 */
public class FileInputStreamDemo {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("fos.txt");
		
		byte[] data = new byte[100];
		
		int len = fis.read(data);
		
		String str = new String(data,0,len,"UTF-8");
		System.out.println(str);
		fis.close();
	}
}









