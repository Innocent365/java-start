package thread.block.waitandnotify;

/**
 *
 * notify/notifyAll方法:
 *      要在同一对象上去调用notify/notifyAll方法，就可以唤醒对应对象monitor上等待的线程了。
 *
 */
public class NotifyTest {

    public synchronized void testWait(){
        System.out.println(Thread.currentThread().getName() +" Start-----");
        try {
            wait(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() +" End-------");
    }

    public static void main(String[] args) throws InterruptedException {
        final NotifyTest test = new NotifyTest();
        for(int i=0;i<5;i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    test.testWait();
                }
            }).start();
        }

        synchronized (test) {
            test.notify();//并不能确切的唤醒某一个等待状态的线程，
            // 而是由 JVM 确定唤醒哪个线程，而且与优先级无关；
        }
        Thread.sleep(3000);
        System.out.println("-----------分割线-------------");

        synchronized (test) {
            test.notifyAll();//全部唤醒
        }
    }
}
