package common;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * java 交换值的四种方法：
 */
public class Swap {
    //一般写法: 借助中间变量
    public static <T>void Swap(T[] arr,int i,int j){
        T temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    //中阶写法: 两个数求和然后相减的方式（缺点:如果 x 和 y 的数值过大的话，超出 int 的值会损失精度。）
    public static void Swap2(){
        int x = 10, y = 20;
        x = x + y; //x = 30
        y = x - y; //y = 10
        x = x - y; //x = 20
    }

    /**
     * 高阶写法: 利用位运算的方式进行数据的交换,
    //   原理是：一个数异或同一个数两次，结果还是那个数，而且不会超出int范围*/
    public static void Swap3(){
        int x = 10, y = 20; //定义两个变量
        x = x ^ y;  //x = 30    隐藏了原x，但并没有丢失
        y = x ^ y;  //y = 10  = (x^y)^y = x
        x = x ^ y;  //x = 20  = x^(y^x) = y
    }

    @Test
    //通用最简写法: 利用运算符的优先级
    public void Swap4(){
        int a = 10, b = 20; //定义两个变量
        b = a + 0 * (a = b);
        System.out.println("x:" + a + ", y:" + b);
    }

    //反人类写法
    public void Swap5(){
        Integer x = 10, y = 20; //定义两个变量
        System.out.println("交换前 x=" + x + ",y=" + y);

        int temp = x;
        try {
            Class clazz = x.getClass();
            Field value = clazz.getDeclaredField("value");
            value.setAccessible(true);

            value.setInt(x, y);
            value.setInt(y, temp);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("交换前 x=" + x + ",y=" + y);

    }
}
