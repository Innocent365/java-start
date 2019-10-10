package _1.base;

import org.junit.Test;

/**
 * Created by ss on 2017/2/10.
 * 测试是否可以达成类似ref的效果
 */
public class FuncParameterReferDemo {
    public static void main(String[] args){
        int a = 10;
        int b = 10;
        method(a,b);

        System.out.println("a=" + a);
        System.out.println("b=" + b);
    }

    private static void method(int a, int b) {
        a = 100;
        b = 200;
    }

    @Test
    public void testString() {
        //System.out.println("你好".length());
        System.out.println("   <dds得瑟得瑟&*》？？》23￥￥><@^#% \\\\n  \\\\t ".trim());
    }



}
