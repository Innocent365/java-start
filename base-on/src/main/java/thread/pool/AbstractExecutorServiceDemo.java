package thread.pool;

import java.util.concurrent.*;

/**
 * 继承关系说明
 */
public class AbstractExecutorServiceDemo {

    public static void main(String[] args) {

        /**
         * 顶层接口，在它里面只声明了一个方法execute(Runnable)，返回值为void
         */
        Executor executor;//接口

        //继承了Executor接口，并声明了一些方法：submit、invokeAll、invokeAny以及shutDown等；
        ExecutorService executorService;//接口

        //实现了ExecutorService接口，基本实现了ExecutorService中声明的所有方法；
        AbstractExecutorService service;//抽象类


        /**
         * 继承了类 AbstractExecutorService
         */
        ThreadPoolExecutor threadPool = (ThreadPoolExecutor)
                Executors.newFixedThreadPool(2);

        //最重要的几个方法：

        //1.Executor接口中的execute方法，表示要执行的任务
        threadPool.execute(()->{
            System.out.println("报数：" + 1);
        });
        //2.线程池大小
        int size = threadPool.getPoolSize();

        //3.等待池的任务序列
        BlockingQueue<Runnable> queue = threadPool.getQueue();

        //4.
        threadPool.getActiveCount();
        threadPool.getCompletedTaskCount();


    }
}
/**
 * 参考：
 * 1.https://zhuanlan.zhihu.com/p/71938772
 * 2.https://crossoverjie.top/2018/07/29/java-senior/ThreadPool/
 * 3.https://www.cnblogs.com/dolphin0520/p/3932921.html
 *
 * */