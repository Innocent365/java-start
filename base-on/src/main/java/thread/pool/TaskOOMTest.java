package thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * -Xms10M => Java Heap内存初始化值
 * -Xmx10M => Java Heap内存最大值
 *
 *
 *  Exception in thread "main" java.lang.OutOfMemoryError: GC overhead limit exceeded
 *      at java.util.concurrent.LinkedBlockingQueue.offer(LinkedBlockingQueue.java:416)
 *      at java.util.concurrent.ThreadPoolExecutor.execute(ThreadPoolExecutor.java:1371)
 *      at com.hollis.ExecutorsDemo.main(ExecutorsDemo.java:16)
 *
 */
public class TaskOOMTest {
    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        int i = 0;
        while (true) {
            es.submit(new Task(i++));
        }
    }
}

class Task implements Runnable {
    private int taskNum;

    public Task(int taskNum) {
        this.taskNum = taskNum;
    }

    @Override
    public void run() {
        //System.out.println("正在执行task " + taskNum);
        int sum = 0, i = taskNum + 1;
        while (--i > 0) {
            sum += i;
        }
        System.out.println("数字 " + taskNum + "的累加和为 " + sum);

        //System.out.println("task " + taskNum + "执行完毕");
    }
}


