package javaSE.annotate;

import java.util.HashMap;

@MyAnnotation(hello = "beijing", world = "shanghai", array = {1,2,3},lamp = EnumTest.TrafficLamp.Green)
public class MyTest {

    @TestAnnotation("Awesome")      //如果注解中有一个属性名字叫value,则在应用时可以省略属性名字不写。
    @MyAnnotation(hello = "shit", world = "shanghai", array = {1,3},lamp = EnumTest.TrafficLamp.Yellow, style = HashMap.class)
    public void output(){
        System.out.println("This is output function!");
    }
}
