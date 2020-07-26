package thread.block;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * if 还是 while
 * 为什么wait了外面还要用while
 *
 */
public class Buf {

    public static void main(String[] args) throws InterruptedException {
        final Buf buf= new Buf();
        ExecutorService es = Executors.newFixedThreadPool(11);
        for (int i = 0; i < 1; i++) {
            es.execute(()->{
                while (true) {
                    try {
                        buf.put(2);
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            });
        }

        for (int i = 0; i < 10; i++) {
            es.execute(()->{
                while (true){
                    try {
                        System.out.print(buf.get());
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }

                }
            });
        }


        ScheduledExecutorService printer = Executors.newScheduledThreadPool(1);
        printer.scheduleAtFixedRate(() -> {
            System.out.println("buf.size:  " + buf.size());
        } , 0, 1, TimeUnit.SECONDS);


        es.shutdown();
        es.awaitTermination(1, TimeUnit.DAYS);
    }


    private final int MAX = 5;
    private final ArrayList<Integer> list = new ArrayList<>();

    synchronized void put(int v) throws InterruptedException {
        while (list.size() == MAX) {//????
            wait();
        }

        list.add(v);
        notifyAll();
    }

    synchronized int get() throws InterruptedException {
        while (list.size() == 0) {
            wait();
        }

        int v = list.remove(0);
        notifyAll();
        return v;
    }

    synchronized int size(){
        return list.size();
    }
}
