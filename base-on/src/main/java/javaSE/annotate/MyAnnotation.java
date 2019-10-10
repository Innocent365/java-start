package javaSE.annotate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
//注解的使用
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String hello() default "gege";
    String world();
    int[] array() default {2,4,5,6};
    EnumTest.TrafficLamp lamp() ;

    TestAnnotation lannotation() default @TestAnnotation(value="ddd");  //类型为注解,默认值为@TestAnnotation，注解里的属性是注解
    Class style() default String.class; //属性style类型为Class,默认值为String类型的Class类型

}


@Retention(RetentionPolicy.SOURCE)      //只有RetentionPolicy.RUNTIME才能被读取到
@Target(ElementType.METHOD)    //也是用来修饰注解的元注解，它有一个属性ElementType也是枚举类型，例如Method 标识只能用在方法上
@interface TestAnnotation{
    String value();
    String[] array = {"first","second","third"};

}
