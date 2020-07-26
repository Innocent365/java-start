package jvm;


/**
 * 1.加载原则：  静态(静态变量、代码块 全部根据代码顺序依次执行) -> 非静态(（成员变量初始化、非静态代码块 根据代码顺序依次执行） -> 构造方法)、  父类 -> 子类、
 *      类静态(static{})-> 非静态代码块({}) -> 构造方法（construct）、 父类 -> 子类
 *      即：父类静态代码 -> 子类静态代码
 *          ->父类非静态代码块 ->子类非静态代码块
 *          ->父类构造方法 -> 子类构造方法
 *
 * 2.java里面重写父类方法，无论引用类型是什么，都调用的是重写的方法，
 *
 * 3.不允许子类中存在方法签名（与父类完全）相同，返回值不同的方法
 *
 *
 */
public class Test {

    public static void main(String[] args){
        FooClass cl = new SubClass();

        //FooStaticVariable
        //FooStaticBlock
        //SubStaticBlock
        //SubStaticVariable

        //FooVariable
        //FooBlock
        //FooClassConstruct

        //SubBlock
        //SubVariable
        //SubClassConstruct

        //testSubFunc

        /**
         * 在Java中，类是按需加载，只有当需要用到这个类的时候，才会加载这个类，并且只会加载一次
         */
        FooClass c2 = new SubClass();
        //注意所有的static块不会被再次执行
    }
}

class Draw {
    public Draw(String type) {
        System.out.println(type);
    }
}

class FooClass{
    /**
     * 会先初始化对象的成员变量，然后再执行构造器。
     * 也就是说类中的变量会在任何方法（包括构造器）调用之前得到初始化，
     * 即使变量散布于方法定义之间（与声明顺序无关）
     */
    static Draw staticDraw = new Draw("FooStaticVariable");

    static {
        System.out.println("FooStaticBlock");
    }

    private Draw draw = new Draw("FooVariable");
    {
        System.out.println("FooBlock");
    }

    FooClass(){
        System.out.println("FooClassConstruct");
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
        System.out.println("SubClassConstruct");
    }

    static {
        System.out.println("SubStaticBlock");
    }
    static Draw staticDraw = new Draw("SubStaticVariable");

    {
        System.out.println("SubBlock");
    }
    private Draw draw = new Draw("SubVariable");

    @Override
    int testFooFunc() throws IndexOutOfBoundsException {
        super.testFooFunc();
        return 1;
    }

    @Override
    int testFooFunc2() throws NullPointerException{
        System.out.println("testSubFunc");
        return 1;
    }

    void testFooFunc(String text){
        System.out.println("testSubFunc");
    }
}