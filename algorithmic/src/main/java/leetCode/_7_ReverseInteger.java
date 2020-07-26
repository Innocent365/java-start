package leetCode;

import java.util.Arrays;

/**
 * @author hw
 * @version on 2020/3/9
 */
public class _7_ReverseInteger {

    public int reverse(int x) {
        int z = x>0?x:-x;
        char [] chars = String.valueOf(z).toCharArray();
        char [] chars1 = new char[chars.length];

        for (int i = 0; i < chars.length; i++) {
            chars1[chars.length -1 - i] = chars[i];
        }

        String s = String.valueOf(chars1);

        int y = 0;
        try{
            y = Integer.valueOf(s);
        }catch (NumberFormatException e){
            //ignore
        }

        return x>0?y:-y;
    }


    public int reverse2(int x) {
        int z = x>0?x:-x;
        char[] chars = (String.valueOf(z)).toCharArray();

        long r = 0;
        for (int i = 0; i < chars.length; i++) {
            //System.out.println(chars[i]);
            r += (chars[i] - '0') * Math.pow(10,i);
        }

        r = x>0?r:-r;
        if(r > Integer.MAX_VALUE || r < Integer.MIN_VALUE){
            return 0;
        }
        return (int)r;
    }

    public static void main(String[] args) {
        int a = 123;
        int b= 120;
        int c= -123;
        int d= -120;
        int e = 1534236462;
        System.out.println(new _7_ReverseInteger().reverse2(a));
        System.out.println(new _7_ReverseInteger().reverse2(b));
        System.out.println(new _7_ReverseInteger().reverse2(c));
        System.out.println(new _7_ReverseInteger().reverse2(d));
        System.out.println(new _7_ReverseInteger().reverse2(e));
    }
}
