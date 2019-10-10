package base;

import javaSE.collection.Point;

/**
 * @author hw
 * @version on 2019/4/10
 */
public class FinalKeyWord {

    public final int a = 10;

    //成员变量
    public final int b; //必须赋初值,否则报错.除非像下面,在实例初始化的时候赋值.其实是一样的.
    {
        b = 12;
    }

    //静态变量
    public final static String  KEY = "key";
    public static final  int c; //static关键字修饰亦如此
    static {
        c = 111;
    }


    //局部变量
    class finalOnParam{
        public void testRefer(Point point){
            point = new Point(12, 12);  // //没有任何问题，但是肯定不符合此参数存在的初衷.传进来的参数无意义，这里也改变不了调用进来的值

            //weatherData = new WeatherData();    报错

        }

        public void testBaseType(int a, final int b, final Integer c){
            a = 200;  //可以在checkInt方法内部把i的值改变，不报错。虽然不会改变实际调用处的值。可能会引用一些难以发现的BUG
            //b = 11;    //报错，没有犯错的机会
            //c = 12;   //报错
        }
    }

    public final void test() {      //final修饰变量, 方法不能被子类重写,即 override. 但不影响重载, 即 overload
    }



}


/**
 * 1.final修饰变量(成员变量 + 静态变量 = 宏变量):
 *      要在初始化的时候赋值,且不能更改
 *
 * 2.final修饰方法参数:
 *    防止方法参数在调用时被篡改。
 *      1.对于基本类型及其包装类，final关键字无用，
 *      2.对于引用类型，亦可以防止参数被重新赋值。
 * 综上：防止在方法内部参数无意被篡改。导致方法执行出出现隐藏的bug
 *
 *  对于static关键字修饰的方法，由于调用时参数是各个线程栈空间传入的私有的。所以与其无关。
 *      对于静态变量，若没有final修饰，就要考虑假如线程执行过程中被篡改的情况。
 *
 *
 *
 * */