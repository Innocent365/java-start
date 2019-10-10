package singlePattern;

public class Singleton2 {

    //volatile关键字确保：当uniqueInstance变量被初始化成Singleton实例时，多个线程正确地处理singleton变量 //jdk1.5以上支持
    private volatile static Singleton2 singleton;

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        if (singleton == null) {   //只有第一次才彻底执行这里面的代码
            synchronized (Singleton2.class) {
                if (singleton == null) {   //进入区块后，仍检查一次。如果仍是null，才创建实例
                    singleton = new Singleton2();
                }
            }
        }

        return singleton;
    }
}
