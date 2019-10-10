package space.tulin.concurrent;

import java.util.concurrent.*;

public class CyclicBarrierDemo {

    public static void main(String[] args) {
        //3人聚餐
        final CyclicBarrier cb = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("人员全部到齐了，各自拍照留念...");
            }
        });

        //线程池
        final ExecutorService threadPool = Executors.newCachedThreadPool();


        //每个线程是一个人员
        for (int i = 0; i < 3; i++) {
            final int user = i + 1;
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    try {
                        //模拟每个人来的时间各不一样
                        Thread.sleep((long)(Math.random() * 10000));
                        System.out.println(user + "到达聚餐点，当前已有" + (cb.getNumberWaiting() + 1));
                        //阻塞
                        cb.await();
                        if(user==1){
                            System.out.println("人员全部到齐，开始吃饭...");
                        }

                        Thread.sleep((long)(Math.random() * 10000));
                        System.out.println(user + "吃完饭，到广场集合，开始 xxx 活动...");

                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            };
            threadPool.execute(r);
        }
        threadPool.shutdown();
    }
}
