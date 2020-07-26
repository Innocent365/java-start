package socket._3.customframer.length;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author hw
 * @version on 2020/4/17
 */
public class SocketServer {
    public static void main(String[] args) throws IOException {
        int port = 55533;
        ServerSocket server = new ServerSocket(port);

        System.out.println("服务器已启动，等待连接...");
        Socket socket = server.accept();
        InputStream is = socket.getInputStream();
        byte[] bytes;
        while (true){
            int first = is.read();
            //流的末尾，Socket已经被关闭了，此时将不能再去读取
            if(first == -1){
                break;
            }
            int second = is.read();
            //采用2个字节表示长度
            int length = (first << 8) + second;
            bytes = new byte[length];
            is.read(bytes);
            System.out.println("Received message: " + new String(bytes, "UTF-8"));
        }

        is.close();
        socket.close();
        server.close();
    }
}
