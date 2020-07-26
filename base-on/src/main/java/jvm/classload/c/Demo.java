package jvm.classload.c;

/**
 * @author hw
 * @version on 2020/2/11
 */
public class Demo {
    public Demo() {
        System.out.println("loader3 init....." + this.getClass().getClassLoader());
    }
}
