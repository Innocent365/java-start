package thread.stop;

/**
 * @author hw
 * @version on 2020/5/19
 */

public class InterruptThread3 {
    public static void main(String[] args) {
        try {
            Thread thread = new Thread(()->{
                try {
                for (int i = 0; i < 500000; i++) {
                    //结合interrupted()方法或isInterrupted()方法一起使用立即停止线程
                    if (Thread.interrupted()) {
                        System.out.println("已经是停止状态了!我要退出了!");
                        //抛异常的方式实现线程的立即停止
                        throw new InterruptedException();
                    }
                    System.out.println("i=" + (i + 1));
                }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
            Thread.sleep(2000);
            thread.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end!");
    }
}


