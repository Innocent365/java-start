package base.stringAndRegex;


import org.junit.Test;

import java.text.MessageFormat;

/**
 * 1.由new关键字的对象都是运行时决定
 * 2.String是final修饰的，不可以继承，常用的 + 号生成新的字符串其实是语法糖，弄一个新的给你
 * 3.StringBuffer 是多线程安全的,由synchronized关键字修饰， StringBuilder是线程不安全的，但速度较快
 * 4.StringBuffer和 StringBuilder对象使用时 使用setLength()方法清空
 * 5.编译器在编译该程序时若发现，一个表达式两边的内容都是确定值时,会直接进行计算,并将结果生成到字节码文件.
 *
 * https://www.cnblogs.com/zhangyinhua/p/7689974.html
 *
 */
public class StringEqualsDemo {
    public static void main(String[] args) {
        String s1 = "hello";
        //直接赋值会先检查字符串常量池中是否含有HelloWorld字符串,如果HelloWorld字符串已经存在,那么就直接指向；
        // 如果没有，则将HelloWorld添加进常量池并且指向。


        String s2 = "he" + "llo";   //可以看到对于已经确定的字符串字面量，编辑器生成class时直接计算
        //此时发现常量池已经存在了"hello"变量，直接指向

        System.out.println(s1==s2); //true
        System.err.println(s1==s2); //true      红色的true

        String s3 = "he" + new String("llo");  //运行时才能确认
        System.out.println(s1==s3); //false

        String val = new StringEqualsDemo().return1();
        String val2 = "1";
        //System.out.println(val.equals(val2));//true
        System.out.println(val == val2);//true 已经放进常量池了，故相等。若方法return new String("1");则不等
    }

    public String return1(){
        return "1";
    }

    @Test
    public void test() {
        String a = "a";
        String b1 = "b";
        final String b2 = "b";
        String c = "ab";// 编译器可以确定的字符直接从常量池中取
        String e = "ab";

        System.out.println(c==e);//true
        System.out.println(a+"b"=="ab");//false 运算符+相当于new
        System.out.println("a"+"b"=="ab");//true
        System.out.println("a"+"b"==c);//true
        System.out.println("a"+ b1=="ab");//false
        System.out.println("a" +b2=="ab");//true 常量在编译时已替换

    }

    @Test
    public void testConst() {
        String s1 = "123hello";

        String s3 = "123"+"hello";
        String s4 = 1+2+3+"hello";      //6hello
        String s5 = "1"+2+3+"hello";
        String s6 = 1+"23"+"hello";
        String a = "123";
        String b = "hello";
        String s7 = a + b;
        String s8 = '1'+2+3+"hello";

        System.out.println(s1==s3);//true
        System.out.println(s1==s4);//false
        System.out.println(s1==s5);//true
        System.out.println(s1==s6);//true
        System.out.println(s1==s7);//false
        System.out.println(s1==s8);//false
    }
    
    @Test
    public void testSplit() {
        /*
         * 若拆分的内容在字符串末尾连续匹配，是不会拆出空字符串的。
         * 其他位置的话 中间都会拆出一个空字符串。
         */
        String str = "123,123,123,123,,,1,,,,,,,";
        String[] data = str.split(",");
        System.out.println("length:"+data.length);
        for(int i=0;i<data.length;i++){
            System.out.println(data[i]);
        }
    }

    @Test
    public void testIntern(){
        /**
         * String中intern方法详解
         * 当调用 intern 方法时，如果字符串常量池已经包含一个等于此 String 对象的字符串（用 equals方法确定），则返回池中的字符串。
         *  否则，将此 String 对象添加到池中，并返回此 String 对象的引用。
         */
        String s1 = "hello";
        String s2 = new String("hello");
        System.out.println(s1==s2);//false
        System.out.println(s1==s2.intern());//true

        String s3 = "abc";
        String s4 = "ab" + new String("c");
        System.out.println(s3==s4);//false
        System.out.println(s3==s4.intern());//true

        String s5 = new String("2");
        s5.intern();
        String s6 = "2";
        System.out.println(s5==s6);//false

        String s7 = new String("2") + new String("2");
        s7.intern();
        String s8 = "22";
        System.out.println(s7 == s8);
    }

    @Test
    public void testIntern2(){

        /**
         * jdk7起，intern()方法实现就不需要再拷贝字符串的实例到永久代了，字符串常量池已经移到了java堆中，
         *   只需要在常量池中记录以下首次出现的引用实例即可，因此intern返回的是和str2创建的是同一个
         *
         */
        String str = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str.intern() == str);//true

        /**
         * java这个字符串已经出现了，字符串常量池已经有他的引用，不符合首次遇到的原则
         */
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);//false
    }
}
/**
 * 字符串池的优缺点：
 *
 * 字符串池的优点就是避免了相同内容的字符串的创建，节省了内存，省去了创建相同字符串的时间，同时提升了性能；
 * 另一方面，字符串池的缺点就是牺牲了JVM在常量池中遍历对象所需要的时间，不过其时间成本相比而言比较低。
 */
