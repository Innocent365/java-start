package thread.stop;

/**
 * 使用 interrupted() 状态配合线程终端使用
 * @author hw
 * @version on 2020/5/19
 */
public class InterruptThread2 {
    public static void main(String[] args) {
        try {
            Thread thread = new Thread(()->{
                for (int i = 0; i < 500000; i++) {
                    //结合interrupted()方法或isInterrupted()方法一起使用立即停止线程
                    if (Thread.interrupted()) {//即判断当前方法的状态，
                        // 如果不是在匿名内部类中，可以使用this关键字 this.interrupted()

                        System.out.println("已经是停止状态了!我要退出了!");
                        //1.break;此时跳出了循环，后面的代码还是会被执行
                        //break;

                        //2.return方法返回不再执行后面的代码
                        return;
                    }
                    System.out.println("i=" + (i + 1));
                }
                System.out.println("看到这句话说明线程并未终止------");
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


