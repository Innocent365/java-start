package other;


import model.Person;

/**
 * 双括弧初始化的问题
 * @author hw
 * @version on 2019/4/22
 */
public class BraceInit {
    public static void main(String[] args) {
        //看编译的这段代码，就知道尽量避免使用{{}}进行初始化，和C#的不一样。泪
        System.out.println("1.----------------");
        Person per = new Person();
        per.setName("第三方的");
        per.setAge(22);
        Person arra[] = new Person[]{per};
        for (Person person : arra) {
            System.out.println(person.getName());//debug
        }

        System.out.println("2.----------------");
        Person arry[] = new Person[]{new Person(){{
            setAge(23);
            setName("祝福对方");
        }}};
        for (Person person : arry) {
            System.out.println(person.getName());//debug
        }
        System.out.println("debugger 观察 for 循环里person实例的类型，会发现第二个其实是内部类。但传给其他接口就会出现问题");

    }
}

/**
 *第一层括弧 实际是定义了一个内部匿名类 （Anonymous Inner Class），
 * 第二层括弧 实际上是一个实例初始化块 （instance initializer block），这个块在内部匿名类构造时被执行。
 *  这个块之所以被叫做“实例初始化块”是因为它们被定义在了一个类的实例范围内。
 *  这和“静态初始化块 （static initialzer）”不同，因为这种块在定义时在括弧前使用了static关键字，
 *  因此它的和类在同一个范围内的，也就是说当类加载时就会被执行
 *  （更详情，可参考Java语言规范http://java.sun.com/docs/books/jls/third_edition/html/classes.html#8.6 ）。
 *  实例初始化块中可以使用其容器范围内的所有方法及变量，但特别需要注意的是实例初始化块是在构造器之前运行的。
 *
 * 这种方法只适用于不是final的类，因为final类是无法建立内部匿名子类，好在集合类都没有这个限制。
 * 因此，这种方法还可以被用来初始化其它任何对象，比如一个GUI对象：
 *
 * 这样建立的内部匿名类的实例中包函它容器对像的引用。如果串行化（serialization）这个集合同时也会串行化它的内部类。
 */
