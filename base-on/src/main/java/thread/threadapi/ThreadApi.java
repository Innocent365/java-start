package thread.threadapi;

/**
 * @author hw
 * @version on 2020/5/18
 */
public class ThreadApi {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                //ignore
            }
        });
        thread.start();

        //线程优先级默认继承当前启动线程的优先级，这里为 NORM_PRIORITY(5)
        System.out.println("主线程优先级："+ Thread.currentThread().getPriority());
        System.out.println("线程优先级：" + thread.getPriority());

        //
        thread.join();

        thread.interrupt();
        //线程休眠方法：静态方法 throws InterruptedException
        Thread.sleep(1000);

        //Thread.holdsLock()
        Thread.currentThread();
    }

}
