package 创建型._0_singlePattern;

import org.junit.Test;


class myThread extends Thread {
    @Override
    public void run() {
        _2_Singleton_hungry singletonHungry = _2_Singleton_hungry.getInstance();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            System.out.println("线程1， 当前：" + singletonHungry.getCoins());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class testRunnable implements Runnable {

    @Override
    public void run() {
        _2_Singleton_hungry singletonHungry = _2_Singleton_hungry.getInstance();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            System.out.println("线程2， 当前：" + singletonHungry.getCoins());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class SingleMan {

    /**
     * 如果使用多个类加载器，可能导致单例失效，而产生多个实例
     */
    public static void main(String[] args) {
        //System.out.println(_2_Singleton_hungry.getInstance() == _2_Singleton_hungry.getInstance());


        //第一种不考虑多线程的单例。
        // 可能，是可能，会产生单例失效，多个实例被创建了出来
        Thread th1 = new myThread();
        Thread th2 = new Thread(new testRunnable());
        th1.start();
        th2.start();

        if(true) return;

        //考虑多线程的单例，单例对象有volatile修饰，初始化的过程有synchronize修饰
        Runnable runner = () -> {
            _Singleton_volatile singleton = _Singleton_volatile.getInstance();
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                System.out.println(Thread.currentThread().getName() + "获取， 当前：" + singleton.getCoins());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread threadA = new Thread(runner, "ThreadA");
        Thread threadB = new Thread(runner, "ThreadB");
        threadA.start();
        threadB.start();
    }

    @Test
    public void test() {
        try {
            String url = System.getProperty("user.dir");
            String home = "创建型/_0_singlePattern";
            String sep = System.getProperty("file.separator");

            System.out.println(url);
            System.out.println(home);
            System.out.println(sep);


            String classPath = "\\DesignPatterns\\创建型._0_singlePattern";
            Class singleton = ClassLoader.getSystemClassLoader().loadClass(classPath + "\\_2_Singleton_hungry");
            Class singleton2 = Class.forName(classPath + "\\_2_Singleton_hungry");

            Object obj = singleton.newInstance();
            Object obj1 = singleton2.newInstance();
            System.out.println(obj == obj1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }
}


/***
 * 有很多对象我们只需要一个，
 * 例如：线程池（threadPool），缓存（cache）、对话框、处理偏好设置、注册表（registry）、日志对象、充当打印机、显卡等设备的驱动程序对象
 * 如果制造很多个实例，就会产生很多问题
 *
 */
