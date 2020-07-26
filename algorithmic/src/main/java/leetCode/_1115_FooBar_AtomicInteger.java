package leetCode;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author hw
 * @version on 2020/5/21
 */
public class _1115_FooBar_AtomicInteger {
    private int n;

    private AtomicInteger inc = new AtomicInteger();

    public _1115_FooBar_AtomicInteger(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while ((inc.intValue() & 1) == 1);
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            inc.incrementAndGet();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while ((inc.intValue() & 1) == 0);
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            inc.incrementAndGet();
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

        int times = 5;
        _1115_FooBar_AtomicInteger turns = new _1115_FooBar_AtomicInteger(times);

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
