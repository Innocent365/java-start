package 创建型._0_singlePattern;

/**
 * 双重检查锁模式
 */
public class _Singleton_volatile {

    //volatile关键字确保：当uniqueInstance变量被初始化成Singleton实例时，多个线程正确地处理singleton变量 //jdk1.5以上支持
    //还可以禁止指令重排序
    private volatile static _Singleton_volatile singleton;

    private _Singleton_volatile() {
    }

    public static _Singleton_volatile getInstance() {
        if (singleton == null) {   //只有第一次才彻底执行这里面的代码
            synchronized (_Singleton_volatile.class) {
                if (singleton == null) {   //进入区块后，仍检查一次。如果仍是null，才创建实例
                    singleton = new _Singleton_volatile();
                    System.out.println("实例化创建");
                }
            }
        }

        return singleton;
    }

    public synchronized int getCoins() {
        if(coins==0){
            throw new RuntimeException("没有了!");
        }
        return coins--;
    }

    private volatile Integer coins = 200;

}
