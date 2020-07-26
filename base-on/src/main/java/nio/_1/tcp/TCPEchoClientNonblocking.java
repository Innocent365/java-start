package nio._1.tcp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author hw
 * @version on 2020/4/16
 */
public class TCPEchoClientNonblocking {
    public static void main(String[] args) throws IOException {
        String server = "localhost";
        byte[] arguments = "message".getBytes();
        int port = 8020;

        //创建一个信道，设为非阻塞模式
        SocketChannel clntChan = SocketChannel.open();
        clntChan.configureBlocking(false);
        if (!clntChan.connect(new InetSocketAddress(server, port))) {
            //不断地轮询连接状态，直到完成连接
            while (!clntChan.finishConnect()) {
                //在等待连接的时间里，可以执行其他任务，以充分发挥非阻塞IO的异步特性
                //这里为了演示该方法的使用，只是一直打印"."
                System.out.print(".");
            }
        }
        System.out.print("\n");
        //分别实例化用来读写的缓冲区
        ByteBuffer writeBuf = ByteBuffer.wrap(arguments);
        ByteBuffer readBuf = ByteBuffer.allocate(arguments.length);
        //接收到的总的字节数
        int totalByteRcvd = 0;
        //每次read读取到的数据
        int byteRcvd;
        while (totalByteRcvd < arguments.length) {
            if (writeBuf.hasRemaining()) {
                clntChan.write(writeBuf);
            }
            if ((byteRcvd = clntChan.read(readBuf)) == -1) {
                throw new SocketException("Connection close prematurely");
            }
            //计算收到的总字节数
            totalByteRcvd += byteRcvd;
            System.out.print(".");
        }
        System.out.println("Received: " + new String(readBuf.array(), 0 ,totalByteRcvd));
        clntChan.close();
    }
}
