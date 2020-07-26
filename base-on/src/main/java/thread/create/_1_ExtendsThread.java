package thread.create;

/**
 * 第一种创建线程的方式:
 * 定义一个类，并继承Thread，重写run方法。
 * run方法中就可以定义当前线程要执行的任务了。
 */
class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("我是查水表的!");
        }

        //使用继承 Thread 类的方式创建多线程时，
        //  如果需要访问当前线程，则无需使用 Thread.currentThread() 方法，直接使用 this 即可获得当前线程。
        System.out.println(currentThread() == this);
    }
}

public class _1_ExtendsThread {
    public static void main(String[] args) {

        Thread t = new MyThread();

        /*
         * 启动线程不要去直接调用线程的run方法，因为该方法是线程要执行的任务。而我们要
         * 调用的是start方法。该方法的作用是将当前线程纳入到线程调度中，使其具有可以并发执行的能力。
         * start方法调用完毕后，线程处于runnable状态。只要它被分配了CPU的时间片，就会开始运行，这时它会自动调用run方法。
         */
        t.start();

        //使用匿名内部类创建线程类，仅适用于使用一次的线程
        Thread t1 = new Thread(
            new Runnable(){
                @Override
                public void run () {
                    for (int i = 0; i < 1000; i++) {
                        System.out.println("你是谁啊?");
                    }
                }
            }
        );
        //简写
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("你是谁啊?");
            }
        });


        t1.start();
    }
}
