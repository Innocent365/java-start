package socket._1.tcp._1.simple;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author hw
 * @version on 2020/4/12
 */
public class SocketClient {
    public static void main(String[] args) throws IOException {
        int port = 7000;
        String host = "localhost";

        // 创建一个套接字并将其连接到指定端口号
        Socket socket = new Socket(host, port);

        DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));


        System.out.println("请输入正方形的边长:");
        Scanner sc = new Scanner(System.in);
        double length = sc.nextDouble();

        dos.writeDouble(length);
        dos.flush();

        double area = dis.readDouble();
        System.out.println("服务器返回的计算面积为:" + area);

        socket.close();
    }
}
