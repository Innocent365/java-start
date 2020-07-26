package socket._1.tcp.internetrelaychatting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 聊天室服务端
 *
 * @author Administrator
 */
public class Server {
    /*
     * ServerSocket用于接收客户端Socket的连接
     * 并生成与之对应的Socket。服务端通过这个
     * Socket就可以与客户端进行数据交互了。
     */
    private ServerSocket server;
    /*
     * 该集合用来存放所有客户端的输出流，便于广播
     */
    private List<PrintWriter> allOut;

    /**
     * 构造方法用来初始化服务端
     *
     * @throws Exception
     */
    public Server() throws Exception {
        try {
            allOut = new ArrayList<PrintWriter>();
            /*
             * 实例化ServerSocket时需要传入
             * 申请开启的服务端口。客户端的
             * Socket就是通过这个端口与服务端
             * 建立连接的。
             */
            server = new ServerSocket(8088);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 将给定的客户端的输出流存入共享集合
     *
     * @param out
     */
    private synchronized void addOut(PrintWriter out) {
        allOut.add(out);
    }

    /**
     * 将给定的客户端的输出流从共享集合中删除
     *
     * @param out
     */
    private synchronized void removeOut(PrintWriter out) {
        allOut.remove(out);
    }

    /**
     * 将给定的消息发送给所有客户端
     *
     * @param message
     */
    private synchronized void sendMessageToAllClient(String message) {
        for (PrintWriter out : allOut) {
            out.println(message);
        }
    }


    /**
     * 服务端开始工作的方法
     *
     * @throws Exception
     */
    public void start() throws Exception {
        try {
            /*
             * ServerSocket提供了一个方法: Socket accept()
             * 该方法会监听开启的8088端口，等待客户端的连接，一旦一个客户端连接了，
             * 就会返回与该客户端通信的Socket
             *
             * 该方法是一个阻塞方法，除非一个客户端连接，否则accept方法会一直"卡住"。
             */
            while (true) {
                System.out.println("等待客户端连接...");
                Socket socket = server.accept();
                System.out.println("一个客户端连接了!");
                /*
                 * 当一个客户端连接后，我们启动一个线程ClientHandler,
                 * 并将与这个客户端交互的Socket传入，
                 * 使得ClientHandler这个线程来处理与该客户端的交互。
                 */
                ClientHandler handler = new ClientHandler(socket);
                Thread t = new Thread(handler);
                t.start();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static void main(String[] args) {
        try {
            Server server = new Server();
            server.start();
        } catch (Exception e) {
            System.out.println("服务端启动失败");
            e.printStackTrace();
        }
    }

    /**
     * 该内部类用来处理一个连接服务端的客户端的
     * 交互。
     * 这是一个线程。所以，若干客户端连接，服务端
     * 就会启动若干个这个线程来分别处理这些客户端
     * 的交互。
     *
     * @author Administrator
     */
    private class ClientHandler implements Runnable {
        //当前线程处理的客户端的Socket
        private Socket socket;
        //当前客户端的地址
        private String host;

        /**
         * 创建当前线程时应当连同将该线程负责交互
         * 的客户端的Socket传入，以方便与之通信
         *
         * @param socket
         */
        public ClientHandler(Socket socket) {
            this.socket = socket;
            /*
             * 通过Socket获取该远端计算机的信息
             */
            InetAddress address = socket.getInetAddress();
            //获取远端计算机的地址信息
            host = address.getHostAddress();
        }

        @Override
        public void run() {
            PrintWriter pw = null;
            try {
                /*
                 * 通过Socket获取输出流，可以将消息发送给客户端
                 */
                OutputStream out = socket.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(out, "UTF-8");
                pw = new PrintWriter(osw, true);
                /*
                 * 将该客户端的输出流存入共享集合，以便服务
                 * 端可以将其他客户端的消息转发给当前客户端
                 */
                addOut(pw);
                //广播该客户端上线的消息
                sendMessageToAllClient(
                        "[系统消息]" + host + "上线了!"
                );



                /*
                 * Socket定义了一个方法:
                 * InputStream getInputStream()
                 * 通过获取的输入流可以读取远端发送过来
                 * 的消息。对于服务端而言，远端就是指的
                 *
                 */
                InputStream in = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(in, "UTF-8");
                BufferedReader br = new BufferedReader(isr);
                /*
                 * 当客户端与服务端断开连接后，服务端所在的操作系统不同，结果会有差异。
                 * 若是windows系统:br.readLine()方法会抛出异常。
                 *
                 * 若是linux系统:br.readLine()方法会读取到NULL。
                 */
                String message = null;
                while ((message = br.readLine()) != null) {
                    System.out.println("客户端说:" + message);
//					pw.println(message);
                    //将当前客户端发送过来的内容转发给所有客户端
                    sendMessageToAllClient(host + "说:" + message);
                }

            } catch (Exception e) {

            } finally {
                /*
                 * 当客户端与服务端断开连接后,应当
                 * 先将该客户端的输出流从共享集合中
                 * 删除。再广播消息给其他客户端，该
                 * 客户端下线了，最后将该客户端的
                 * Socket关闭来释放资源。
                 */
                removeOut(pw);
                try {
                    socket.close();
                } catch (IOException e) {
                }
                sendMessageToAllClient("[系统消息]" + host + "下线了!");
            }
        }
    }
}









