package space.tulin.nio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 传统socket
 */
public class TraditionalSocketDemo {
    public static void main(String[] args) throws IOException {
        ExecutorService threadPool = Executors.newCachedThreadPool();

        ServerSocket serverSocket = new ServerSocket(7777);
        System.out.println("服务端启动。。。");

        while (true) {
            //获取socket客户端套接字
            Socket socket = serverSocket.accept();

            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        byte[] bytes = new byte[1024];
                        System.out.println("有新客户端连接上来...");
                        while (true) {
                            int data = 0;
                            InputStream is = socket.getInputStream();
                            data = is.read(bytes);
                            if (data != -1) {
                                String info = new String(bytes, 0, data, "GBK");
                                System.out.println(info);
                            } else {
                                break;
                            }
                        }
                    }catch(IOException e){
                            e.printStackTrace();
                    }
                }
            });

        }
    }
}
