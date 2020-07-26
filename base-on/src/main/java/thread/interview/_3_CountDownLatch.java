package thread.interview;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * 四个线程 A B C D，其中 D 要等到 A B C 全执行完毕后才执行，而且 A B C 是同步运行的
 *
 */
public class _3_CountDownLatch {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);

        new Thread(new Runnable() {
            @Override
            public void run() {
                int limit = new Random().nextInt(100000);
                while (limit -- > 0){

                }
                System.out.println("A准备完毕");
                latch.countDown();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int limit = new Random().nextInt(100000);
                while (limit -- > 0){

                }
                latch.countDown();
                System.out.println("B准备完毕");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int limit = new Random().nextInt(100000);
                while (limit -- > 0){

                }
                latch.countDown();
                System.out.println("C准备完毕");
            }
        }).start();

        Thread threadD = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("集结完毕，部队开拔");
            }
        });


        try {
            latch.await();//阻塞在这里直到倒序计数器归零才继续下去
            threadD.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
