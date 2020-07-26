package leetCode;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author hw
 * @version on 2020/5/21
 */
public class _1114_Foo_CyclicBarrier {

    private CyclicBarrier barrier1 = new CyclicBarrier(2);
    private CyclicBarrier barrier2 = new CyclicBarrier(2);

    public _1114_Foo_CyclicBarrier() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        try {
            barrier1.await();
        }catch (BrokenBarrierException e){
            e.printStackTrace();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {

        try {
            barrier1.await();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            barrier2.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {

        try {
            barrier2.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
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

        _1114_Foo_CyclicBarrier foo = new _1114_Foo_CyclicBarrier();

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