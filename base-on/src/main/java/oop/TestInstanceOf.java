package oop;

/**
 *
 * 使用 equals比较 两种 class 类型是否相同时，仅有类型完全一致的两个类型才判断完全相等
 *  使用 instanceof 关键字 判断时，只要实例有继承（实现）该接口就成立
 * @author hw
 * @version on 2019/3/14
 */
public class TestInstanceOf {
    public static void main(String[] args) {
        X x = new XX();
        Class cls = x.getClass();

        System.out.println(W.class.equals(cls));    //false
        System.out.println(X.class.equals(cls));    //false
        System.out.println(XX.class.equals(cls));   //true

        System.out.println(x instanceof W);     ////true
        System.out.println(x instanceof X);     ////true
        System.out.println(x instanceof XX);    ////true

        System.out.println(null instanceof Integer);    //false
        System.out.println(null instanceof String);     //false
    }
}

interface W{

}

class X implements W{

}

class XX extends X{

}
