package base.keyword;


/**
 *
 * final关键字:不可变
 *      1)修饰变量:该变量不能被改变
 *      2)修饰方法:该方法不能被重写
 *          修饰方法参数：不可在方法内部改变
 *      3)修饰类:该类不能被继承（参考Integer、String）
 *
 */
public class FinalDemo {

    /**
     *  final修饰变量(成员变量 + 静态变量 = 宏变量): 要在初始化的时候赋值,且不能更改
    */
    public final int a = 10;

    //成员变量
    public final int b; //必须赋初值,否则报错.除非像下面,在实例初始化的时候赋值.其实是一样的.
    {
        b = 12;
    }

    //静态变量(常量)	没有类加载过程---效率高,常用——常量名建议,所有字母都大写
    public final static String  KEY = "key";
    public static final int c; //static关键字修饰亦如此
    static {
        c = 111;
    }

    /**
     * 修饰方法
     *  方法不能被子类重写,即 override. 但不影响重载, 即 overload
     *
     *  对于static关键字修饰的方法，由于调用时参数是各个线程栈空间传入的私有的。所以与其无关。
     *      对于静态变量，若没有final修饰，就要考虑假如线程执行过程中被篡改的情况。
     */
    public final void testMethod() {
    }


    /**
     *  final修饰方法参数(相当于修饰局部变量):
     *    防止方法参数在调用时被篡改。
     *      1.对于基本类型及其包装类，final关键字无用（本身已经是不可变对象）
     *      2.对于引用类型，亦可以防止参数被重新赋值。
     */
    public void testParameter(final Integer a, Integer b){ ////防止在方法内部参数无意被篡改。导致方法执行出出现隐藏的bug
        //a = 1;//编译错误,不能被重新赋值
        b = 1;//可以赋值，但是对于基本类型及其包装类，赋值在方法结束后
    }
}