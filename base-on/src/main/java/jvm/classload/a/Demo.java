package jvm.classload.a;

/**
 * @author hw
 * @version on 2020/2/11
 */
public class Demo {
    public Demo() {
        System.out.println("loader1 init....." + this.getClass().getClassLoader());
    }

    public static void main(String[] args) {
        new Demo();
    }
}
