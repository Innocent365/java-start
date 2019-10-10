package javaSE.file;

import java.io.FileNotFoundException;
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
}




