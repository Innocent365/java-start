package io.bytestream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 利用管道与不同的JVM中的线程通信(不同的进程)
 *
 *
 */
public class PipedInputStreamDemo {
    public static void main(String[] args) throws IOException {
        /**
         * 成对出现，一个PipedInputStream流应该和一个PipedOutputStream流相关联。
         * 一个线程通过PipedOutputStream写入的数据可以被另一个线程通过相关联的PipedInputStream读取出来。
         */
        PipedOutputStream output = new PipedOutputStream();
        PipedInputStream input = new PipedInputStream(output);

        /**
         * 也可以使用两个管道共有的connect()方法使之相关联
         */
        //PipedInputStream inputStream = new PipedInputStream();
        //inputStream.connect(output);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    output.write("Hello world,pipe!".getBytes());
                }catch (IOException e){}
            }
        });

        Thread thread2 = new Thread(()->{
            try{
                int data = input.read();
                while (data != -1){
                    System.out.print((char)data);
                    data = input.read();
                }
            }catch (IOException e){}
        });

        thread1.start();
        thread2.start();
    }
    //本例忽略了流的关闭。请在处理流的过程中，务必保证关闭流
}
/**
 * 当使用两个相关联的管道流时，务必将它们分配给不同的线程。
 * read()方法和write()方法调用时会导致流阻塞，
 * 这意味着如果你尝试在一个线程中同时进行读和写，可能会导致线程死锁。
 *
 * 管道的替代:
 * 除了管道之外，一个JVM中不同线程之间还有许多通信的方式。
 * 实际上，线程在大多数情况下会传递完整的对象信息而非原始的字节数据。
 * 但是，如果你需要在线程之间传递字节数据，Java IO的管道是一个不错的选择。
 *
 * */