package base.datatype;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;

/**
 * @author hw
 * @version on 2020/3/23
 */
@SuppressWarnings("ALL")
public class CharDemo {
    /**
     * char:字符型，2个字节，16位：
     *      最小值是’\u0000’（即为0）；
     *      最大值是’\uffff’（即为65,535， 2的16次方）
     *
     * Unicode编码格式。
     *     1)char为表现形式，实质上int(字符对应的编码)
     *     2)字符需放在一对单引号中
     *     3)必须有并且只有1个字符
     * 中文的范围：\u4e00--- \u9fa5	编码从4e00到9fa5
     */
    public static void main(String[] args) {

        //0-9
        for (int i = 48; i < 58; i++) {
            //System.out.println(i +":" +(char)i);
        }

        //A-Z
        for (int i = 65; i < 91; i++) {
            System.out.println(i +":" +(char)i);
        }

        //中文
        for(char c='\u4e00';c<='\u9fa5';c++){
            System.out.print(c);
        }
        //或
        for (int i = 0x4e00; i <= 0x9fa5; i++) {
            //System.out.println(i +":" +(char)i);
        }

        int min = Character.MIN_VALUE;
        System.out.println(min);//0
        int max = Character.MAX_VALUE;
        System.out.println(max);//65535 = 2^16 = 16^4 --> 0xFFFF
    }

    @Test
    public void testChar() {
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

        char[] c = new char[2];
        System.out.println(Character.isLetter(c[0]));//false. 是否是字母，类似还有是否是数字
    }

    @Test
    public void convert(){
        char cha = 52;
        System.out.println((int)cha);

        char ch = '4';
        System.out.println(ch);

        int num = '4';
        System.out.println(num);

        num = Character.getNumericValue(cha);
        System.out.println(num);

        num = Character.getNumericValue(num);
        System.out.println(num);
    }

    @Test
    public void testChinese() {
        /*
         * 思路:
         * 从4e00开始循环，一直循环到9fa5的位置
         * 将每个字符拼接在一起即可。
         */
        StringBuilder builder = new StringBuilder();

        System.out.println(MessageFormat.format("共{0}个汉字;" ,builder.length()));
        System.out.println(builder.toString());
    }

    //TODO
    //https://www.zhihu.com/question/27562173
    @Test
    public void testLength() throws UnsupportedEncodingException {
        System.out.println("字".length());//1个字符
        System.out.println("字".getBytes().length);//3个字节（默认UTF-8编码）
        System.out.println("字".getBytes("UTF-8").length);//默认UTF-8编码

        System.out.println("字".getBytes("GBK").length);//2个字节（指定GBK编码）

        //Java 中的 char 本质上是 UTF-16 编码
        System.out.println("字".getBytes("UTF-16").length);//4个字节
        System.out.println("字".getBytes("UTF-32").length);

        //如果一个抽象的字符在 UTF-16 编码下占 4 字节，显然它是不能放到 char 中的。换言之， char 中只能放 UTF-16 编码下只占 2 字节的那些字符。

        /**
         * 脱离了具体的编码谈字符占几个字节是没有意义的
         *
         * 同一个字符在不同的编码下可能占不同的字节。
         *
         *
         * 不同的字符在同一个编码下也可能占不同的字节。（因为 UTF-8 是变长编码）
         *
         */
    }
}
