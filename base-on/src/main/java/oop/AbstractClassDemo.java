package oop;

/**
 * 测试抽象类
 *
 * Created by ss on 2017/2/16.
 */
public abstract class AbstractClassDemo {

    int id;
    static String name;

    public static String convertToJson(){
        return name;
    }

    public abstract String test();

    //abstract static void tests();
}
