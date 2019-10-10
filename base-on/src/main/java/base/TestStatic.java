package base;

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
 * 		4)何时用:若方法的执行仅与参数相关而与对象无关
 * 					int[] arr = {23,34,36,27};
 * 					Array arr1 = new Array();
 * 					arr_0=arr1.sort(arr);
 * 					Array arr2 = new Array();
 * 					arr_1=arr2.sort(arr);
 * 					Array arr3 = new Array();
 * 					arr_2=arr3.sort(arr);
 * 				arr1=arr2=arr3结果与对象无关,只与传递的参数有关
 * static块:
 * 		1)是属于类的代码块，在类被加载期间执行
 * 		2)因类只被加载一次，所以静态代码块也只执行一次
 * 		3)何时用:常常用于加载静态资源(图片、音频、视频...)
 * Created by ss on 2017/2/14.
 */
public class TestStatic {

    public static void main(String[] args) {
        StaticDemo instance = StaticDemo.getSingeInstance();
        System.out.println(instance.str + ": " + instance.count1 + ", " + instance.count2);     //null, 1, 1

        System.out.println(instance.a);

        //instance.str = "sdds";
        //System.out.println(instance.str);
    }
}


class StaticDemo {
    //private StaticDemo test = new StaticDemo();   //这句代码会抛异常，堆溢出，而下面这句不会，为什么

    public static Integer a = 3;
    private static StaticDemo singeInstance = new StaticDemo();

    //静态变量是属于类的，存储在方法区中的，初始化之后
    private StaticDemo test;

    public static int count1;
    public int count2;

    public static String str;   //这里写 str = null; 相当于程序加载后执行了str=null方法，可能覆盖掉前面的值。 导致结果为 null.

    static {
         //a = 3;
        //str = "AAA";
    }

    private StaticDemo(){
        count1 ++;
        count2 ++;
        str = "Print";
        a ++;     //这里会抛空指针异常，包装类型a没有初始化
    }

    public static StaticDemo getSingeInstance(){
        return singeInstance;
    }

}


/**
 * 上面的代码执行过程（我的理解）：
 *      1.把类的信息，类的静态变量，类的变量，所有方法 写进方法区
 *      2.static 修饰的变量 ，假如有初始化，执行初始化方法， singeInstance = new ... 和 str=null, 这里按先后顺序执行，后面的 str赋值将前面的覆盖了
 *      3.线程执行程序的顺序，
 *
 */

class StaticTest
{
    public static void main(String[] args)
    {
        staticFunction();
    }

    static StaticTest st = new StaticTest();

    static
    {
        System.out.println("1");
    }

    {
        System.out.println("2");
    }

    StaticTest()
    {
        System.out.println("3");
        System.out.println("a="+a+",b="+b);
    }

    public static void staticFunction(){
        System.out.println("4");
    }

    int a=110;
    static int b =112;
}
/**
类的生命周期是：加载->验证-> 准备->解析->初始化->使用->卸载。
 只有在准备阶段和初始化阶段才会涉及类变量的初始化和赋值，因此只针对这两个阶段进行分析；
    准备：为类变量分配内存并设置默认值，因此类变量st为null、b为0；
        需要注意的是如果类变量是final，编译时javac将会为value生成ConstantValue属性，在准备阶段虚拟机就会根据ConstantValue的设置将变量设置为指定的值。
        如果这里这么定义：static final int b=112，那么在准备阶段b的值就是112，而不再是0了。
    初始化：执行类构造器
         类构造器是编译器收集所有静态语句块和类变量的赋值语句，按语句在源码中的顺序合并生成类构造器，
            对象的构造方法是()，
            类的构造方法是()，可以在堆栈信息中看到。


        对象的初始化是先初始化成员变量，再执行构造方法。
            因此打印2  ->  设置a为110 -> 执行构造方法 (打印3,此时a已经赋值为110，但是b只是设置了默认值0，并未完成赋值动作)。
            等对象的初始化完成后，继续执行之前的类构造器的语句。接下来就不详细说了，按照语句在源码中的顺序执行即可。

            static Test st = new Test(); 内嵌的这个变量恰好是个静态成员，而且是本类的实例。
            这会导致一个有趣的现象：“实例初始化竟然出现在静态初始化之前”。

 */