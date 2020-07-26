package java8Feature.lambda;

import model.Student;
import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 *
 * Lambda 表达式在 Java 中又称为闭包或匿名函数
 *
 * lambda 内部可以使用静态、非静态和局部变量，这称为 lambda 内的变量捕获。
 *      lambda 表达式有个限制，那就是只能引用 final 或 final 局部变量，
 *      这就是说不能在 lambda 内部修改定义在域外的变量。
 *
 *      TODO
 *      只是访问它而不作修改是可以的.
 *
 */
public class FunctionDemo {


    static void absoluteValue(int valueToBeOperated, Function<Integer, Integer> function) {
        int newValue = function.apply(valueToBeOperated);
        System.out.println(newValue);
    }

    public static void main(String[] args) {
        int incr = 20;
        int myNumber = 10;


        absoluteValue(myNumber, val -> val + incr);

        myNumber = 15;
        absoluteValue(myNumber, val -> val * 10);
        absoluteValue(myNumber, val -> val - 100);
        absoluteValue(myNumber, val -> "somestring".length() + val - 100);
    }

    /**
     *  java.util.function 包下面很多函数式接口
     *
     */
    @Test
    public void Consumer() {
        Consumer<Student> consumer =
                p -> System.out.println(p.getName() + "是个好孩子");

        Student a = new Student("小a");
        consumer.accept(a);

    }

    @Test
    public void Predicate() {
        Predicate<Student> predicate =
                p -> {
                    System.out.println("是个女孩子");
                    return p.isGender();
                };

        Student b = new Student(true, 28, "小b", 99d);

        System.out.println(predicate.test(b));
    }
}
