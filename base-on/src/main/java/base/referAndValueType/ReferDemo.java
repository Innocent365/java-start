package base.referAndValueType;

import org.junit.Test;

/**
 * 值类型与引用类型
 * Created by ss on 2016/11/16.
 */
public class ReferDemo {

    public static void main(String[] args){

        Diu d = new Diu();
        d.value = 10;

        new Func().ChangeValue(d);
        System.out.println(d.value);
    }

    @Test
    public void test(){
        String a = "AAA";
        String b = a;

        b = "BBB";
        System.out.println(a);
    }
}


class Diu{
    int value;
}


class Func{

    public void ChangeValue(Diu d){
        d.value *= 99;
    }

    public void TestBase(int x){
        x = 34;
    }

}