package base.datatype;


import org.junit.Test;


@SuppressWarnings({"ALL", "Alibaba"})
public class BaseDataType {

    /**
     * 八大基本类型， void 九大预定义
     * 分三大类：布尔类型(boolean)、字符类型(char)、
     *
     * 数字类型：都继承自Number（抽象类，定义了可以在数字类型间互相转换的方法）
     *          数字类型包装类有两个常量:
     *          MAX_VALUE:对应的基本类型数据取值中的最大值
     *          MIN_VALUE:最小值
     *      整数类型：
     *      byte：1个字节,8位（比特）（计算机位），-128~127 （-2^7 ~2^7-1）
     *      short：2个字节，16位： -32768~32767 （-2^15~2^15-1）
     *      int：4个字节，32位： -2^31 ~ 2^31-1（-2147483648~2147483647）
     *      long：8个字节，64位：-2^63 ~ 2^63-1
     *
     *      浮点类型:
     *      double：8个字节，64位，双精度类型
     *      float：4个字节，32位，单精度型
     *      注：Float和Double的最小值和最大值都是以科学记数法的形式输出的，结尾的"E+数字"表示E之前的数字要乘以10的多少倍
     *
     *
     *
     * Java基本类型存储在栈中，因此它们的存取速度要快于存储在堆中的对应包装类的实例对象
     * byte,short,int,long,char------默认初始值0
     *
     * char ch = 0;--------默认值
     * char ch = '0';--48
     */

    public static void main(String[] args) {
        System.out.println(int.class.isPrimitive());        //true,是基本类型
        System.out.println(String.class.isPrimitive());     //false, 注意String不是基本类型
    }


    @Test
    public void testBoolean() {
        //4.boolean:布尔型，只能存true和false
        boolean b1 = true;
        boolean b2 = false; //true和false称为直接量/字面量
        //boolean b3 = 1; //编译错误，类型不匹配

        //到底占几个字节？
        /**
         1、1个bit（1/8个字节）：
            boolean类型的值只有true和false两种逻辑值，在编译后会使用1和0来表示，
            这两个数在内存中按位算，仅需1位（bit）即可存储，位是计算机最小的存储单位
         2、1个字节虽然编译后1和0只需占用1位空间，但计算机处理数据的最小单位是1个字节，1个字节等于8位，
            实际存储的空间是：用1个字节的最低位存储，其他7位用0填补，
            如果值是true的话则存储的二进制为：0000 0001，
            如果是false的话则存储的二进制为：0000 0000
         3、4个字节：
            在Java虚拟机中没有任何供boolean值专用的字节码指令，Java语言表达式所操作的boolean值，
            在编译之后都使用Java虚拟机中的int数据类型来代替，而boolean数组将会被编码成Java虚拟机的byte数组，
            每个boolean元素占8位。
            使用int的原因是，对于当下32位的处理器（CPU）来说，一次处理数据是32位（这里不是指的是32/64位系统，而是指CPU硬件层面）
         4、It depends on Java virtual machine
            取决于java虚拟机
         */
    }

    @Test
    public void testShort(){
        short a = 128;
        short b = 129;
        System.out.println(Short.MAX_VALUE);
        System.out.println(Short.MIN_VALUE);
    }

    @Test
    public void testInt() {
        //1.int:整型，4个字节，-21个多亿到21个多亿
        int a = 250; //声明整型变量a并赋值为250
        //250叫直接量/字面量，默认int型
        //int b = 10000000000; //编译错误，100亿默认为int型，
        //并且还超了int的范围
        System.out.println(5/3); //1，小数位无条件舍弃
        System.out.println(3/5); //0

        int c = 2147483647; //int的最大值
        c = c + 1; //在c本身之上增1
        System.out.println(c); //-2147483648(int的最小值)，溢出（舍掉超出的位，最后边的0），不报错


        System.out.println(-c);//依旧是-2147483648不变
        // Integer.MAX_VALUE=2147483647, 2147483648超出范围、
        System.out.println(-(long)c);//2147483648, 注意 long 的位置
    }

    @Test
    public void testLong(){
        //2.long:长整型，8个字节，很大很大
        long a = 25L; //25L为long型的直接量
        //long b = 10000000000; //100亿默认为int，但超范围了。100亿这个数写出来编译器就让认为是错的
        long c = 10000000000L; //正确

        //当较大数运算时，建议将L放在第一个位置
        long d = 1000000000 * 2 * 10L;
        System.out.println(d); //200亿
        long e = 1000000000 * 3 * 10L;
        System.out.println(e); //溢出
        long f = 1000000000L * 3 * 10;
        System.out.println(f); //300亿

        //获取自1970年1月1日零时到此时此刻的毫秒数
        long time = System.currentTimeMillis();
        System.out.println(time);
    }

    @Test
    public void testDouble() {
        //3.double:浮点型，8个字节
        double a = 250.5; //声明double型变量a并赋值为250.5
        //250.5为浮点型直接量，默认double型
        float b = 250.5F; //float直接量加f或F

        double c = 6.0;
        double d = 4.9;
        System.out.println(c-d); //1.099999..6，舍入误差
        //精确运算场合不使用
    }

    @Test
    public void testMax() {
        //获取int最大值
        int iMax = Integer.MAX_VALUE;
        System.out.println("int最大值:" + iMax);
        //获取int最小值
        int iMin = Integer.MIN_VALUE;
        System.out.println("int最小值:" + iMin);

        //获取double最大值
        double dMax = Double.MAX_VALUE;
        double dMin = Double.MIN_VALUE;
        System.out.println("double最大值:" + iMax);
        System.out.println("double最小值:" + iMax);

    }
}
