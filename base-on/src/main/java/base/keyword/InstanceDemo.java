package base.keyword;

import org.junit.Test;

/**
 *  凡是null相关的都是false
 * @author hw
 * @version on 2019/3/14
 */
interface W{}
class X implements W{}
class XX extends X{}

public class InstanceDemo {
    /**
     * instanceof 关键字 判断时，只要实例有继承（实现）该接口就成立
     * 使用 equals比较 两种 class 类型是否相同时，仅有类型完全一致的两个类型才判断完全相等
     */
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

        System.out.println(x instanceof Object);//true
    }


    /**
     * boolean isInstance(Object obj) 方法是Class类的一个方法：
     *      判定指定的Object是否与此Class所表示的对象赋值兼容。
     *      若传入的obj不为空, 且能够在不引发ClassCastException的情况下，返回true，否则返回false
     *
     */
    @Test
    public void isInstance(){
        String str = "111";
        if(String.class.isInstance(str)){
            System.out.println("兼容");
        }

        int[] arr = {1,2,12};
        System.out.println(int.class.isInstance(arr));//false
        System.out.println(int[].class.isInstance(arr));//true
        System.out.println(Integer.class.isInstance(arr));//false
    }
}


