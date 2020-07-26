package leetCode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hw
 * @version on 2020/5/21
 */
public class _1114_Foo_Lock {

    Lock lock = new ReentrantLock();
    volatile int stage = 1;
    Condition stage2 = lock.newCondition();
    Condition stage3 = lock.newCondition();

    public _1114_Foo_Lock() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            stage = 2;
            stage2.signal();
        } finally {
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();

        try {
            while (stage != 2) {
                stage2.wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            stage = 3;
            stage3.signal();
        } finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try{
            while (stage != 3){
                stage3.await();
            }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();

        }finally {
            lock.unlock();
        }
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

        _1114_Foo_Lock foo = new _1114_Foo_Lock();

        Thread threadA = new Thread(() -> {
            try {
                foo.first(run1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                foo.second(run2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadC = new Thread(() -> {
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