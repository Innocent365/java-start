package base.referAndValueType;

import model.Person;

import java.util.List;

/**
 * @author hw
 * @version on 2020/6/20
 */
public class CloneDemo{

    /**
     * 拷贝对象:
     *    基本类型的变量，存放的是值，所以拷贝没有什么异议，存放的也是值
     *    引用类型的变量，分浅拷贝与深拷贝
     *          浅拷贝：内存中的引用（指向）赋值给新的对象
     *          深拷贝：将原引用指向的对象创建一个新的，内容一模一样的对象，引用赋值给该变量
     *
     *
     */

    //clone 方法执行的是浅拷贝
    public static void main(String[] args) {
        Person aa = new Person(17, "张三");
        //aa.setAge(12);    protected 修饰的变量不能跨包访问
        Person bb = (Person) aa.clone();


        System.out.println(aa==bb);
        System.out.println(aa.getName() == bb.getName());
    }

    //TODO 深度克隆的另一个方法： 对象序列化
}

