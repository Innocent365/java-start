package javaSE.file;

import org.junit.Test;


import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 批量写出字节
 * 
 * @author Administrator
 *
 */
public class RandomAccessFileDemo {

	@Test//读取，写入一个字节
	public void main() throws IOException {
		RandomAccessFile raf = new RandomAccessFile("demo.dat","rw");
		/*
		 * int read()
		 * 读取一个字节，并以int形式返回。
		 * 返回的int值中低8位就是读取回来的字节
		 * 内容，若读取到了文件末尾，返回的int
		 * 值为-1。
		 *
		 * 00000000 00000000 00000000 11111111
		 */
		int i = raf.read();
		System.out.println(i);

		raf.write(-1);

		raf.close();
	}

	@Test//批量读取字节
	public void testRead() throws IOException {
		RandomAccessFile raf = new RandomAccessFile("test.txt","r");

		/*
		 *  int read(byte[] d)
		 *  一次性尝试读取给定的字节数组的length个字节，并存入到给定的数组中。返回值为实际读取到的字节量。若返回值为-1，
		 *  表示读取到文件末尾了。
		 */
		byte[] data = new byte[100];
		int len = raf.read(data);
		System.out.println("实际读取到了:"+len);

		/*
		 * 字符串提供了构造方法允许将给定的字节数组按照给定的字符集转换为对应的字符串
		 *
		 * String(byte[] d,String charset)
		 * 将给定的字节数组中的所有字节按照给定的字符集转换为字符串。
		 *
		 * String(byte[] d,
		 *        int offset,
		 *        int len,
		 *        String charset)
		 * 将给定的字节数组中从下标为offset处的字节开始，连续len个字节，按照给定的字符集转换为对应的字符串。
		 */
		String str = new String(data,0,len,"UTF-8");
		System.out.println(str);

		raf.close();
	}

	@Test//写入字节
	public void testWrite() throws IOException {
		RandomAccessFile raf = new RandomAccessFile("test.txt","rw");
		
		String str = "我爱达内苍老师!";
		/*
		 *  byte[] getBytes()
		 *  字符串的该方法用来将当前字符串按照当前系统默认的字符集转换为对应的字节
		 *  windows默认:gbk
		 *  unix默认:utf-8
		 */
		//byte[] data = str.getBytes();


		/*
		 * 重载的getBytes()
		 * byte[] getBytes(String str)
		 * 将当前字符串按照给定的字符集转换为对应的字节
		 * 字符集名称不区分大小写，但通常使用大写
		 * 常用的:
		 * 		gbk:国标编码，英文1字节，中文2字节
		 * 		utf-8:万国码，英文1字节，中文3字节
		 * 		iso8859-1:欧洲编码，不支持中文。
		 */
		byte[] data = str.getBytes("UTF-8");
		System.out.println("字节数:"+data.length);
		
		/*
		 * void write(byte[] d)
		 * 将给定的字节数组中的所有字节全部写出
		 */
		raf.write(data);
		
		raf.close();
	}

	@Test//操作指针读或写
	public static void testPointer() throws IOException {
		RandomAccessFile raf = new RandomAccessFile("demo.dat","rw");
		/*
		 * RAF总是基于指针当前位置进行读写操作的。
		 * 无论是读还是写，指针都会自动向后移动。
		 * 刚创建好的RAF，指针是指向文件的第一个字节的。指针的位置用下标表示，0表示文件的第一个字节的位置。
		 *
		 * long getFilePointer()
		 * 获取当前指针的位置
		 */
		long position = raf.getFilePointer();
		System.out.println("pos:"+position);

		String str = "你好";
		byte[] data = str.getBytes();
		raf.write(data);

		position = raf.getFilePointer();
		System.out.println("pos:"+position);


		//写出一个int值
		/*
		 *                            vvvvvvvv
		 * 01111111 11111111 11111111 11111111
		 * max >>> 24
		 */
		int max = Integer.MAX_VALUE;
//		raf.write(max>>>24);
//		raf.write(max>>>16);
//		raf.write(max>>>8);
//		raf.write(max);
		/*
		 * void writeInt(int d)
		 * 将给定的int值写出。该方法会连续写4个
		 * 字节。
		 */
		raf.writeInt(max);
		System.out.println(
				"pos:"+raf.getFilePointer());

		/*
		 * 写出一个long值
		 */
		raf.writeLong(123L);
		System.out.println(
				"pos:"+raf.getFilePointer());

		/*
		 * 写一个double值
		 */
		raf.writeDouble(123.123);
		System.out.println(
				"pos:"+raf.getFilePointer());

		/*
		 * 先将指针移动到文件最开始
		 *
		 * void seek(long pos)
		 * 将指针移动到指定位置
		 */
		raf.seek(0);
		System.out.println(
				"pos:"+raf.getFilePointer());

		/*
		 * 先读int值
		 */
		int i = raf.readInt();
		System.out.println(i);
		System.out.println(
				"pos:"+raf.getFilePointer());

		long l = raf.readLong();
		System.out.println(l);

		double d = raf.readDouble();
		System.out.println(d);

		raf.close();
	}
}





