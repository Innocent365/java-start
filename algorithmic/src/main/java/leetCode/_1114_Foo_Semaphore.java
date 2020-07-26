package leetCode;

import java.util.concurrent.Semaphore;

/**
 * @author hw
 * @version on 2020/5/21
 */
public class _1114_Foo_Semaphore {

    Semaphore stage1 = new Semaphore(1);
    Semaphore stage2 = new Semaphore(0);

    public _1114_Foo_Semaphore() {

    }

    public void first(Runnable printFirst) throws InterruptedException {


        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        stage1.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        stage1.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        stage2.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        stage2.acquire();
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

        _1114_Foo_Semaphore foo = new _1114_Foo_Semaphore();

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