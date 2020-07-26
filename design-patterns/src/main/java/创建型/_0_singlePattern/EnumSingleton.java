package 创建型._0_singlePattern;

import java.io.PrintStream;

/**
 * 单例的另一种"枚举"实现。力荐，缺点: 无法实现懒加载
 * @author hw
 * @version on 2019/4/26
 */
public enum EnumSingleton {
    INSTANCE;

    private PrintStream print = System.out;
    public void doSomething() {
        print.print("------------------------------");

    }
}

class test{
    public static void main(String[] args) {
        //Call the method from _2_Singleton_hungry:
        EnumSingleton.INSTANCE.doSomething();
    }
}