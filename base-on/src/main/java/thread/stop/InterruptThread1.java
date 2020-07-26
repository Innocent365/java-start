package thread.stop;

/**
 * @author hw
 * @version on 2020/5/19
 */
public class InterruptThread1 {

    public static void main(String[] args) {
        try {
            Thread thread = new Thread(()->{
                for (int i = 0; i < 5000000; i++) {
                    System.out.println("i=" + (i + 1));
                }
            });
            thread.start();
            Thread.sleep(2000);

            //没有立即停止。interrupt只相当于给当前线程打上了一个停止的标记
            thread.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
    }

}
