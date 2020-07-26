package socket._1.tcp._2.normal;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * 得到一个计算器功能
 */
public class Client {
    private final String host = "127.0.0.1";
    private final int port = 7001;

    private Socket socket;

    public Client() {
        try {
            socket = new Socket(host, port);
        } catch (IOException e) {
            System.out.println("连接失败！");
            e.printStackTrace();
        }
    }

    public double getValue(String expression) throws IOException {

        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(expression.getBytes());
        bos.flush();
        //bos.close();

        InputStream is = socket.getInputStream();
        DataInputStream dis = new DataInputStream(is);

        return dis.readDouble();
    }

    public void close() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Client client = null;
        while (true) {
            System.out.println("请输入算式：");
            String expression = sc.next()+"\n";
            try {
                client = new Client();
                System.out.println("计算结果：" + client.getValue(expression));
                System.out.println("是否继续（Y/N）？");
                String flag = sc.next();
                while (true) {
                    if(flag == null || flag.trim().length()==0) continue;
                    if ("N".equalsIgnoreCase(flag)) {
                        System.exit(0);
                    } else if ("Y".equalsIgnoreCase(flag)) {
                        break;
                    } else {
                        System.out.println("输入错误请重新输入");
                    }
                }
            } catch (IOException e) {
                System.out.println("网络连接错误！");
                e.printStackTrace();
            }finally {
                client.close();
            }
        }
    }
}