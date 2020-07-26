package socket._4.executor;

import other.Calculator;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * https://wiki.jikexueyuan.com/project/java-socket/tcpserver.html
 *
 * 创建线程池时，线程池的大小是个很重要的考虑因素，
 *      如果创建的线程太多（空闲线程太多），则会消耗掉很多系统资源，
 *      如果创建的线程太少，客户端还是有可能等很长时间才能获得服务。
 * 因此，线程池的大小需要根据负载情况进行调整，以使客户端连接的时间最短，
 * 理想的情况是有一个调度的工具，可以在系统负载增加时扩展线程池的大小（低于大上限值），
 * 负载减轻时缩减线程池的大小。
 *
 * 一种解决的方案便是使用 Java 中的 Executor 接口
 * @author hw
 * @version on 2020/4/15
 */
public class _3_ServerExecutor  {

    private static final int POOL_SIZE = 10;

    private final ServerSocket server;
    private final Executor  pool;

    public _3_ServerExecutor() throws IOException {
        //通过调用Executors类的静态方法，创建一个ExecutorService实例
        this.server = new ServerSocket(8000);
        this.pool = Executors.newCachedThreadPool();
    }

    public synchronized void start() throws IOException {
        while (true) {
            Socket socket = server.accept();
            /**
             * 调用execute()方法时，如果必要，会创建一个新的线程来处理任务，但它首先会尝试使用已有的线程，
             * 如果一个线程空闲60秒以上，则将其移除线程池；
             *  另外，任务是在Executor的内部排队，而不是在网络中排队
             */
            pool.execute(new ServiceTask(socket));
        }
    }
    public static void main(String[] args) throws IOException {
        new _3_ServerExecutor().start();
    }
}

@SuppressWarnings("ALL")
class ServiceTask implements Runnable {
    private Socket socket;

    public ServiceTask(Socket socket) {
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
/**
 * Java 提供了大量的内置 Executor 接口实现，它们都可以简单方便地使用，
 * ExecutorService 接口继承于Executor 接口，它提供了一个更高级的工具来关闭服务器，
 * 包括正常的关闭和突然的关闭。
 *
 * 我们可以通过调用Executors 类的各种静态工厂方法来获取 ExecutorService 实例，
 * 而后通过调用 execute（）方法来为需要处理的任务分配线程，
 *  它首先会尝试使用已有的线程，但如果有必要，它会创建一个新的线程来处理任务，
 *  另外，如果一个线程空闲了 60 秒以上，则将其移出线程池，而且任务是在 Executor 的内部排队，
 *  而不像之前的服务器那样是在网络系统中排队，
 *  因此，这个策略几乎总是比前面两种方式实现的 TCP 服务器效率要高。
 *
 *
 * */