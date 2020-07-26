package jvm.methodarea;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 借助CGLib动态产生类填满方法区
 *
 * jdk7:
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 *
 *
 * jdk8起，永久代便完全退出了历史舞台，元空间作为其替代者登场。
 * -XX:MaxMetaspaceSize: 设置元空间最大值，默认是-1，即不限制，或者说只限制本地内存大小
 * -XX:MetaspaceSize: 指定元空间的初始值大小，以字节为单位，达到该值就会触发垃圾手机进行类型卸载
 *
 *
 */
public class JavaMethodAreaOOM {

    public static void main(String[] args) {
        while (true){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(o, objects);
                }
            });
            enhancer.create();
        }
    }
    public static class OOMObject{}
}
