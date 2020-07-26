package leetCode;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hw
 * @version on 2020/5/21
 */
public class _1115_FooBar_Lock {

    private Lock lock = new ReentrantLock();
    private volatile boolean isFoo = true;

    private int n;

    public _1115_FooBar_Lock(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; ) {
            lock.lock();
            try {
                if (isFoo) {
                    // printFoo.run() outputs "foo". Do not change or remove this line.
                    printFoo.run();
                    isFoo = false;
                    i++;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; ) {
            lock.lock();
            try {
                if (!isFoo) {
                    // printBar.run() outputs "bar". Do not change or remove this line.
                    printBar.run();
                    isFoo = true;
                    i++;
                }
            } finally {
                lock.unlock();
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
        _1115_FooBar_Lock turns = new _1115_FooBar_Lock(times);

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
