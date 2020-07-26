package socket._2.udp;

import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 查找本地UDP端口
 * @author hw
 * @version on 2020/4/14
 */
public class scanUDPPorts {
    public static void main(String[] args) {
        for(int i = 0 ; i < 65536 ; i++){
            try{
                //如果已经有UDP服务器绑定到了i号端口则会抛出异常
                DatagramSocket socket = new DatagramSocket(i);
                socket.close();
            }catch (SocketException e) {
                System.out.println("There is a UDP server on port" + i + ".");
            }
        }
    }
}
/**
 * 需要注意的是，TCP端口与UDP端口没有任何关联，
 * 这意味着TCP Socket与UDP Socket可以绑定到同一个端口。
 */
