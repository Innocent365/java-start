package socket._4.executor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * 然后创建 N 个线程，每个线程反复循环，从（共享的）ServerSocket 实例接收客户端连接。
 * 当多个线程同时调用一个 ServerSocket 实例的 accept()方法时，它们都将阻塞等待，
 * 直到一个新的连接成功建立，然后系统选择一个线程，为建立起的连接提供服务，其他线程则继续阻塞等待。
 *
 * 线程在完成对一个客户端的服务后，继续等待其他的连接请求，而不终止。
 * 如果在一个客户端连接被创建时，没有线程在 accept()方法上阻塞（即所有的线程都在为其他连接服务），
 * 系统则将新的连接排列在一个队列中，直到下一次调用 accept()方法。
 *
 * @author hw
 * @version on 2020/4/16
 */
public class _1_SeverPool {

    private static final int POOL_SIZE = 2;

    public static void main(String[] args) throws IOException {
        //服务端在20006端口监听客户端请求的TCP连接
        final ServerSocket server = new ServerSocket(20006);
        for (int i = 0; i < POOL_SIZE; i++) {
            Thread thread = new Thread(){
                @Override
                public void run() {
                    while (true){
                        Socket socket = null;
                        try {
                            socket = server.accept();
                            ServiceThread thread1 = new ServiceThread();
                            thread1.setSocket(socket);
                            thread1.start();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            thread.start();
        }
    }
}
