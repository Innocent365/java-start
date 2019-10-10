package base;


import org.junit.Test;

public class BaseDataType {

    /**
     * 八大基本类型， void 九大预定义
     * short, int, double, float, long
     * boolean, byte, char
     */

    public static void main(String[] args) {
        System.out.println(int.class.isPrimitive());        //true,是基本类型
        System.out.println(String.class.isPrimitive());     //false, 注意String不是基本类型
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
        System.out.println(c); //-2147483648(int的最小值)，溢出
    }

    @Test
    public void testLong(){
        //2.long:长整型，8个字节，很大很大
        long a = 25L; //25L为long型的直接量
        //long b = 10000000000; //100亿默认为int，但超范围了
        //100亿这个数写出来就是错的
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
        System.out.println(c-d); //1.099999..6，舍入误差，
        //精确运算场合不使用
    }

    @Test
    public void testBoolean() {
        //4.boolean:布尔型，1个字节，只能存true和false
        boolean b1 = true;
        boolean b2 = false; //true和false称为直接量/字面量
        //boolean b3 = 1; //编译错误，类型不匹配
    }

    @Test
    public void testChar() {
        //5.char:字符型，2个字节，Unicode编码格式

        //  1)char为表现形式，实质上int(字符对应的编码)
        //  2)字符需放在一对单引号中
        //  3)必须有并且只有1个字符

        char c1 = '你';
        char c2 = 'm';
        char c3 = '2';
        char c4 = ' ';
        char c5 = '*';
        //char c6 = 我; //编译错误，必须放在单引号中
        //char c7 = '你好';//编译错误，只能有一个字符
        //char c8 = '';//编译错误，必须有一个
        char c9 = '\\';

        System.out.println(c9);

        //字符实质上就是一个int整数
        System.out.println(2+2); //4
        System.out.println('2'+'2');  //100,'2'对应的码50加上'2'对应的码50
        System.out.println('2'+2); //52
    }

    @Test
    public void testConvert() {
        //数据类型转换

        int a = 250;
        long b = a;   //自动类型转换
        long c = 250; //自动类型转换
        //int d = c; //编译错误，大到小必须强制类型转
        int d = (int)c;//强制类型转换，将c强转为int型并赋值给d

        long e = 10000000000L;
        int f = (int)e;
        System.out.println(f); //溢出，强转有可能发生

        double g = 25.9864789;
        int h = (int)g;
        System.out.println(h); //精度的丢失，强转有可能发生

        int i = 5/2;
        System.out.println(i); //2
        double j = 5/2;
        System.out.println(j); //2.0,5/2的结果为2，赋值给double为2.0

        double k = 5.0/2;
        System.out.println(k); //2.5

        byte b1 = 5;
        byte b2 = 6;
        byte b3 = (byte)(b1+b2);
        System.out.println(b3);
    }


    





    

}
