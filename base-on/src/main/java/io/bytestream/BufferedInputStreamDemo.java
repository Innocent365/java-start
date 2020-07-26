package io.bytestream;



import org.junit.Test;

import java.io.*;

/**
 * 缓冲字节输入流
 */
public class BufferedInputStreamDemo {
    @Test//使用缓冲流来提高读写效率
    public void testBufferStream() throws IOException {
        FileInputStream src = new FileInputStream("flash.flv");
        //使用缓冲输入流提高读取效率
        BufferedInputStream bis = new BufferedInputStream(src);


        FileOutputStream des = new FileOutputStream("flash_copy3.flv");
        //使用缓冲输出流提高写出效率
        BufferedOutputStream bos = new BufferedOutputStream(des);

        int d = -1;
        //读写时就基于缓冲流
        while((d = bis.read())!=-1){
            bos.write(d);
        }
        System.out.println("复制完毕!");
        bos.close();
        bis.close();
    }
}
