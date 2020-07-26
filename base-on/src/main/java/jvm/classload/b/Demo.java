package jvm.classload.b;

/**
 * @author hw
 * @version on 2020/2/11
 */
public class Demo {
    public Demo() {
        System.out.println("loader2 init....." + this.getClass().getClassLoader());
    }
}
