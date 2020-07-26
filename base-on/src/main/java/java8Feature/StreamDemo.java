package java8Feature;


import model.Student;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

/**
 * stream操作被分成了中间操作与最终操作这两种。
 *
 *     中间操作返回一个新的stream对象。中间操作总是采用惰性求值方式，运行一个像filter这样的中间操作实际上没有进行任何过滤，
 *          相反它在遍历元素时会产生了一个新的stream对象，这个新的stream对象包含原始stream中符合给定谓词的所有元素。
 *
 *     最终操作(像forEach、sum这样的)可能直接遍历stream，产生一个结果或副作用。当最终操作执行结束之后，stream管道被认为已经被消耗了，没有可能再被使用了。
 *          在大多数情况下，最终操作都是采用及早求值方式，及早完成底层数据源的遍历。
 *
 */
public class StreamDemo {

    public static List<Student> class1 = new ArrayList<>();
    static {
        class1.add(new model.Student(true, 15, "赵元任", 89d));
        class1.add(new model.Student(false, 14, "钱钟书", 88d));
        class1.add(new model.Student(true, 15, "孙中山", 71d));
        class1.add(new model.Student(true, 15, "李大钊", 65d));
    }


    public static void main(String[] args) {

        Double total;// = class1.stream().mapToDouble(p->p.getScore()).sum();

        /** DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper); */
        ToDoubleFunction<Student> function = (p)-> p.getScore();
        DoubleStream stream = class1.stream().mapToDouble(function);
        total = stream.sum();

        System.out.println("一班总分数:" + total);

        List<model.Student> class1_boy;// =  class1.stream().filter(p->p.isGender()).collect(Collectors.toList());


        /** Stream<T> filter(Predicate<? super T> predicate); */
        Predicate<model.Student> fun = p-> p.isGender();
        Stream<model.Student> studentStream = class1.stream().filter(fun);
        class1_boy = studentStream.collect(Collectors.toList());
        System.out.println(Arrays.toString(class1.toArray()));


        //void forEach(Consumer<? super T> action);
//        class1_boy.stream().forEach(student -> System.out.println(student));//参数student的类型是由编译器推测出来的。
          //你也可以通过把参数类型与参数包括在括号中的形式直接给出参数的类型：
//        class1_boy.stream().forEach((collection.model.Student student ) -> System.out.println(student));
        Consumer<model.Student> action = student -> System.out.println(student);
        class1_boy.stream().forEach(action);

        //将一个结果集转化为另一个结果集
        List<Integer> list =  class1.stream().map(p->p.getAge()).collect(Collectors.toList());
        list.forEach(p-> System.out.println(p));
        List<model.Student> list1 = class1.stream().filter(p->p.isGender()).collect(Collectors.toList());
        list1.forEach(p-> System.out.println(p));
        List<model.Student> list2 = class1.stream().map(p->{
            model.Student s = new Student();
            s.setAge(p.getAge());
            s.setScore(p.getScore());
            return s;
        }).collect(Collectors.toList());
        list2.forEach(p-> System.out.println(p));

        /** stream另一个有价值的地方是能够原生支持并行处理 :  parallel 平行的 */
        Double re = class1.stream().mapToDouble(p->p.getScore()).reduce(2, Double::sum);
        Double result =  class1.stream().parallel().mapToDouble(p->p.getScore()).reduce(2, Double::sum);//parallel()与上面的相比是并行执行的，即每一个结果加1
        System.out.println(re);
        System.out.println(result);

        /**Stream API不仅仅处理Java集合框架。像从文本文件中逐行读取数据这样典型的I/O操作也很适合用Stream API来处理 */
        final Path path = new File("mysql.propies").toPath();
        try( Stream< String > lines = Files.lines( path, StandardCharsets.UTF_8 ) ) {
            lines.onClose( () -> System.out.println("Done!") ).forEach( System.out::println );
            //对一个stream对象调用onClose方法会返回一个在原有功能基础上新增了关闭功能的stream对象，当对stream对象调用close()方法时，与关闭相关的处理器就会执行。
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}


