package javaSE.threadDemo;

/**
 *  线程:用来同时执行多个任务使用。
 *  线程的运行是并发的。
 *  创建线程有两种方式。
 */


import org.junit.Test;

/**
 * 第一种创建线程的方式:
 * 定义一个类，并继承Thread，重写run方法。
 * run方法中就可以定义当前线程要执行的任务了。
 *
 */
class MyThread2 extends Thread {
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("我是查水表的!");
        }
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
class MyRunnable1 implements Runnable{
    public void run() {
        for(int i=0;i<1000;i++){
            System.out.println("你是谁啊?");
        }
    }
}





public class ThreadCreateDemo {
    public static void main(String[] args) {

        Runnable r1 = new MyRunnable1();//创建线程要执行的任务
        Thread t1 = new Thread(r1);

        Thread t2 = new MyThread2();

        /*
         * 启动线程不要去直接调用线程的run方法，因为该方法是线程要执行的任务。而我们要
         * 调用的是start方法。该方法的作用是将当前线程纳入到线程调度中，使其具有可以并发执行的能力。
         * start方法调用完毕后，线程处于runnable状态。只要它被分配了CPU的时间片，就会开始运行，这时它会自动调用run方法。
         */
        t1.start();
        t2.start();
    }


    @Test//使用匿名内部类的形式创建线程，仅适用于使用一次的线程
    public void normalCreate() {

         //第一种创建线程的形式
        Thread t1 = new Thread(){
            public void run(){
                for(int i=0;i<1000;i++){
                    System.out.println("你是谁啊?");
                }
            }
        };

        //第二种创建线程的方式
        Runnable runn = new Runnable(){
            public void run(){
                for(int i=0;i<1000;i++){
                    System.out.println("我是查水表的!");
                }
            }
        };
        Thread t2 = new Thread(runn);

        t1.start();
        t2.start();
    }
    
}
