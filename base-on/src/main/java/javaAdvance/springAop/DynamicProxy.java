package javaAdvance.springAop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.logging.Logger;

public class DynamicProxy implements InvocationHandler {

    private Object target;

    private DynamicProxy(Object target) {
        this.target = target;
    }

    public static Object newInstance(Object object) {
        DynamicProxy proxy = new DynamicProxy(object);

        Object result = Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), proxy);
        return result;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //只有方法名为add和delete时候才引入日志
        //if (method.getName().equals("add") || method.getName().equals("delete")) {
        //    Logger.logInfo("动态代理类");
        //}

        // 根据LogAnnotation来判断，如果被标注了注解，则输出日志
//        if(method.isAnnotationPresent(LogAnnotation.class)){
//            LogAnnotation log = method.getAnnotation(LogAnnotation.class);
//            Logger.logInfo(log.value());
//        }
        Object object = method.invoke(target,args);
        return null;
    }
}

interface LogAnnotation{

}
