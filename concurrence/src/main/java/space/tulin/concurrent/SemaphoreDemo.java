package space.tulin.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

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


}
