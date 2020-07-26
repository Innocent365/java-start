package oop;

/**
 * 抽象类
 *      包含抽象方法的类必须是抽象类
 *      不包含抽象方法的类也可以写成抽象类
 *
 *      抽象类不能被实例化
 *
 *	final不能修饰抽象类或抽象方法
 *
 *      5)抽象类的意义:
 * 		5.1)父类的意义:
 * 			可以封装子类共有的数据和方法,便于代码的重用
 * 			父类为子类提供了一种公共的类型---向上造型
 * 		5.2)包含抽象方法,为子类提供了一个统一的入口
 * 			具体的实现还是看子类的方法---重写后看对象(弥补抽象类不能)
 */
public abstract class _2_AbstractClassDemo {

    final int id;
    static String name;

    //抽象类也可以有构造方法
    public _2_AbstractClassDemo(int id) {
        this.id = id;
    }

    //抽象类可以有静态代码块和静态方法
    static {

    }

    public static String convertToJson(){
        return name;
    }

    //抽象方法必须为public或者protected（因为如果为private，则不能被子类继承，子类便无法实现该方法），
    // 缺省情况下默认为public。
    public abstract String test();

    //不能用static修饰抽象方法
    //abstract static void  tests();
}
