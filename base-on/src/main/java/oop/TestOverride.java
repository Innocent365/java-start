package oop;


/**
 * 1.先加载 类静态(static{})-> 非静态代码块({}) -> 构造方法（construct）、 父类 -> 子类
 *      即：父类静态代码 -> 子类静态代码
 *          ->父类非静态代码块 ->子类非静态代码块
 *          ->父类构造方法 -> 子类构造方法
 *
 * 2.java里面重写父类方法，无论引用类型是什么，都调用的是重写的方法，
 *  因为没有强制要求加override关键字，所以需要注意 “确认”重写，可以加上 @Override 标识符
 * 3.不允许子类中存在方法签名（与父类完全）相同，返回值不同的方法
 *
 * 4.重写(override)与重载(overload)的区别	---常见面试题
 *      1)重载:一个类中,方法签名不同(方法名相同,参数列表不同),遵循"编译期绑定",根据参数类型绑定方法
 *      2)重写:父子类中,方法签名相同.遵循"运行期绑定",根据对象类型调用方法
 *
 * Created by ss on 2017/2/14.
 */
public class TestOverride {

    public static void main(String[] args){
        FooClass cl = new SubClass();
        cl.testFooFunc();

        //FooStatic
        //SubClassStatic
        //FooBlock
        //FooClass
        //SubClassBlock
        //SubClass
        //testFooFunc
    }
}

class FooClass{

    static {
        System.out.println("FooStatic");
    }

    {
        System.out.println("FooBlock");
    }

    FooClass(){
        System.out.println("FooClass");
    }

    int testFooFunc() throws NumberFormatException{
        System.out.println("testFooFunc");
        return 1;
    }

    int testFooFunc2() throws NumberFormatException{
        System.out.println("testFooFunc");
        return 1;
    }
}

class SubClass extends FooClass{
    SubClass(){
        System.out.println("SubClass");
    }

    static {
        System.out.println("SubClassStatic");
    }

    {
        System.out.println("SubClassBlock");
    }

    @Override
    int testFooFunc() throws IndexOutOfBoundsException {
        super.testFooFunc();
        return 1;
    }

    @Override
    int testFooFunc2() throws NullPointerException{
        System.out.println("testFooFunc");
        return 1;
    }

    void testFooFunc(String text){
        System.out.println("testSubFunc");
    }
}