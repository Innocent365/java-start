package io.file;

import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 复制文件
 * @author Administrator
 *
 */
public class CopyAPI {
	public static void main(String[] args) throws IOException {
		/*
		 * 1:创建一个RandomAccessFile用来读待复制的文件
		 * 2:创建一个RandomAccessFile用来向复制的文件中写数据
		 * 3:循环从原文件中读取每一个字节 并且将这个字节写入到复制的文件中
		 * 4:关闭两个RAF    
		 */
		RandomAccessFile src = new RandomAccessFile("music.mp3","r");
		RandomAccessFile des = new RandomAccessFile("music_copy.mp3","rw");
		
		int d = -1;
		
		while( (d=src.read()) != -1  ){
			des.write(d);
		}
		
		System.out.println("复制完毕！");
		src.close();
		des.close();
	}

	@Test//若想提高读写效率，必须减少读写次数。可以通过提高读写的数据量，来减少读写的次数，从而提高读写效率。
	public void testCopy() throws IOException {
		RandomAccessFile src = new RandomAccessFile("music.mp3","r");

		RandomAccessFile des = new RandomAccessFile("music_copy.mp3","rw");
		//创建10k缓冲区
		byte[] buf = new byte[1024*10];
		//保存每次实际读取到的字节量
		int len = -1;

		long start = System.currentTimeMillis();
		while((len = src.read(buf))!=-1 ){
			/*
			 * write(byte[] d,int offset,int len)
			 * 将给定的字节数组中从下标为offset处开始
			 * 连续len个字节写出。
			 */
			des.write(buf,0,len);
		}
		long end = System.currentTimeMillis();
		System.out.println("复制完毕!耗时:"+(end-start)+"毫秒");
		src.close();
		des.close();
	}
}




