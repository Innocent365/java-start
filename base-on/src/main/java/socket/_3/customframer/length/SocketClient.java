package socket._3.customframer.length;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Redis的Java客户端Jedis就是用这种方式实现的这种方式：
 *
 * @author hw
 * @version on 2020/4/17
 */
public class SocketClient {
    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int port = 55533;

        Socket socket = new Socket(host, port);
        OutputStream os = socket.getOutputStream();

        String message = "你好 hello おはよう สวัสดี 안녕";
        byte[] sendBytes = message.getBytes("UTF-8");

        //然后将消息的长度优先发送出去
        os.write(sendBytes.length >> 8);
        os.write(sendBytes.length);
        //然后将消息再次发送出去
        os.write(sendBytes);
        os.flush();

        //==========此处重复发送一次，实际项目中为多个命名，此处只为展示用法
        message = "第二条消息";
        sendBytes = message.getBytes("UTF-8");
        os.write(sendBytes.length >>8);
        os.write(sendBytes.length);
        os.write(sendBytes);
        os.flush();
        //==========此处重复发送一次，实际项目中为多个命名，此处只为展示用法
        message = "the third message!";
        sendBytes = message.getBytes("UTF-8");
        os.write(sendBytes.length >>8);
        os.write(sendBytes.length);
        os.write(sendBytes);

        os.close();
        socket.close();
    }
}
