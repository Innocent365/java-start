package javaAdvance.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Run {
    public static void main(String[] args) {
        //要代理的真实对象
        ISubject realSubject = new RealSubject();

        InvocationHandler handler = new DynamicProxy(realSubject);

        /**
         * 通过Proxy的newProxyInstance方法来创建我们的代理对象:
         *     第一个参数 handler.getClass().getClassLoader() ，我们这里使用 handler这个类的 ClassLoader对象来加载我们的代理对象
         *     第二个参数 realSubject.getClass().getInterfaces()，我们这里为代理对象提供的接口是真实对象所实行的接口，表示我要代理的是该真实对象，这样我就能调用这组接口中的方法了
         *     第三个参数 handler， 我们这里将这个代理对象关联到了上方的 InvocationHandler 这个对象上
         */
        ISubject subject = (ISubject)Proxy.newProxyInstance(handler.getClass().getClassLoader(),
                realSubject.getClass().getInterfaces(), handler);

        System.out.println(subject.getClass());

        subject.rent();
        subject.hello("world");
        /**
         * 代理对象的内部实现原理：
         * class com.sun.proxy.$Proxy0 implement ISubject{
         *      hello(String str){
         *          Method m = ISubject.getCLass().getMethod()
         *          super.handler.invoke(this, m, str);
         *      }
         * }
         */
    }
}
