package thread.create;

public class _0_ImplRunnable {

    public static void main(String[] args) {
        Runnable r1 = new Runner();
        //将可执行对象传递给线程类，调用start方法执行
        new Thread(r1).start();
        new Thread(r1).start();

        //匿名内部类实现 Runnable 接口
        Runnable runn = new Runnable(){
            public void run(){
                for(int i=0;i<1000;i++){
                    System.out.println("我是查水表的!");
                }
            }
        };
        Thread t2 = new Thread(runn);
        t2.start();
    }
}
/**
 * 第二种创建线程的方式：
 *      实现Runnable接口，并定义线程要执行的任务。创建线程的同时指派任务并启动线程开始工作。
 *
 * 第一种创建线程的方式的不足:
 * 1:线程内部的run方法定义了线程要执行的任务。这就导致了线程与线程的任务有一个强耦合关系。不利于线程的重用。
 * 2:由于java是单继承的，这就导致我们若需要继承某个父类，同时又需要并发运行，就导致我们无法同时继承两个类。
 *
 */
class Runner implements Runnable{

    int x = 0;

    @Override
    public void run() {
        int current = 0;
        for (int i = 0; i < 4; i++) {
            current = x;
            System.out.println(Thread.currentThread().toString() + ":" + current + ",");
            x = current + 2;
        }
    }
}