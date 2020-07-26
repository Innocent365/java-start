package java8Feature.lambda;

import java.util.function.Function;

/**
 *
 * 匿名内部类 直接写函数
 *
 * 两者不用：
 * 1. 关键字 this
     * (1) 匿名内部类中的 this 代表匿名类
     * (2) Lambda 表达式中的 this 代表 lambda 表达式的类
 *
 * 2. 编译方式不同
     * (1) 匿名内部类中会编译成一个.class 文件，文件命名方式为：主类+$+(1,2,3.......)
     * (2) Java 编译器将 lambda 表达式编译成类的私有方法。使用了 Java 7 的 invokedynamic 字节码指
     * 令来动态绑定这个方法
 *
 */
public class AnonymousDemo {

    public static void main(String[] args) {

        AnonymousDemo tester = new AnonymousDemo();

        MathOperation addition = (int a, int b) -> a + b;

        // 不用类型声明
        MathOperation subtraction = (a, b) -> a - b;

        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> { return a * b; };

        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

        // 不用括号
        GreetingService greetService1 = message ->
                System.out.println("Hello " + message);

        // 用括号
        GreetingService greetService2 = (message) ->
                System.out.println("Hello " + message);

        greetService1.sayMessage("Runoob");
        greetService2.sayMessage("Google");
    }

    public void test(){

        Function<String, String> function = p-> p+".shit";

    }




    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }
}
