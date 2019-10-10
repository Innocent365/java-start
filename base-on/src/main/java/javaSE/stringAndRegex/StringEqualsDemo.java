package javaSE.stringAndRegex;


import org.junit.Test;

import java.text.MessageFormat;

/**
 * 1.由new关键字的对象都是运行时决定
 * 2.String是final修饰的，不可以继承，常用的 + 号生成新的字符串其实是语法糖，弄一个新的给你
 * 3.StringBuffer 是多线程安全的,由synchronized关键字修饰， StringBuilder是线程不安全的，但速度较快
 * 4.StringBuffer和 StringBuilder对象使用时 使用setLength()方法清空
 * 5.String在内存中采用Unicode编码
 * 	    int length() 字符串的该方法用来获取字符串中的字符个数,不管中文还是英文
 * 6.编译器在编译该程序时若发现，一个表达式两边的内容都是确定值时,会直接进行计算,并将结果生成到字节码文件.
 * 7.中文的范围：\u4e00--- \u9fa5	编码从4e00到9fa5
 *
 *
 */
public class StringEqualsDemo {
    public static void main(String[] args) {
        String st1 = "hello";
        String st2 = "he" + new String("llo");  //运行时才能确认
        System.err.println(st1 == st2);     //false      红色的false
        System.out.println(st1 == st2);     //false

        //String x += "ad";
        String y;
        //y+="ABC";

        String s1 = "hello";
        String s2 = "he" + "llo";
        System.out.println(s1==s2);//true
        String s3 = "he" + new String("llo");
        System.out.println(s1==s3); //false

        String val = new StringEqualsDemo().return1();
        String val2 = "1";
        System.out.println(val.equals(val2));
    }

    public String return1(){
        return "1";
    }

    @Test
    public void test() {
        String a = "a";
        String b = "b";
        String c = "ab";
        String d = a + b;
        String e = "ab";

        System.out.println(c==e);//true             编译器可以确定的字符直接从常量池中取
        System.out.println(a+"b"=="ab");//false
        System.out.println("a"+"b"=="ab");//true
        System.out.println("a"+"b"==c);//true

    }

    @Test
    public void TestSbInsert(){
        String x1 = "sd";
        StringBuilder sb = new StringBuilder(x1);
        //sb.insert()
    }

    @Test
    public void testConst() {
        String s1 = "123hello";
        String s2 = "123hello";

        String s3 = "123"+"hello";
        String s4 = 1+2+3+"hello";      //6hello
        String s5 = "1"+2+3+"hello";
        String s6 = 1+"23"+"hello";
        String a = "123";
        String b = "hello";
        String s7 = a + b;
        String s8 = '1'+2+3+"hello";

        System.out.println(s1==s2);//true
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
            System.out.println("注意data数组的length是：" + data[i]);
        }
    }

    @Test
    public void testChinese() {
        /*
         * 思路:
         * 从4e00开始循环，一直循环到9fa5的位置
         * 将每个字符拼接在一起即可。
         */
        StringBuilder builder = new StringBuilder();
        for(char c='\u4e00',i=1;c<='\u9fa5';c++,i++){
            builder.append(c);
            if(i%50==0){
                builder.append("\n");
            }
            if('黄' == (c)){
                System.out.println("黄：" + i + c);
            }
        }
        System.out.println(MessageFormat.format("共{0}个汉字;" ,builder.length()));
        System.out.println(builder.toString());
    }
}
