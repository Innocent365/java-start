package space.tulin.concurrent;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExchangerDemo {
    public static void main(String[] args) {

        //交换器，交换String类型数据
        Exchanger<String> ec = new Exchanger<String>();

        ExecutorService threadPool = Executors.newCachedThreadPool();
        //张三团伙
        threadPool.execute(() -> {
            try {
                String returnStr =  ec.exchange("小乔");
                System.out.println("绑架者用小乔交换回： " + returnStr);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {

                    Thread.sleep((long)(Math.random()*10000));
                    Thread.sleep((long)(Math.random()*10000));

                    String returnStr =  ec.exchange("1000万");
                    System.out.println("大乔用1000万交换回： " + returnStr);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadPool.shutdown();
    }
}
