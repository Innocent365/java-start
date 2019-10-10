package javaSE.stringAndRegex;


import org.junit.Test;

/**
 * 8个包装类中有六个是数字类型的，他们都继承自Number
 * Number是一个抽象类，定义了可以在数字类型间互相转换的方法。
 * 这意味着任何包装类都可以将其表示的数字转换为 6个基本类型的值。但由于长度，精度不同，在转换时有可能丢失长度或精度。
 *
 * 数字类型包装类有两个常量:
 * MAX_VALUE:对应的基本类型数据取值中的最大值
 * MIN_VALUE:最小值
 *
 * 通常基本类型只转换为其对应的基本类型值。
 *
 * 包装类都支持一个静态方法
 * parseXXX(String str)
 *
 * 该方法可以将一个字符串转换为对应的基本类型数值
 * 前提是该字符串可以正确描述该基本类型的值。
 *
 * @author Administrator
 */
public class IntegerDemo2 {
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
        System.out.println(b);

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

    @Test//
    public void testParse(String[] args) {
        String str1 = "123";
        int i = Integer.parseInt(str1);
        System.out.println(i);

        String str2 = "123.123";
        double d = Double.parseDouble(str2);
        d++;
        System.out.println(d);
    }

     /** 基本类型转换为包装类有两种方式:
            * 1:调用构造方法创建
            * 2:使用静态方法valueOf(推荐)*/
    @Test
    public void testValueOf() {

        //Integer的valueOf会缓存一字节以内的数字(-128---127) 某种程度上会减少内存开销。     new是一定会创建新对象的。
        Integer i1 = Integer.valueOf(1);
        Integer i2 = Integer.valueOf(1);
        System.out.println(i1==i2);     //true
        System.out.println(i1.equals(i2));//true

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






