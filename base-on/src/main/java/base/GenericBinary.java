package base;

import org.junit.Test;

/**
 * 其他进制表示数
 * @author hw
 * @version on 2020/4/28
 */
public class GenericBinary {

    /**
     * 原码、反码、补码的产生、应用以及优缺点有哪些？ - 祥先生的回答 - 知乎
     * https://www.zhihu.com/question/20159860/answer/713291288
     *
     * 原码：
     *  最直观的从10进制到二进制的编码格式:
     *      人脑最容易理解和计算的表示方式, 规定原码的最高位为符号位，正数为0，负数为1，其余所有位为10进制数的绝对值。
     *          8位二进制数的取值范围就是:  [1111 1111 , 0111 1111] 即 [-127 , 127]
     *
     *  缺点: 无法将减法转换成加法运算
     *  原码虽然很直观转换了10进制数，但是计算输出的原码值并不正确，所以计算机不能直接使用原码存储和计算。
     *
     * 反码：
     *  人为规定反码最高位为符号位，正数为0，负数为1，
     *      反码正数与原码正数格式一致，
     *      反码负数为负数绝对值的原码按位分别取反。
     *    早期的计算机如CDC 6000、LINC、PDP-1等都是使用反码的，
     *    但是反码也有两个缺点：
     *      1）0有两种编码，+0 （0000）和 -0 （1111），在判断0时，需要分别判断0000（2-2）和1111（1111+0001）；
     *      2）反码减法的算法规则比较复杂，需要增加计算机内部逻辑组件额外判断溢位，会影响计算效率。
     *
     * 补码：现代计算机使用的编码格式，解决了上面反码的两个缺点（发生了溢位直接丢弃）。
     *      正数的补码与原码格式相同，
     *      负数的补码是将负数绝对值的原码分别按位取反，并加1
     *
     *  模（Modulo）：
     *      模是指一个计量系统的计数范围。如时钟等。计算机也是一个计算器，它也是有一个计量范围，即都存在一个“模”。
     *      “模”是计量器产生“溢出”的量，它的值在计量器上表示不出来，计量器上只能表示出模的余数，如12的余数有0,1,2,3,4,5,6,7,8,9,10,11。
     *
     */
    public static void main(String[] args) {
        //Java7之前是不支持前置直接表示二进制数的
        //二进制：前置0b/0B
        int a = 0B1011;System.out.println(a == 11);//8 + 2 + 1 = 11
        //八进制：前置0
        int b = 0105011;System.out.println(b);//1*8^5 + 5*8^3 + 1*8 + 1 = 35337
        //十进制：默认的，无需前置
        //十六禁止：前置0x/0X
        int c= 0xa83;System.out.println(c);//10*16^2 + 8*16 + 3 = 2691

        //负数
        int d = -0B101111;System.out.println(d);//-11
        int e = -0171;System.out.println(e);//-(8^2+7*8+1)=-121
        int f = -0x1c;System.out.println(f);//-(16+12)=-28

        //可以加下划线分割，方便看，无意义
        int g = 0B1011_11_1;
        g = 0x12_2c;
        g = 122_122122;
    }

    @Test
    public void Convert(){
        //1，十进制转化为其他进制字符串：
        String binary = Integer.toBinaryString(100);System.out.println(binary);//1100 100
        String octal = Integer.toOctalString(100);System.out.println(octal);//144
        String hexadecimal = Integer.toHexString(100);System.out.println(hexadecimal);//64
        System.out.println("---------------");

        //2, 其他进制字符串转化为十进制整数：
        int i = Integer.valueOf("0101",2);System.out.println(i);//5
        int j = Integer.valueOf("376",8);System.out.println(j);//254
        int k = Integer.valueOf("ffff",16);System.out.println(k);//65535
        System.out.println("---------------");


        /**
         * 3.负数转换为二进制字符串
         * 在计算机中负数采用二进制的补码表示:
         *      补码：反码加1得到补码
         */
        System.out.println(Integer.toBinaryString(-1));
        //并非1000 0000 ... 0001 !!! 而是1111 1111 1111 1111 1111 1111 1111 1111
        //先得到源码 0000 ... 0001 按位取反得到反码 1111 ... 1110 反码加1得到补码 1111 1111 ... 1111

        System.out.println(Integer.toBinaryString(-100));
        //0000 ... 0110 0100 -> 1111 ... 1001 1011 -> 1111 ... 1001 1100

        System.out.println(Integer.toBinaryString(-1000));
        //0000 ... 0011 1110 1000 -> 1111 ... 1100 0001 0111 -> 1111 ... 1100 0001 1000


        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));//2147483647
        //1111111111111111111111111111111  31位,最前面0省略
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));//-2147483648
        //10000000000000000000000000000000  32位，注意负数用反码表示
        System.out.println("-------------------");

        //4.二进制字符串转换为十进制整数(-1求反码)
        i = Integer.valueOf("+1111111111111111111111111111110",2);//31个1，最高位0省略
        i = Integer.valueOf("+1111111111111111111111111111111",2);//31个1，最高位0省略
        System.out.println(i);//2147483647，即Integer.MAX_VALUE


        System.out.println(i+1);//-2147483648    Integer.MIN_VALUE
        i = Integer.valueOf("-10000000000000000000000000000000",2);//1个1 + 31个0 = 32位

        System.out.println(i+1);//-2147483647   Integer.MIN_VALUE + 1
        i = Integer.valueOf("-1111111111111111111111111111111",2);//1个1 + 31个0 = 32位

        System.out.println(i+1);//-2147483646   Integer.MIN_VALUE + 2
        i = Integer.valueOf("-1111111111111111111111111111110",2);//1个1 + 31个0 = 32位

        System.out.println(i+1);//-2147483645   Integer.MIN_VALUE + 3
        i = Integer.valueOf("-1111111111111111111111111111101",2);//1个1 + 31个0 = 32位

        System.out.println(i+1);//-2147483644   Integer.MIN_VALUE + 4
        i = Integer.valueOf("-1111111111111111111111111111101",2);//1个1 + 31个0 = 32位
        System.out.println("-------------------");

        /**
         * 为什么在计算机中，负数用补码表示
         *  只用定义加法运算，省去了减法器 ：在有模的计量系统中，减一个数等于加上它的补数
         */

        i = Integer.MAX_VALUE - 1;
        int m = 6;
        while (m-->0){
            System.out.println(i + ": " +Integer.toBinaryString(i++));
        }
    }


    @Test//二进制字符串
    public void testShowBinaryString(){

        byte byteValue = -1;
        System.out.println(Integer.toBinaryString(byteValue));//方法参数只能是int类型，此时被强转，
        // 结果和上面一样11111111111111111111111111111111
        //byte类型没有toBinaryString方法，需要依赖Integer, 否则会向上转型为int类型再处理的
        System.out.println(Integer.toBinaryString(byteValue & 0xff));//11111111（只显示八位）,即255
        System.out.println("----------------");

        byteValue = -2;
        System.out.println(Integer.toBinaryString(byteValue));
        System.out.println(Integer.toBinaryString(byteValue & 0xff));
        System.out.println(byteValue & 0xff);
    }




}
/**
 *  https://cloud.tencent.com/developer/article/1497574
 *十进制小数的二进制表示：
 *    整数部分：除以2，取出余数，商继续除以2，直到得到0为止，将取出的余数逆序
 *    小数部分：乘以2，然后取出整数部分，将剩下的小数部分继续乘以2，然后再取整数部分，一直取到小数部分为零为止。
 *       **如果永远不为零，则按要求保留足够位数的小数，最后一位做0舍1入。将取出的整数顺序排列。（因此肯定就可能失精度了）
 *
 *  一般字符集编码的范围 utf-8>gbk>iso-8859-1(latin1)>ascll。
 *      ascll编码是美国标准信息交换码的英文缩写，包含了常用的字符，如阿拉伯数字，英文字母和一些打印符号，请注意字符和数字的区别，比如’0’字符对应的十进制数字是48。
 *      unicode编码包含很多种格式，utf-8是其中最常用的一种，utf-8名称的来自于该编码使用8位一个字节表示一个字符。对于一个汉字而言，它需要3个字节表示一个汉字，
 *          但大中华地区人民表示不服，搞一套gbk编码格式，用两个字节表示一个汉字。
 *

 *
 *
 */
