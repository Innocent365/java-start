package leetCode;

import java.util.concurrent.Semaphore;

/**
 * @author hw
 * @version on 2020/5/21
 */
public class _1115_FooBar_Semaphore {

    private Semaphore semaphore1 = new Semaphore(1);
    private Semaphore semaphore2 = new Semaphore(0);

    private int n;

    public _1115_FooBar_Semaphore(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            semaphore1.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();

            //我以为semaphore初始化为0了，没想到还能释放。所以下面这段其实没必要
            //if(semaphore2 == null){
            //    semaphore2 = new Semaphore(1);
            //}else{
            //    semaphore2.release();
            //}
            semaphore2.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            //while (semaphore2 == null);
            semaphore2.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            semaphore1.release();
        }
    }

    public static void main(String[] args) {
        Runnable run1 = new Runnable() {
            @Override
            public void run() {
                System.out.print("foo");
            }
        };

        Runnable run2 = new Runnable() {
            @Override
            public void run() {
                System.out.print("bar");
            }
        };

        int times = 2;
        _1115_FooBar_Semaphore turns = new _1115_FooBar_Semaphore(times);

        Thread thread1 = new Thread(() -> {
            try {
                turns.foo(run1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                turns.bar(run2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
    }


}
