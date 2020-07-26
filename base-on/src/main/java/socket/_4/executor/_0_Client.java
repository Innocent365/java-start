package socket._4.executor;

import java.io.*;
import java.net.Socket;
import java.util.Random;

/**
 * @author hw
 * @version on 2020/4/15
 */
public class _0_Client {
    private Socket socket;

    public _0_Client() throws IOException {
        int port = 8000;
        String host = "localhost";
        this.socket = new Socket(host, port);
    }

    public void start(int times) throws IOException, InterruptedException {
        PrintWriter printWriter = new PrintWriter(
                new OutputStreamWriter(socket.getOutputStream()), true);

        DataInputStream dis = new DataInputStream(socket.getInputStream());

        Random random = new Random();
        //int times = random.nextInt(30);
        int i = 0;
        while (i++ < times) {
            String expression = String.format("%s*%s\n", random.nextInt(100), random.nextInt(100));
            printWriter.write(expression);
            printWriter.flush();
            System.out.println("calculate result：" + expression + " = " + dis.readDouble());
            Thread.sleep(1000);
        }
        //System.out.println("结束执行");
        socket.shutdownOutput();
        socket.close();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        //for (int i = 0; i < 10; i++) {
        //    System.out.println("第 " + i +"次：");
        //    new Client().start();
        //}
        //for (int i = 0; i < 100; i++) {
            new Thread(()->{
                try {
                    new _0_Client().start(20);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        //}
        new Thread(()->{
            try {
                new _0_Client().start(10);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                new _0_Client().start(30);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        Thread.sleep(3000);
        new Thread(()->{
            try {
                new _0_Client().start(10);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                new _0_Client().start(20);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                try {
                    new _0_Client().start(20);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
