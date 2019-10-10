package javaSE.ioStream._1.file;



import org.junit.Test;

import java.io.*;

/**
 * java.io.FileOutputStream
 * 用于向文件中写出字节的字节输出流。
 * 这是一个低级流。
 * 满足低级流特点:写出的数据目的地明确(文件中)。
 *              真实将数据写入文件中。
 * @author Administrator
 *
 */
public class FileOutputStreamDemo {

	public static void main(String[] args) throws IOException {
		/*
		 * FOS创建的第一种模式:覆盖写操作
		 * 默认创建出来的FOS就是覆盖写操作。意思是通过该流写出的文件会先将文件中所有已有数据移除，重新写入新内容。
		 * 
		 * FOS创建的第二种模式:追加写操作
		 * 需要在构造方法中添加第二个参数: FileOutputStream(String path,boolean append)
		 * 第二个参数若为true,就是追加写模式，通过该流写出的数据会追加到当前文件末尾
		 */
		FileOutputStream fos = new FileOutputStream("fos.txt",true);
		
		String str = "我爱北京天安门";
		byte[] data = str.getBytes("UTF-8");
		
		fos.write(data);
		
		System.out.println("写出完毕");
		/*
		 * 流使用完毕后要关闭，来释放资源。
		 */
		fos.close();
	}



	@Test
	public void testFile2File() throws IOException {
		FileInputStream fis = new FileInputStream("flash.flv");
		FileOutputStream fos = new FileOutputStream("flash_copy2.flv");

		byte[] buf = new byte[1024*10];
		int len = -1;

		while((len=fis.read(buf))!=-1){
			fos.write(buf,0,len);
		}

		//或者使用apacheAPI: org.apache.commons.io.IOUtils.copy(fis,fos);

		System.out.println("复制完毕!");
		fis.close();
		fos.close();
	}
}













