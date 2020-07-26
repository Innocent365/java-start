package javaAdvance.dynamicProxy.cglib;

import javaAdvance.dynamicProxy.RealSubject;
import net.sf.cglib.proxy.Enhancer;

/**
 * @author hw
 * @version on 2019/2/22
 */
public class Run {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(RealSubject.class);
        enhancer.setCallback(new MyMethodInterceptor());

        //使用cjlib动态代理来横向编程
        RealSubject subject = (RealSubject) enhancer.create();
        subject.hello("cglib");
    }
}
