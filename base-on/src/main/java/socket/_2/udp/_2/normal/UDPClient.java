package socket._2.udp._2.normal;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

/**
 * @author hw
 * @version on 2020/4/14
 */
public class UDPClient {
    public static void main(String[] args) {
        DatagramSocket socket;
        try {
            socket = new DatagramSocket();
            InetAddress address = InetAddress.getLocalHost();

            byte[] bytes = "你好啊".getBytes(StandardCharsets.UTF_8);

            DatagramPacket packet =
                    new DatagramPacket(bytes, bytes.length, address, 3000);
            socket.send(packet);

            bytes = new byte[1024];
            packet = new DatagramPacket(bytes, bytes.length);
            socket.receive(packet);

            System.out.println("客户端收到消息：" +
                    new String(bytes, 0, packet.getLength(), StandardCharsets.UTF_8));
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
