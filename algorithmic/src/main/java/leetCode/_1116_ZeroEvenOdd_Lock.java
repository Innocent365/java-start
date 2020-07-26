package leetCode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * 打印零与奇odd 偶even数
 *
 * @author hw
 * @version on 2020/5/22
 */
@SuppressWarnings("All")
public class _1116_ZeroEvenOdd_Lock {
    private int n;

    private ReentrantLock lock = new ReentrantLock();

    Condition z = lock.newCondition();
    Condition even = lock.newCondition();
    Condition odd = lock.newCondition();

    private volatile int who = 0;

    public _1116_ZeroEvenOdd_Lock(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {

        int index = 0;
        while (index < n) {
            lock.lock();
            try {
                while (who != 0){
                    z.await();
                }
                printNumber.accept(0);
                index++;
                if((index & 1) > 0){
                    odd.signal();
                    who = 1;
                }else{
                    even.signal();
                    who = 2;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            lock.lock();
            try {
                while (who != 2){
                    even.await();
                }
                printNumber.accept(i);
                who = 0;
                z.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            lock.lock();
            try {
                while (who != 1){
                    odd.await();
                }
                printNumber.accept(i);
                who = 0;
                z.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        _1116_ZeroEvenOdd_Lock bean = new _1116_ZeroEvenOdd_Lock(5);

        Thread threadA = new Thread(() -> {
            try {
                bean.zero(p -> {
                    System.out.print(p);
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                bean.odd(p -> {
                    System.out.print(p);
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadC = new Thread(() -> {
            try {
                bean.even(p -> {
                    if (p % 2 == 1) {
                        throw new RuntimeException("必须是偶数");
                    }
                    System.out.print(p);
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
    }
}
