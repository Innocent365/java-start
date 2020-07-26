package thread.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock是synchronized关键字的进阶，掌握Lock有助于学习并发包中的源代码
 *
 *  实现类： ReentrantLock ， ReentrantReadWriteLock.ReadLock ， ReentrantReadWriteLock.WriteLock
 *
 * @author hw
 * @version on 2020/5/24
 */
public class LockTest {
    public static void main(String[] args) {
        LockObj obj = new LockObj();
        MyRunner runn = new MyRunner(obj);

        Thread threadA = new Thread(runn, "A");
        Thread threadB = new Thread(runn, "B");

        threadA.start();
        threadB.start();
    }
}

class LockObj {
    Lock lock = new ReentrantLock();

    public void lockFuc() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "得到了锁");
        } finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + "释放了锁");
        }
    }
}

class MyRunner implements Runnable {
    private LockObj lo;

    public MyRunner(LockObj lo) {
        this.lo = lo;
    }

    @Override
    public void run() {
        lo.lockFuc();
    }
}

/**
 *
 * Lock接口提供的synchronized关键字不具备的主要特性：
 *  boolean tryLock():尝试非阻塞地获取锁
 *      当前线程尝试获取锁，如果这一时刻锁没有被其他线程获取到，则成功获取并持有锁
 *
 *  boolean tryLock(long time, TimeUnit unit):超时获取锁
*      	在指定的截止时间之前获取锁， 超过截止时间后仍旧无法获取则返回
 *
 *
 *
 *  void lockInterruptibly():能被中断地获取锁
 *      获取到锁的线程能够响应中断，当获取到锁的线程被中断时，中断异常将会被抛出，同时锁会被释放
 *
 *
 */
