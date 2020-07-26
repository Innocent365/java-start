package thread.multhreadsafe.volatileKeyword;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * volatile 不能保证操作的原子性, 不可以代替 synchronized 关键字
 */
public class VolatileMore {

    /**
     * 由于操作语句的非原子性导致的多线程问题
     *
     */
    public static void main(String[] args) {
        final LockTest test = new LockTest();
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<1000;j++)
                        test.increase();
                }
            }.start();
        }

        //保证前面的线程都执行完,
        // debug模式下符合预期，run模式下存在一些问题，但与此篇主题无关
        while(Thread.activeCount()>1)
            Thread.yield();
        System.out.println(test.inc);
        /**
         * 可以看到这里并不能保证inc值为10*10000，事实上运行它会发现每次运行结果都不一致，都是一个小于10000的数字。
         * 为什么 ？
         * 线程1对变量进行读取操作之后，被阻塞了的话，并没有对inc值进行修改。
         * 然后虽然volatile能保证线程2对变量inc的值读取是从内存中读取的，但是线程1没有进行修改，所以线程2根本就不会看到修改的值。
         *
         * Java内存模型只保证了基本读取和赋值是原子性操作，如果要实现更大范围操作的原子性，可以通过synchronized和Lock来实现。
         */
    }
}
class Test {
    /**
     * 一旦一个共享变量（类的成员变量、类的静态成员变量）被volatile修饰之后，那么就具备了两层语义：
     *
     * 　　1）保证了不同线程对这个变量进行操作时的可见性，即一个线程修改了某个变量的值，这新值对其他线程来说是立即可见的。
     * 　　2）禁止进行指令重排序。
     */
    public int inc = 0;

    public void increase() {
        inc++;//自增操作是不具备原子性的，它包括读取变量的原始值、进行加1操作、写入工作内存。
        // 那么就是说自增操作的三个子操作可能会分割开执行
    }
}





/**
 * volatile关键子不可以代替 synchronized、Lock 关键字
 * 以下两种方式都可以保证得到的是10*1000
 */
class synchronizedTest{
    public  int inc = 0;

    public synchronized void increase() {
        inc++;
    }
}

class LockTest {
    public int inc = 0;
    //ReentrantLock 重进入锁
    Lock lock = new ReentrantLock();

    public void increase() {
        lock.lock();
        try {
            inc++;
        } finally {
            lock.unlock();
        }
    }
}

/**
 * 在java 1.5的java.util.concurrent.atomic包下提供了一些原子操作类，即对基本数据类型的 自增（加1操作），自减（减1操作）、以及加法操作（加一个数），减法操作（减一个数）进行了封装，保证这些操作是原子性操作。
 * atomic是利用CAS来实现原子性操作的（Compare And Swap），
 */

//采用AtomicInteger锁机制
class AtomicIntegerTest {
    public AtomicInteger inc = new AtomicInteger();

    public void increase() {
        inc.getAndIncrement();
    }
}