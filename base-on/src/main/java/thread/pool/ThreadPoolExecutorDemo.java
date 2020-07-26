package thread.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author hw
 * @version on 2020/6/12
 */
public class ThreadPoolExecutorDemo {

    public static void main(String[] args) {
        ThreadPoolExecutor executors = new ThreadPoolExecutor(5, 10,
                500, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(3),
                new MyRejectExecutionHandle());
        //16 - （10 + 3） = 3，可能有三个被拒绝
        for (int i = 0; i < 16; i++) {
            MyTask task = new MyTask(i);
            executors.execute(task);
            System.out.println("线程池中线程数目： " + executors.getPoolSize() + "," +
                    "队列中正在执行的任务数目：" + executors.getQueue().size() + ", " +
                    "已执行完的任务数目：" + executors.getCompletedTaskCount());
        }

        executors.shutdown();
    }


}

class MyTask implements Runnable {
    private int taskNum;

    public MyTask(int taskNum) {
        this.taskNum = taskNum;
    }

    @Override
    public void run() {
        System.out.println("正在执行task " + taskNum);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task " + taskNum + "执行完毕");
    }
}

/**
 * 自定义拒绝策略
 */
class MyRejectExecutionHandle implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("task rejected. " + executor.toString());
    }
}