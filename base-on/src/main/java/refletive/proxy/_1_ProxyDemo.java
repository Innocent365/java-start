package refletive.proxy;

import jvm.methodarea.JavaMethodAreaOOM;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理强制要求实现类必须最少实现一个接口，但是CGLIB则可以要求实现类不用实现任何接口。
 */
public class _1_ProxyDemo {

    public static void main(String[] args) {
        final List<String> list = new ArrayList<>();

        /** 1.jdk动态代理实现 */
        List<String> proxyInstance =
                (List<String>) Proxy.newProxyInstance(list.getClass().getClassLoader(),
                        list.getClass().getInterfaces(),
                        new InvocationHandler() {
                            @Override
                            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                                System.out.println("代理拦截--------");
                                return method.invoke(list, args);
                            }
                        });
        proxyInstance.add("你好");
        System.out.println(list);
        System.out.println(proxyInstance);//调用toString()方法


        /** 2. cglib动态代理(不是jdk里面的) */
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(list.getClass());
        enhancer.setUseCache(false);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("代理拦截2--------");
                return methodProxy.invokeSuper(o, objects);
            }
        });

        List<String> instance = (List<String>) enhancer.create();
        instance.add("我好大家好");
        System.out.println(instance);
    }

}
