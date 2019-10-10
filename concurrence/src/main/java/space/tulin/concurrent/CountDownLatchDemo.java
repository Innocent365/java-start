package space.tulin.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * 多线程同步
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(3);
        //任务1
        new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println("任务1正在执行任务...");
                    Thread.sleep((long)(Math.random()*10000));

                    System.out.println("任务1执行完毕");
                    latch.countDown();  //计数器减一
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread(() -> {
            try {
                System.out.println("任务2正在执行任务...");
                Thread.sleep((long)(Math.random()*10000));

                System.out.println("任务2执行完毕");
                latch.countDown();  //计数器减一
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                System.out.println("任务3是来搅局的...");
                Thread.sleep((long)(Math.random()*10000));

                System.out.println("任务3也执行完毕");
                latch.countDown();  //计数器减一
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        System.out.println("等待其他两个任务执行完毕，我主线程才开始" + Thread.currentThread().getName());
        try {
            latch.await();  //阻塞点，同步点
            System.out.println("其他两个任务执行完毕，主线程执行任务");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
