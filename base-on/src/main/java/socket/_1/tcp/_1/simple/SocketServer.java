package socket._1.tcp._1.simple;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 客户端输入正方形的边长，服务器端接收到后计算面积并返回给客户端
 *
 * 注意：此实例中服务端收到了一个客户端请求后即会关闭连接！
 *
 */
public class SocketServer {
    public static void main(String[] args) throws IOException {
        int port = 7000;
        // 创建一个服务器套接字
        ServerSocket serverSocket = new ServerSocket(port);
        while (true){
            try(Socket socket = serverSocket.accept()) {
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                double side = dis.readDouble();
                System.out.println("收到的正方形边长为：" + side);

                double area = Math.pow(side, 2);
                System.out.println("返回面积：" + area);
                dos.writeDouble(area);
                dos.flush();
                dos.close();
            }
        }
    }
}
