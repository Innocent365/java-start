package singlePattern;

import org.junit.Test;


/***如果使用多个类加载器，可能导致单例失效，而产生多个实例*/
public class SingleMan {
    public static void main(String[] args) {
//        System.out.println(Singleton.getInstance() == Singleton.getInstance());
        Thread th1 = new myThread();
        Thread th2 = new Thread(new testRunnable());
        th1.start();
        th2.start();
    }

    @Test
    public void test() {
        try {
            String url = System.getProperty("user.dir");
            String home = "singlePattern";
            String sep = System.getProperty("file.separator");

            System.out.println(url);
            System.out.println(home);
            System.out.println(sep);


            String classPath = "D:\\Users\\ss\\IdeaProjects\\DesignPatterns\\out\\production\\DesignPatterns\\singlePattern";
            Class singleton = ClassLoader.getSystemClassLoader().loadClass(classPath + "\\Singleton");
            Class singleton2 = Class.forName(classPath + "\\Singleton");

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

class myThread extends Thread {
    @Override
    public void run() {
        Singleton singleton = Singleton.getInstance();
        int coins = singleton.getCoins();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            System.out.println("线程1， 当前 " + coins);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            singleton.setCoins(coins--);
        }
    }
}

class testRunnable implements Runnable {

    @Override
    public void run() {
        Singleton singleton = Singleton.getInstance();
        int coins = singleton.getCoins();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            System.out.println("线程2， 当前：" + coins);
            singleton.setCoins(coins--);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/***
 * 有很多对象我们只需要一个，
 * 例如：线程池（threadPool），缓存（cache）、对话框、处理偏好设置、注册表（registry）、日志对象、充当打印机、显卡等设备的驱动程序对象
 * 如果制造很多个实例，就会产生很多问题
 *
 */
