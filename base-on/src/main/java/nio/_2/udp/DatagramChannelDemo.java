package nio._2.udp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * 通过UDP 读写网络中的数据通道。
 * @author hw
 * @version on 2020/4/24
 */
public class DatagramChannelDemo {
    public static void main(String[] args) throws IOException {
        //打开 DatagramChannel
        DatagramChannel channel = DatagramChannel.open();
        channel.socket().bind(new InetSocketAddress(9999));

        //接收数据
        ByteBuffer buf = ByteBuffer.allocate(48);
        buf.clear();
        channel.receive(buf);//如果Buffer容不下收到的数据，多出的数据将被丢弃。

        //发送数据
        String newData = "New String to write to file..." + System.currentTimeMillis();
        ByteBuffer buffer = ByteBuffer.allocate(48);
        buffer.clear();
        buf.put(newData.getBytes());
        buf.flip();

        int byteSent = channel.send(buffer, new InetSocketAddress("localhost", 80));
        //发送一串字符到”jenkov.com”服务器的UDP端口80。 因为服务端并没有监控这个端口，所以什么也不会发生。
        //也不会通知你发出的数据包是否已收到，因为UDP在数据传送方面没有任何保证。

        //连接到特定地址：
        //以将DatagramChannel“连接”到网络中的特定地址的。由于UDP是无连接的，连接到特定地址并不会像TCP通道那样创建一个真正的连接。
        // 而是锁住DatagramChannel ，让其只能从特定`地址收发数据。
        channel.connect(new InetSocketAddress("jenkov.com", 80));
        int bytesRead = channel.read(buf);
        int bytesWritten = channel.write(buf);
    }
}
