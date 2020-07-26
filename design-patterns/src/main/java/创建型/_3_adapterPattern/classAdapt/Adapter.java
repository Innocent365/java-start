package 创建型._3_adapterPattern.classAdapt;

import 创建型._3_adapterPattern.Targetable;

/**
 * 父类Source 帮我们实现了method1方法，避免了不兼容
 *
 */
public class Adapter extends Source implements Targetable {

    @Override
    public void method2() {
        System.out.println("实现接口功能");
    }
}
