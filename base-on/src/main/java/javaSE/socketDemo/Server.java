package javaSE.socketDemo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP通信的服务端
 * @author Administrator
 *
 */
public class Server {
	public static void main(String[] args) {
		try {
			/*
			 * 接收数据:
			 * 1:创建Socket
			 * 2:准备接收包
			 * 3:通过Socket接收数据并放入接收包中
			 * 4:拆包拿数据  
			 */
			//1
			DatagramSocket socket = new DatagramSocket(8088);
			
			//2
			byte[] data = new byte[100];
			DatagramPacket packet = new DatagramPacket(data, data.length);
			
			/*
			 * 3 通过Socket获取远端发送过来的数据 并将数据存入我们创建的接收包中
			 * 当成功接收数据后，包会有以下变化:
			 * 1:包中就有数据了
			 * 2:包也知道实际接收到的数据的长度
			 * 3:包也知道了数据从哪里来的 
			 */
			socket.receive(packet);
			
			/*
			 * 从包中取数据
			 * 由于数据存入了我们创建的字节数组中
			 * 所以可以直接从data数据中得到。
			 */
			String message = new String(data,0,
					//通过包获取实际接收到的字节量
					packet.getLength(), "UTF-8"
				);
			System.out.println("客户端说:"+message);
			
			/*
			 * 将数据发送给客户端
			 */
			//2
			message = "你好客户端!";
			data = message.getBytes("UTF-8");
			
			/*
			 * 通过之前服务端接收包得知客户端的地址，以便于回复客户端
			 */
			InetAddress address = packet.getAddress();
			int port = packet.getPort();
			/*
			 * 打包
			 */
			packet = new DatagramPacket(data,//要发送的数据
					data.length,//将数组中多少字节发出
					address,//远端地址
					port//远端的端口
				);
			//4
			socket.send(packet);
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
