package leetCode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * 打印零与奇odd 偶even数
 *
 * 我觉得可以完全干掉循环等待的代码
 */

@SuppressWarnings("ALL")
public class _1116_ZeroEvenOdd_Lock_my {
    private int n;

    private ReentrantLock lock = new ReentrantLock();

    Condition z = lock.newCondition();
    Condition even = lock.newCondition();
    Condition odd = lock.newCondition();


    public _1116_ZeroEvenOdd_Lock_my(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {

        /**
         * 死锁发生了：
         *
         *
         * 这里需要等待另外两个线程运行后处在阻塞状态，否则通知没收到，死锁
         *  但Lock实例的getLength方法与理解的不一致，不能达到效果
         *
         */
        //System.out.println("zero当前1线程数：" + lock.getQueueLength());
        int index = 0;
        while (index < n){
            lock.lock();
            //while (lock.getWaitQueueLength(odd) != 1){
            //    Thread.sleep(1000);
            //}
            try {
                if (index != 0){
                    z.await();
                }
                printNumber.accept(0);
                index++;
                //System.out.println("zero当前2线程数：" + lock.getQueueLength());
                if((index & 1) > 0){
                    //System.out.println("here");
                    odd.signal();
                }else{
                    //System.out.println("there");
                    even.signal();
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
                //System.out.println("even当前1线程数：" + lock.getQueueLength());
                //System.out.println("--");
                even.await();

                //System.out.println("----");
                printNumber.accept(i);
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
                //System.out.println("odd当前1线程数：" + lock.getQueueLength());
                //System.out.println("-");
                odd.await();
                //System.out.println("---");
                printNumber.accept(i);
                z.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        _1116_ZeroEvenOdd_Lock_my bean = new _1116_ZeroEvenOdd_Lock_my(5);

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

        //leecode实际线程启动不受控制
        threadB.start();
        //threadC.join();
        threadC.start();
        threadA.start();
        //threadA.join();
    }
}
