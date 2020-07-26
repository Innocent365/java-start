package base.stringAndRegex;

import org.junit.Test;

import java.text.MessageFormat;
import java.util.Date;

/**
 * @author hw
 * @version on 2019/5/27
 */
public class StringApiDemo {
    /**
     * 	1.java.lang.String 使用了final修饰,不能被继承;
     * 	2.对象创建后,内容是不可改变的,一旦改变会创建新对象
     * 	3.String在内存中采用Unicode编码
     *  * 	int length() 字符串的该方法用来获取字符串中的字符个数,不管中文还是英文
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("中文".length());
        System.out.println("English".length());
    }

    @Test
    public void testFormat() {

        //  String 类使用静态方法 format() 返回一个String 对象
        //       而不是 PrintStream 对象(用于一次打印输出)
        System.out.println(String.format("Hi, %s", "Jack"));

        System.out.println(String.format("Year is %tY", new Date()));
        System.out.println(String.format("Month is %tm", new Date()));
        System.out.println(String.format("Day is %td", new Date()));

        //since java8
        System.out.println(MessageFormat.format("Hello, {0}", "Tom"));
    }

    @Test
    public void testCompare(){
        //默认的compareTo方法 按字典顺序比较两个字符串
        String s1 = "ax12";
        String s2 = "ay";
        System.out.println(s1.compareTo(s2));//-1
        //y(90)大于x(89)返回-1
    }
}
