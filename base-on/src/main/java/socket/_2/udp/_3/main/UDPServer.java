package socket._2.udp._3.main;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

/**
 * @author hw
 * @version on 2020/4/14
 */
public class UDPServer {
    private static final int MAX = 3;

    private final DatagramSocket socket;
    private final Set<InetAddress> benben;

    public UDPServer() throws SocketException {
        //服务端在本地 3000 端口监听接收到的数据
        this.socket = new DatagramSocket(3000);
        benben = new HashSet<>();
    }

    @Override
    protected void finalize() throws Throwable {
        socket.close();
        super.finalize();
    }

    public void start() {
        //若实际消息超出，超出部分会被自动放弃，而且对接收程序没有任何消息丢失的提示！
        byte[] bytes = new byte[1024];
        /**
         * 如果该实例用来包装待接收的数据，则不指定数据来源的远程主机和端口，
         * 只需指定一个缓存数据的 byte 数组即可
         * （在调用 receive()方法接收到数据后，
         *      源地址和端口等信息会自动包含在 DatagramPacket 实例中）
         */
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length);

        while (true) {
            try {
                //阻塞方法
                socket.receive(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
            bytes = packet.getData();
            System.out.println("服务器收到数据：" +
                    new String(bytes, 0, packet.getLength(), StandardCharsets.UTF_8));
            System.out.println("from:" + packet.getAddress());

            String msg = "你等着被降维打击吧!";
            bytes = msg.getBytes();
            //如果接收到数据，则返回字符串到该客户端的 9000 端口。
            packet = new DatagramPacket(bytes, bytes.length,
                    packet.getAddress(), 9000);
            int tryTimes = 0;
            while (tryTimes++ < MAX) {
                try {
                    socket.send(packet);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            benben.add(packet.getAddress());
        }
    }

    public static void main(String[] args) throws SocketException {
        UDPServer server = new UDPServer();
        server.start();
    }
}
