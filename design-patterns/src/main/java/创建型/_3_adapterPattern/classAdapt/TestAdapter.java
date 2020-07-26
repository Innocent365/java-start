package 创建型._3_adapterPattern.classAdapt;

import 创建型._3_adapterPattern.Targetable;

/**
 *
 * TODO
 *  适配器模式将某个类的接口转换成客户端期望的另一个接口表示，
 *      目的是消除由于接口不匹配所造成的类的兼容性问题。
 *      主要分为三类：类的适配器模式、对象的适配器模式、接口的适配器模式
 *
 */
public class TestAdapter {

    public static void main(String[] args) {
        Targetable target = new Adapter();
        target.method1();
        target.method2();
    }

}
