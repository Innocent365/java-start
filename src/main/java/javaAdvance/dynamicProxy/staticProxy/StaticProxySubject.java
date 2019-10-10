package javaAdvance.dynamicProxy.staticProxy;

import javaAdvance.dynamicProxy.ISubject;
import javaAdvance.dynamicProxy.RealSubject;

/**
 * 静态代理，使用组合的方式，重写类的方法，实现切面
 * @author hw
 * @version on 2019/2/22
 */
public class StaticProxySubject implements ISubject {

    private ISubject subject = new RealSubject();

    @Override
    public void rent() {
        System.out.println("proxy start...");
        subject.rent();
    }

    @Override
    public void hello(String str) {
        System.out.println("proxy2 start...");
        subject.hello(str);
    }

    public static void main(String[] args) {
        ISubject staticProxySubject = new StaticProxySubject();
        staticProxySubject.hello("你好啊");
    }
}
