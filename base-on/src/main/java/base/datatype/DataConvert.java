package base.datatype;

import org.junit.Test;

/**
 * @author hw
 * @version on 2020/4/3
 */
public class DataConvert {

    /**
     * 基本类型转换：
     *     小到大自动转换
     *     大到小必须强制转换（可能发生溢出、精度丢失等）
     *
     * 通常基本类型只转换为其对应的基本类型值。
     *
     *
     */
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
        //byte b4 = 129;//编译报错

        char ch1 = 'A'; //63
        char ch2 = 63;
        byte b4 = (byte) (ch1 + ch2);
        System.out.println(b4);//-128，强转超出最大值

    }

    /**
     * 基本类型与包装类型之间的转换：
     *   ->     new Integer(val);   调用构造方法创建 或 使用静态方法Integer.valueOf(推荐)
     *   <-     i.intValue();
     *  Integer的构造方法内部提供一个
     *
     * 自动拆装装箱：
     *  编译器协助完成基本类型与包装类型之间的转换：
     *  Integer a = 13; //编译器调用valueOf方法进行转换
     *  int i = a;      //a.intValue(); 类似的有提供 a.doubleValue();
     *
     *
     * 字符串转换为基本类型：
     *   包装类都支持一个静态方法
     *   parseXXX(String str)
     *
     *   前提是该字符串可以正确描述该基本类型的值。
     * @param args
     */
    public static void main(String[] args) {
        //将基本类型转换为引用类型
        Integer i = new Integer(1);

        int d = i.intValue();
        System.out.println(d);

        double dou = i.doubleValue();
        System.out.println(dou);

        Double dd = new Double(128.123);
        /*
         * 可以看到，由于长度不一致，导致结果
         * 可能出现问题。
         */
        byte b = dd.byteValue();
        System.out.println(b);//-128  超出后显示最小。-2^7 ~ 2^7 - 1
    }

    @Test
    public void testParse() {
        String str1 = "123";
        int i = Integer.parseInt(str1);
        System.out.println(i);

        String str2 = "123.123";
        double d = Double.parseDouble(str2);
        d++;
        System.out.println(d);
    }

    @Test
    public void testValueOf() {

        //Integer的valueOf会缓存IntegerCache一字节以内的数字(-128---127) 某种程度上会减少内存开销。
        Integer i1 = 12;
        Integer i2 = Integer.valueOf(12);
        Integer i3 = new Integer(12);// new是一定会创建新对象的
        System.out.println(i1==i2);     //true
        System.out.println(i1==i3);     //false
        System.out.println(i2.equals(i2));//true

        Integer i4 = 129;
        Integer i5 = 129;
        System.out.println(i4==i5);     //false
        System.out.println(i4.equals(i5));//true

        Integer i6 = null;
        int i = i6;//java.lang.NullPointerException
        System.out.println(i);

        //Double的valueOf与new没有区别
        Double d1 = Double.valueOf(1.0);
        Double d2 = Double.valueOf(1.0);

        System.out.println(d1==d2); //false
        System.out.println(d1.equals(d2));//true
    }

    @Test
    public void testAutoPackage() {
        int a = 3;
        Integer b = 3;
        Integer c = Integer.valueOf(3);
        Integer d = Integer.parseInt("3");
        Integer e = new Integer(3);


        System.out.println(a==b);   //true
        System.out.println(b==c);   //true
        System.out.println(c==d);   //true

        System.out.println(a==e);   //true
        System.out.println(b==e);   //false
    }
}
