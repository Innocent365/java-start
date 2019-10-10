package decoratePattern.redefineIO;

import org.junit.Test;

public class Utf8questions {
    public static void main(String[] args) {
        for (int i = 0; i < 0x9FA5; i++) {
            System.out.print((char) i);
            if (i > Math.pow(2, 16))
                System.out.println();
        }


    }

    @Test
    public void Test() {

        System.out.println(Math.pow(2, 16));
        System.out.println(0x9fA5);

        System.out.println("师德师风sds".toUpperCase());
    }


    @Test
    public void test() {
        byte x = '\'';
        short sh = '打';
//        System.out.println(sh);
//        char s = '打';
//        System.out.println(s);
//        int i = '打';
//        System.out.println(i);
//
        char y = 2 ^ 16 - 4;
//        System.out.println(y);
        sh = '\u000E';
//        sh = 2^16-4;
//        System.out.println(Math.pow(2,16)-4);
        y = (char) (Math.pow(2, 16) - 4);
//        sh = '￼';

//        System.out.println(y);
//        sh = 2^16+1;

        System.out.println(2 ^ 3);
    }

    @Test
    public void test2() {
        //char 与 int之间的互相转换，如果遇到负数，则从

        //char 是无符号，将int的第一位（符号位）直接翻译为数据的最高位 即 2的16次方
        for (int i = -1000; i < 20000; i++) {
            System.out.println((int) ((char) i));
        }
    }
}
