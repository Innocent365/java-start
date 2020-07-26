package socket._4.executor;

import other.Calculator;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

import static java.lang.Thread.State.NEW;

/**
 * 自定义线程集合~
 * @author hw
 * @version on 2020/4/15
 */
public class _2_ServerCustomerThreadPool {

    private static final int POOL_SIZE = 10;

    private final ServerSocket server;
    private final ServiceThread[] pool;
    private final Deque<Socket> deque;

    public _2_ServerCustomerThreadPool() throws IOException {
        this.server = new ServerSocket(8000);
        this.pool = new ServiceThread[POOL_SIZE];
        Arrays.fill(pool, new ServiceThread());
        deque = new LinkedList<>();
    }

    public void start() throws IOException {
        new Thread(this::loopRun).start();
        main:
        while (true) {
            Socket socket = server.accept();
            for (ServiceThread thread : pool) {
                if (thread.getState() == NEW) {
                    thread.setSocket(socket);
                    thread.start();
                    continue main;
                }
            }
            System.out.println("线程池已满，放入队列，当前个数" + deque.size());
            deque.push(socket);
        }
    }

    public void loopRun() {
        for (int i = 0; ; i++) {
            if (i >= pool.length) i = 0;
            ServiceThread thread = pool[i];
            switch (thread.getState()) {
                case NEW:
                    if (deque.size() > 0) {
                        thread.setSocket(deque.pop());
                        thread.start();
                        System.out.println("线程" + i +"执行队列任务, 当前还有" + deque.size() + "个连接");
                        break;
                    }
                    break;
                case TERMINATED: //Thread.State.TERMINATED这种引入方式不行，神奇了
                    pool[i] = new ServiceThread();
            }
        }
    }
    public static void main(String[] args) throws IOException {
        new _2_ServerCustomerThreadPool().start();
    }
}
@SuppressWarnings("All")
class ServiceThread extends Thread {
    private Socket socket;

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        LineNumberReader in = null;
        DataOutputStream out = null;
        try {
            if (in == null)
                in = new LineNumberReader(new InputStreamReader(socket.getInputStream()));
            if (out == null)
                out = new DataOutputStream(socket.getOutputStream());

            String expression;
            while ((expression = in.readLine()) != null) {
                //System.out.print("reciever message：" + expression);

                String result;
                try {
                    result = String.valueOf(Calculator.cal(expression));
                } catch (Exception e) {
                    result = "计算错误：" + e.getMessage();
                }
                out.writeDouble(Double.valueOf(result));
                out.flush();
                System.out.println("return message：" + result);
            }
            //System.out.println("结束连接");
        } catch (IOException e) {
            System.out.println("等待客户端消息超时");
            //e.printStackTrace();
        } finally {
            try {
                socket.close();
                in.close();
                out.close();
            } catch (IOException ex) {
            }
        }
    }
}