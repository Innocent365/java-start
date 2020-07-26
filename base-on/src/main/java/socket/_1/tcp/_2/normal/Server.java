package socket._1.tcp._2.normal;

import other.Calculator;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author hw
 * @version on 2020/4/12
 */
@SuppressWarnings("ALl")
public class Server {

    private ServerSocket server;

    public Server() throws IOException {
        this.server = new ServerSocket(7001);
    }

    public void start() throws IOException {
        while (true) {
            Socket socket = server.accept();
            System.out.println("获取到客户端连接：" + socket.getInetAddress());
            ServerHandle handler = new ServerHandle(socket);
            new Thread(handler).start();
        }
    }

    private class ServerHandle implements Runnable{

        private Socket socket;

        public ServerHandle(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            LineNumberReader in = null;
            DataOutputStream out = null;
            try{
                in = new LineNumberReader(new InputStreamReader(socket.getInputStream()));
                out = new DataOutputStream(socket.getOutputStream());
                String expression = in.readLine();
                String result ;

                System.out.println("服务器收到消息：" + expression);
                try{
                    result = String.valueOf(Calculator.cal(expression));
                }catch(Exception e){
                    result = "计算错误：" + e.getMessage();
                }
                out.writeDouble(Double.valueOf(result));
                out.flush();
                System.out.println("服务器返回消息：" + result);
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                //一些必要的清理工作
                if(in != null){
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    in = null;
                }
                if(out != null){
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    out = null;
                }
                if(socket != null){
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    socket = null;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("服务器启动...");
        new Server().start();
    }
}
