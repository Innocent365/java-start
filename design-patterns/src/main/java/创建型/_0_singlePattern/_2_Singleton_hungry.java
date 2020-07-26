package 创建型._0_singlePattern;

/**
 * 饿汉子模式
 */
public class _2_Singleton_hungry {

    /**
     * 对象实例化时就创建了
     */
    private static _2_Singleton_hungry uniqueInstance;

    static {
        uniqueInstance = new _2_Singleton_hungry();
        System.out.println("实例化创建");
    }

    public static _2_Singleton_hungry getInstance() {
        return uniqueInstance;//饿汉子模式-来创建实例
    }


    public synchronized int getCoins() {
        if (this.coins < 0) {
            throw new RuntimeException("It's time up");
        }
        return coins--;
    }


    private int coins = 200;


}
