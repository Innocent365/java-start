package leetCode;

import java.util.concurrent.CountDownLatch;

/**
 * @author hw
 * @version on 2020/5/21
 */
public class _1114_Foo_CountDownLatch {

    private CountDownLatch latch1 = new CountDownLatch(1);
    private CountDownLatch latch2 = new CountDownLatch(1);

    public _1114_Foo_CountDownLatch() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        latch1.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        latch1.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        latch2.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {

        latch2.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

    public static void main(String[] args) {
        Runnable run1 = new Runnable() {
            @Override
            public void run() {
                System.out.print("first");
            }
        };

        Runnable run2 = new Runnable() {
            @Override
            public void run() {
                System.out.print("second");
            }
        };

        Runnable run3 = new Runnable() {
            @Override
            public void run() {
                System.out.print("third");
            }
        };

        _1114_Foo_CountDownLatch foo = new _1114_Foo_CountDownLatch();

        Thread threadA = new Thread(()->{
            try {
                foo.first(run1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadB = new Thread(()->{
            try {
                foo.second(run2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadC = new Thread(()->{
            try {
                foo.third(run3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
    }
}