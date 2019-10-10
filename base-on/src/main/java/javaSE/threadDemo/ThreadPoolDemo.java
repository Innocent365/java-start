package javaSE.threadDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 * 作用:
 * 1:控制线程数量
 * 2:重用线程
 *
 * @author Administrator
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        //创建一个固定大小的线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        //指派5个任务给线程池
        for (int i = 0; i < 5; i++) {
            Runnable runn = () -> {
                Thread t = Thread.currentThread();
                System.out.println(t.getName() + "正在运行任务..");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                }
                System.out.println(t.getName() + "执行完任务了..");
            };
            //将任务交给线程池
            threadPool.execute(runn);
        }
        threadPool.shutdownNow();
    }
}












