package javaSE.annotate;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class MyReflection {
    public static void main(String[] args) throws Exception {
        MyTest myTest = new MyTest();
        Class<MyTest> c = MyTest.class;
        Method method = c.getMethod("output", new Class[]{});

        if(MyTest.class.isAnnotationPresent(MyAnnotation.class)){   //如果myTest类存在MyAnnotation注解
            System.out.println("hava annotation");
        }

        if(method.isAnnotationPresent(MyAnnotation.class)){ //如果output方法存在MyAnnotation注解
            method.invoke(myTest, null);
            MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
            String hello = myAnnotation.hello();
            String world = myAnnotation.world();
            System.out.println(hello + ", " + world);//打印属性hello和world的值
            System.out.println(myAnnotation.array().length);//打印属性array数组的长度
            System.out.println(myAnnotation.style());
            //System.out.println(myAnnotation.lannotation().value()); //打印属性lannotation的值

        }
        System.out.println("------------------");
        Annotation[] annotations = method.getAnnotations();
        for (Annotation annotation:annotations){
            System.out.println(annotation.annotationType().getName());
        }
    }
}
