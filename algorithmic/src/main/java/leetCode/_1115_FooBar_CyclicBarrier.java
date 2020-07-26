package leetCode;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * @author hw
 * @version on 2020/5/21
 */
public class _1115_FooBar_CyclicBarrier {

    private CyclicBarrier barrier1 = new CyclicBarrier(2);
    private CyclicBarrier barrier2 = new CyclicBarrier(2);

    private int n;

    public _1115_FooBar_CyclicBarrier(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            try {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                if (i != 0) {
                    barrier1.await();
                }
                printFoo.run();
                barrier2.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            try {
                barrier2.await();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();

                //事实证明此处不用reset
                //barrier2.reset();
                //barrier1.reset();

                if(i < n-1){
                    barrier1.await();
                }
            } catch (BrokenBarrierException ex) {
                ex.printStackTrace();
            }
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
        _1115_FooBar_CyclicBarrier turns = new _1115_FooBar_CyclicBarrier(times);

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
