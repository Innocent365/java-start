package socket._2.udp._3.main;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

/**
 * @author hw
 * @version on 2020/4/14
 */
public class UDPClient {
    private static final int TIMEOUT = 5000;
    private static final int MAX = 5;

    public static void main(String[] args) throws SocketException, UnknownHostException {
        String msg = "来自地球文明的呼唤";
        byte[] bytes = msg.getBytes(StandardCharsets.UTF_8);
        //客户端在9000端口监听接收到的数据
        DatagramSocket socket = new DatagramSocket(9000);
        /**
         * 设置接收数据时阻塞的最长时间,milliseconds
         */
        socket.setSoTimeout(TIMEOUT);

        /**
         * 而如果该实例用来包装待发送的数据，则要指定要发送到的目的主机和端口。
         * 发送到服务器的 3000 端口
         */
        DatagramPacket dpSend = new DatagramPacket(bytes, bytes.length,
                InetAddress.getLocalHost(), 3000);

        DatagramPacket dpReceive = new DatagramPacket(new byte[1024], 1024);

        int tries  = 0;
        while (tries  ++ < MAX){
            try{
                socket.send(dpSend);
                socket.receive(dpReceive);
                if(dpReceive.getAddress() != null){
                    break;
                }
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }
        if(dpReceive.getAddress() != null){
            //如果接收到的数据不是来自目标地址，则抛出异常
            if(dpReceive.getAddress().equals(InetAddress.getLocalHost())){
                throw new UnknownHostException("Received packet from an fake source");
            }
            /**
             * 注意：getData()方法总是返回缓冲区的原始大小，忽略了实际数据的内部偏移量和长度信息。
             *   bytes.length得到的是原始的大小。
             */
            bytes = dpReceive.getData();
            String response = new String(bytes,0, dpReceive.getLength(), StandardCharsets.UTF_8);
            System.out.println("客户端收到返回：" + response);
        }
        socket.close();
    }
}
/**
 * https://blog.csdn.net/swt369/article/details/77978639
 *
 * 1. UDP 程序在 receive()方法处阻塞，直到收到一个数据报文或等待超时。
 *
 * 如果数据报在传输过程中发生丢失，那么程序将会一直阻塞在 receive()方法处，这样客户端将永远都接收不到服务器端发送回来的数据，但是又没有任何提示。
 * 为了避免这个问题，我们在客户端使用 DatagramSocket 类的 setSoTimeout()方法来指定 receive()方法的最长阻塞时间，并指定重发数据报的次数，
 * 如果每次阻塞都超时，并且重发次数达到了设置的上限，则关闭客户端。
 *
 * 2. UDP数据报的数据部分最大为65507（IP最大数据长度65535-IP首部20-UDP首部8）
 *      一般不要超过8192字节，否则底层UDP实现可能会将其抛弃。
 *
 * 3.如果一个应用程序使用同一个 DatagramPacket 实例多次调用 receive()方法，
 *      每次调用前就必须显式地将其内部消息长度重置为缓存区的实际长度，以免接受的数据发生丢失。
 *     注: 由于dp_receive在接收了数据之后，其内部消息长度值会变为实际接收的消息的字节数，
 *          dpReceive.setLength(1024);
 *  如果希望复用DatagramPacket对象以避免重复创建带来的开销，可以使用DatagramPacket的setters：
 *    这些方法中最实用的可能是setData(byte[] buf, int offset, int length)方法
 *      通过改变offset的值，可以轻易地实现将一个大数组分成多个数据报发送。
 *
 * 4.要收发DatagramPacket，必须打开一个DatagramSocket，并绑定到一个端口上。
 *      对于客户端，不需要关心本地端口，可以让系统使用匿名端口；
 *      对于服务器，客户端需要知道它在哪个端口监听入站数据包，因此需要指定一个端口。
 *    不过，客户端和服务器使用的Socket类都是同一个。
 *      public DatagramSocket()、DatagramSocket(int) //传入0或不传入则为匿名端口
 * 5.由于UDP的不可靠性，Java的异常机制在使用UDP时经常会失效，
 *      因为可能在Java看到问题之前数据包已经被底层网络层丢弃了。
 * */