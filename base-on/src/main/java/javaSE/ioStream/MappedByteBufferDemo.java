package javaSE.ioStream;




import org.junit.Test;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 缓冲流写出数据的注意事项
 * @author Administrator
 *
 */
public class MappedByteBufferDemo {



	@Test//若想提高读写效率，必须减少读写次数。可以通过提高读写的数据量，来减少读写的次数，从而提高读写效率。
	public void main() throws IOException {
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

	@Test//jdk1.4提供的内存映射文件，用来取代上面的 RandomAccessFile
	public static void main(String[] args) throws Exception {
		int length = 0x8000000; // 128 Mb
		// 为了以可读可写的方式打开文件，这里使用RandomAccessFile来创建文件。
		FileChannel fc = new RandomAccessFile("test.dat", "rw").getChannel();
		//注意，文件通道的可读可写要建立在文件流本身可读写的基础之上
		MappedByteBuffer out = fc.map(FileChannel.MapMode.READ_WRITE, 0, length);
		//写128M的内容
		for (int i = 0; i < length; i++) {
			out.put((byte) 'x');
		}
		System.out.println("Finished writing");
		//读取文件中间6个字节内容
		for (int i = length / 2; i < length / 2 + 6; i++) {
			System.out.print((char) out.get(i));
		}
		fc.close();
	}

}







