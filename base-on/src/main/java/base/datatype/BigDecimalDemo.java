package base.datatype;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author hw
 * @version on 2019/3/20
 */
public class BigDecimalDemo {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("12");
        BigDecimal b = new BigDecimal("12.0");
        System.out.println(a.compareTo(b)); //0

        BigDecimal c = new BigDecimal("12.01");
        System.out.println(a.compareTo(c));//-1


        System.out.println(new BigDecimal("1").multiply(new BigDecimal("7.00")));
    }

    @Test
    public void test(){
        //Integer a = Integer.parseInt("7.00");
        Integer b = Integer.parseUnsignedInt("7.00");
    }


}
