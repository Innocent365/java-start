package singlePattern;

/**
 * 单例的另一种实现，不知道什么鬼
 * @author hw
 * @version on 2019/4/26
 */
public enum SimpleSingleton {
    INSTANCE;
    public void doSomething() {
    }
}

class test{
    public static void main(String[] args) {
        //Call the method from Singleton:
        SimpleSingleton.INSTANCE.doSomething();
    }
}