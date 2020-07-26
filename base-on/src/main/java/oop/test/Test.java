package oop.test;

/**
 *
 * https://www.cnblogs.com/dolphin0520/p/3803432.html
 */
public class Test {
    public static void main(String[] args) {
        Super d = new Demo1("A");
        System.out.println(d.i);
    }
}

class Super {
    int i = 0;

    public Super(String a) {
        System.out.println("A");
        i = 1;
    }

    public Super() {
        System.out.println("B");
        i += 2;
    }
}

class Demo1 extends Super {

    public Demo1(String a) {
        //这里相当于默认调用了父类的无参构造器
        System.out.println("C");
        i += 5;
    }
}



