package leetCode;

import java.util.concurrent.CountDownLatch;

/**
 * @author hw
 * @version on 2020/5/21
 */
public class _1115_FooBar_CountDownLatch {

    private CountDownLatch latch1 = new CountDownLatch(0);
    private CountDownLatch latch2 = new CountDownLatch(1);

    private int n;

    public _1115_FooBar_CountDownLatch(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            latch1.await();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            latch1 = new CountDownLatch(1);
            latch2.countDown();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            latch2.await();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            latch2 = new CountDownLatch(1);
            latch1.countDown();
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

        int times = 10;
        _1115_FooBar_CountDownLatch turns = new _1115_FooBar_CountDownLatch(times);

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
