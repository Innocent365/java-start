package java8Feature.optionalNull;


import model.Person;

import java.util.Optional;

/**
 * Optional 可选择的，随意的: Guava通过使用检查空值的方式来防止代码污染，它鼓励程序员写更干净的代码
 *
 *
 */
public class OptionalDemo {
    public static void main(String[] args) {

        Optional<String> fullName = Optional.ofNullable(null);
        System.out.println("Full Name is set? " + fullName.isPresent());
        System.out.println("Full Name: ? " + fullName.orElseGet(()->"[None]"));

        //如果fullName 为空， 则打印 hey  陌生人
        System.out.println(fullName.map( s -> "Hey " + s +"!").orElse("Hey Strangger!"));


        Person p = null;
        Optional<Person> personOptional = Optional.ofNullable(p);
        System.out.println(personOptional.isPresent()); //是否为null
        System.out.println(personOptional.orElse(new Person(12, "Jack")));//使用时如果为null用指定的值替代
        System.out.println(fullName.orElseGet(()->"[None]")); //orElseGet方法和orElse()()方法类似，但是orElse接受一个回调函数而不是一个默认值。
    }
}
