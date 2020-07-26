package 创建型._3_adapterPattern.objectAdapt;

import 创建型._3_adapterPattern.Targetable;
import 创建型._3_adapterPattern.classAdapt.Source;

/**
 * @author hw
 * @version on 2020/6/22
 */
public class Wrapper implements Targetable {

    private Source source;

    @Override
    public void method1() {
        source.method1();
    }

    @Override
    public void method2() {
        System.out.println("实现接口功能");
    }
}
