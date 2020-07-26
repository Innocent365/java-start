package thread.concurrent;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Semaphore管理着一组许可（permit）,许可的初始数量可以通过构造函数设定，
 *  操作时首先要获取到许可，才能进行操作，操作完成后需要释放许可。
 *      如果没有获取许可，则阻塞到有许可被释放。
 *      如果初始化了一个许可为1的Semaphore，那么就相当于一个不可重入的互斥锁（Mutex）
 *
 *      Semaphore是很好用的Java并发工具，除了上面这个例子，我们在工作中经常用它管理数据库连接或者保护其它受限资源的并发使用。
 *
 *  场景：
 *      有限的售票窗口多个人排队买票
 *
 *      厕所的坑位有限早上可能会满
 *
 */
public class SemaphoreDemo {

    class SemaphoreRunnable implements Runnable {
        //信号量（需要获取和释放）
        private Semaphore semaphore;
        private int user;

        public SemaphoreRunnable(Semaphore semaphore, int user) {
            this.semaphore = semaphore;
            this.user = user;
        }

        @Override
        public void run() {
            try {
                //获取信号量许可
                this.semaphore.acquire();
                System.out.println("用户【" + user + "】进入窗口，准备买票...");
                Thread.sleep((long) (Math.random() * 10000));
                System.out.println("用户【" + user + "】买票完成，即将离开...");
                Thread.sleep((long) (Math.random() * 10000));
                System.out.println("用户【" + user + "】离开售票窗口");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void exceute() {
        //定义窗口个数
        Semaphore semaphore = new Semaphore(2);
        //线程池
        ExecutorService threadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 20; i++) {
            threadPool.execute(new SemaphoreRunnable(semaphore, i + 1));
        }
        threadPool.shutdown();
    }

    public static void main(String[] args) {
        new SemaphoreDemo().exceute();
    }


    /**
     * 初始化为0也能释放，释放后就有了
     */
    @Test
    public void test0(){

        Semaphore semaphore = new Semaphore(0);

        Thread thread = new Thread(()->{
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("here");
        });

        Thread thread2 = new Thread(()->{
            System.out.println("初始" + semaphore.availablePermits());
            semaphore.release();
            semaphore.release();
            System.out.println("释放了" + semaphore.availablePermits());
        });

        thread.start();
        try {
            Thread.sleep(1000);
            thread2.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
