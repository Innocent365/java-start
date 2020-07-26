package socket._2.udp._2.normal;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

/**
 * @author hw
 * @version on 2020/4/14
 */
public class UDPServer {
    public static void main(String[] args) {
        DatagramSocket socket;
        try {
            int port = 3000;
            socket = new DatagramSocket(port);

            byte[] bytes = new byte[1024];
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length);

            socket.receive(packet);
            System.out.println("服务器端收到消息："
                    + new String(bytes,0, packet.getLength(),StandardCharsets.UTF_8));

            bytes = "来自远古的呼唤".getBytes(StandardCharsets.UTF_8);
            packet = new DatagramPacket(bytes, bytes.length,
                    packet.getAddress(), packet.getPort());
            socket.send(packet);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
