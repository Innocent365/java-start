package singlePattern;

public class Singleton {

    private static Singleton uniqueInstance = new Singleton();

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
        if (this.coins < 0) {
            throw new RuntimeException("It's time up");
        }
    }

    private int coins = 200;

    private Singleton() {

    }


    public static synchronized Singleton getInstance() {
        return uniqueInstance;//饿汉子模式-来创建实例
    }
}
