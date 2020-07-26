package oop;


import org.junit.Test;

/**
 * 多态：
 * 访问变量看声明，访问方法看实际对象类型（new出来的类型）
 *
 *  在多态调用时：
 *   成员函数       编译看左边(声明)，运行看右边（实际对象类型）。
 *   静态成员函数    无论编译和运行都参考左边
 *   成员变量       无论编译和运行都参考左边
 *
 */
public class _3_Polym {
    public static void main(String[] args) {
        Shape shape = new Circle();

        /**
         * 覆盖（方法）和隐藏（属性）
         */

        //覆盖只针对非静态方法（终态方法不能被继承，所以就存在覆盖一说了）
        //受RTTI（Runtime type  identification）约束的，动态绑定
        shape.printType();

        /**
         * 	 重写(即覆盖，override)与重载(overload)的区别	---常见面试题
         * 	    方法签名: 方法名和参数列表 (一个类中不可以有两个方法的签名完全相同)
         * 	    1)重载:一个类中,方法名相同,参数列表不同),遵循"编译期绑定",根据参数类型绑定方法
         * 	    2)重写:父子类中,方法签名相同.遵循"运行期绑定",根据对象类型调用方法
         */
    }

    @Test
    public void test(){
        //与方法不同的是对象的属性则不具有多态性,左边原则

        //隐藏是针对成员变量和静态方法的
        Shape shape = new Circle();
        System.out.println(shape.name);//shape

        Circle circle = new Circle();
        System.out.println(circle.name);//circle

        shape = circle;
        System.out.println(shape.name);//shape
    }

    @Test
    public void testStatic(){
        Shape shape = new Circle();
        //在Java中，除了static方法和final方法，其他所有的方法都是动态绑定，左边原则
        shape.printName();//shape
    }
}

class Shape {
    public String name = "shape";

    public Shape() {
        System.out.println("shape constructor");
    }

    public void printType() {
        System.out.println("this is shape");
    }

    public static void printName() {
        System.out.println("shape");
    }
}

class Circle extends Shape {
    public String name = "circle";

    public Circle() {
        System.out.println("circle constructor");
    }

    public void printType() {
        System.out.println("this is circle");
    }

    public static void printName() {
        System.out.println("circle");
    }
}

class FooClass{
    int foo;
    public FooClass(int var) {
        foo = var;
    }
}

class SubClass extends FooClass{
    /**
     * 子类不能够继承父类的构造器：所有的构造器默认为"静态"的，不参与动态绑定，只负责初始化，
     *      不参与创建对象。
     *      new指令专门用于创建对象实例，而调用实例构造器则使用invokespecial指令。
     *
     *      如果父类有无参构造器(默认的或手写的)，则在子类的构造器中用super关键字调用父类构造器不是必须的，系统会自动调用父类的无参构造器。
     * 	    如果父类的构造器都是带有参数的，则必须在子类的构造器中显式地通过super关键字调用父类的构造器并配以适当的参数列表。
     */

    /**
     *  父类没有无参构造，必须手动调用父类构造器，以下二选一都可
     */

    public SubClass() {
        super(1);//调用父类构造器只能写在第一个语句，否则会报错
    }
    //or
    public SubClass(int var) {
        super(var);
    }

    /**
     * 构造函数没有返回类型和返回语句，
     * 建议不要将成员方法的名称与类名相同，容易造成混淆，以下是错误的命名
     */
    public SubClass SubClass() {
        System.out.println("Employee一般方法");
        return new SubClass();
    }


}



  /**
  * 子类是先继承父类后实现接口（拥有的属性和方法先后）
  */


/**
 * 	1.子类继承父类的成员变量
 * 　　可以使用父类中的成员变量，但是并不是完全继承父类的所有成员变量。具体的原则如下：
 * 　　1）能够继承父类的public和protected成员变量；不能够继承父类的private成员变量；
 * 　　2）对于父类的包访问权限成员变量，如果子类和父类在同一个包下，则子类能够继承；否则，子类不能够继承；
 * 　　3）对于子类可以继承的父类成员变量，如果在子类中出现了同名称的成员变量，则会发生隐藏现象，即子类的成员变量会屏蔽掉父类的同名成员变量。
 * 	    也会给他的父类的实例变量分配内存
 * 		如果要在子类中访问父类中同名成员变量，需要使用super关键字来进行引用。
 *
 * 　2.子类继承父类的方法
 * 　　同样地，子类也并不是完全继承父类的所有方法。
 * 　　1）能够继承父类的public和protected成员方法；不能够继承父类的private成员方法；
 * 　　2）对于父类的包访问权限成员方法，如果子类和父类在同一个包下，则子类能够继承；否则，子类不能够继承；
 * 　　3）对于子类可以继承的父类成员方法，如果在子类中出现了同名称的成员方法，则称为覆盖，即子类的成员方法会覆盖掉父类的同名成员方法。
 * 		如果要在子类中访问父类中同名成员方法，需要使用super关键字来进行引用。
 *
 *   3.如上所述，子类不能继承父类的构造器
 *
 * 　注意：隐藏和覆盖是不同的。隐藏是针对成员变量和静态方法的，而覆盖是针对普通方法的。
 */

