package 创建型._3_adapterPattern.objectAdapt;

import 创建型._3_adapterPattern.Targetable;

/**
 * @author hw
 * @version on 2020/6/22
 */
public class TestAdapter {
    public static void main(String[] args) {
        Targetable target = new Wrapper();
        target.method1();
        target.method2();
    }
}
