package base.keyword;


/**
 * 有趣的现象：实例初始化竟然出现在静态初始化之前
 */
public class StaticDemo2
{
    public static void main(String[] args){
        staticFunction();
    }

    static StaticDemo2 st = new StaticDemo2();


    static{
        System.out.println("1");
    }

    static Point as = new Point();


    {
        System.out.println("2");
    }

    StaticDemo2(){
        System.out.println("3");
        System.out.println("a="+a+",b="+b);
    }

    public static void staticFunction(){
        System.out.println("4");
    }

    int a=110;
    static int b =112;
}
class Point{
    public Point() {
        System.out.println("PointConstruct");
    }
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