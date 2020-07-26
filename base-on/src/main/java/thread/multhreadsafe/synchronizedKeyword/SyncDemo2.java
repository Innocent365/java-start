package thread.multhreadsafe.synchronizedKeyword;

/**
 * 使用 同步块 来有效的减少同步范围，可以提高代码并发运行的效率。
 */
public class SyncDemo2 {
    public static void main(String[] args) {
        final Shop shop = new Shop();
        Thread t1 = new Thread() {
            public void run() {
                try {
                    shop.buy();
                } catch (Exception e) {
                }
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                try {
                    shop.buy();
                } catch (Exception e) {
                }
            }
        };
        t1.start();
        t2.start();
    }
}

class Shop {
    /*
     * 假设该方法需要同步(试衣服的过程)
     */
    public void buy() throws InterruptedException {
        //运行buy方法的线程
        Thread t = Thread.currentThread();

        System.out.println(
                t.getName() + ":正在选衣服..."
        );
        Thread.sleep(5000);

        /**
         * 只对引起线程安全的代码进行synchronized同步，
         *  同步的对象是被多个线程共享的对象
         */
        synchronized (this) {
            System.out.println(
                    t.getName() + ":正在试衣服..."
            );
            Thread.sleep(5000);
        }
        System.out.println(
                t.getName() + ":结账离开"
        );

    }
}
/**
 * volatile 与 synchronized 的比较
 * volatile主要用在多个线程感知实例变量被更改了场合，从而使得各个线程获得最新的值。
 * 它强制线程每次从主内存中讲到变量，而不是从线程的私有内存中读取变量，从而保证了数据的可见性。
 * <p>
 * 比较：
 * <p>
 * ①volatile轻量级，只能修饰变量。synchronized重量级，还可修饰方法
 * ②volatile只能保证数据的可见性，不能用来同步，因为多个线程并发访问volatile修饰的变量不会阻塞。
 * synchronized不仅保证可见性，而且还保证原子性，因为，只有获得了锁的线程才能进入临界区，从而保证临界区中的所有语句都全部执行。
 * 多个线程争抢synchronized锁对象时，会出现阻塞。
 */












