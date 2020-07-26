package refletive.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理的是接口，也就是你的
 * 业务类必须要实现接口，通过 Proxy 里的 newProxyInstance 得到代理对象.
 *
 *
 * 还有一种动态代理 CGLIB，代理的是类，不需要业务类继承接口，通过派生的子类来实现代理。通过在运行
 * 时，动态修改字节码达到修改类的目的。
 *
 */
public class _2_DynamicProxy implements InvocationHandler {

    private Object target;

    /**
     * 动态代理不知道要代理什么东西，只有在运行时才知道。
     */
    private _2_DynamicProxy(Object target) {
        this.target = target;
    }

    public static Object newInstance(Object object) {
        _2_DynamicProxy proxy = new _2_DynamicProxy(object);

        Object result = Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), proxy);
        return result;
    }

    /**
     * 代理类调用方法前可以做很多动作，广泛用于 springAOP前执行切面功能
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //只有方法名为add和delete时候才引入日志
        if (method.getName().equals("add") || method.getName().equals("delete")) {
            //Logger.logInfo("动态代理类");
        }

        // 根据LogAnnotation来判断，如果被标注了注解，则输出日志
//        if(method.isAnnotationPresent(LogAnnotation.class)){
//            LogAnnotation log = method.getAnnotation(LogAnnotation.class);
//            Logger.logInfo(log.value());
//        }
        Object object = method.invoke(target,args);
        return null;
    }
}
