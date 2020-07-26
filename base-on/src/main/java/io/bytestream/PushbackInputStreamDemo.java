package io.bytestream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;

/**
 * 回退流：
 *      内部有一个缓冲区,回退了就往里面写入数据
 *      每次读取数据read都是先看看缓冲区里面有没有数据,有就先读取回退缓冲区的
 *          否则,就再去使用原来的流（InputStream）去进行读取
 *  同样分为字节流和字符流（PushbackReader）
 *
 */
public class PushbackInputStreamDemo {
    public static void main(String[] args) throws IOException {
        String str = "你好，树先生！";

        //读取内存中的数据
        ByteArrayInputStream bai = new ByteArrayInputStream(str.getBytes());

        //构造方法 将输入流放入到回退流之中
        PushbackInputStream push = new PushbackInputStream(bai);
        int temp = 0;
        while ((temp = push.read())!=-1){
            if(temp == '.'){
                /**
                 * public void unread(int b)  推回一个数据到缓冲区。
                 * public void unread(byte[] b)  推回一组数据到缓冲区。
                 * public void unread(byte[] b,int off,int len)  推回指定范围的一组数据到缓冲区。
                 */
                push.unread(temp);
                temp = push.read();
                System.out.println("退回" + (char)temp);
            }else {
                System.out.println((char)temp);
            }
        }
    }
}
/**
 * 重复读取InputStream的方法:
 *  1.对于（我们）主动获取 的流，可以再去读取一次，
 *      例如重新获取文件输入流，或者从网络连接中重新获取 InputStream inputStream = httpconn.getInputStream();
 *  2.但是，对于“被动”利用InputStream的接口，
 *      对于InputStream的方式接口内部不得而知,不能重复利用InputStream
 *      此时最简单的方式就是缓存，读取到内存中（String, byte[]等）,缺点是内存压力大
 *  3.通过mark和reset方法重复利用InputStream
 *      如果第一次读取InputStream是用来判断文件流类型，文件编码等用的，
 *      往往不需要所有的InputStream的数据，或许只需要前n个字节，这样缓存一整个InputStream是一种浪费
 *
 *      调用mark方法会记下当前调用mark方法的时刻，InputStream被读到的位置。
 *      调用reset方法就会回到该位置。
 *
 *      InputStream是不支持mark的。要想支持mark子类必须重写这三个方法，
 *      不同的实现子类，mark的参数readlimit作用不尽相同。
 *      可通过 boolean markSupport()方法查看是否支持
 *
 */
