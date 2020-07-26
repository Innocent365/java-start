package base.keyword;

/**
 * java中static关键字的用法:可以修饰方法，属性，类
 *      static成员变量和类的信息一起存储在方法区,而不是在堆中,一个类的static的成员变量只有一份
 *
 * 修饰成员变量:静态变量属于类,而不属于对象的
 * 		1)静态变量存储在方法区中, 只有一份
 * 		2)常常通过 类名.  来访问			//建议方式。不建议使用对象.
 * 		3)何时用:所有对象的数据都一样
 *
 * 修饰方法:静态方法
 * 		1)静态方法存储在方法区中，只有一份
 * 		2)常常通过类名. 来访问
 * 		3)静态方法中没有隐式的this传递
 * 			静态方法中不能直接访问非静态成员
 * 			因为非静态成员必须通过对象来访问,而没有this就是没有对象
 * 		4)何时用:若方法的执行仅与参数相关而与对象无关(无关成员变量与多态)
 * 				只与传递的参数有关
 * static块:
 * 		1)是属于类的代码块，在类被加载期间执行
 * 		2)因类只被加载一次，所以静态代码块也只执行一次
 * 		3)何时用:常常用于加载静态资源(图片、音频、视频...)
 */
public class StaticDemo1 {
    //private StaticDemo test = new StaticDemo();   //这句代码会抛异常，stackOverflow，而下面这句不会，为什么

    //静态变量是属于类的，存储在方法区中的，初始化之后
    private static StaticDemo1 singeInstance = new StaticDemo1();
    public static Integer a = 3;


    //private StaticDemo test;

    public static int count1;
    public int count2;

    public static String str;   //这里写 str = null; 相当于程序加载后执行了str=null方法，可能覆盖掉前面的值。 导致结果为 null.

    static {
         //a = 3;
        //str = "AAA";
    }

    private StaticDemo1(){
        count1 ++;
        count2 ++;
        str = "Print";
        //a ++;     //（假如a的赋值在执行new之前）这里会抛空指针异常，包装类型a没有初始化
    }

    public static StaticDemo1 getSingeInstance(){
        return singeInstance;
    }

    public static void main(String[] args) {
        StaticDemo1 instance = StaticDemo1.getSingeInstance();
        System.out.println(instance.str);     //null, 1, 1, 3
        System.out.println(instance.count1 );
        System.out.println(instance.count2);
        System.out.println(instance.a);

        //instance.str = "sdds";
        //System.out.println(instance.str);
    }
}

/**
 * 上面的代码执行过程（我的理解）：
 *      1.把类的信息，（类的静态变量、类的变量）声明，所有方法 写进方法区
 *      2.静态的变量与代码块，（假如变量需要初始化）按先后顺序执行
 *          执行初始化方法， singeInstance = new ... 和 str=null,（），后面的 str赋值将前面的覆盖了
 *      3.线程执行程序的顺序，
 *
 */