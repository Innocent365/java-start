package thread.block.waitandnotify;

/**
 * wait方法
 *      作用就是阻塞当前线程等待notify/notifyAll方法的唤醒，或等待超时后自动唤醒。
 *      注意：依赖同步锁，否则就会抛出IllegalMonitorStateException异常
 *
 *
 * 死锁：
 *
 *
 */
public class WaitTest {
    public static void main(String[] args) {
        final WaitTest test = new WaitTest();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test.testWait();
            }
        }).start();
    }


    public synchronized void testWait(){
        System.out.println("Start-----");
        try {
            wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End-------");
    }

}
