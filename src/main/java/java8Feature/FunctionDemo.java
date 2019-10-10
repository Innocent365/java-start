package java8Feature;

import java.util.function.Function;

/**
 * @author hw
 * @version on 2019/8/11
 */
public class FunctionDemo {


    static void absoluteValue(int valueToBeOperated, Function<Integer, Integer> function){
        int newValue = function.apply(valueToBeOperated);
        System.out.println(newValue);
    }

    public static void main(String[] args) {
        int incr = 20;  int myNumber = 10;


        absoluteValue(myNumber, val-> val + incr);

        myNumber = 15;
        absoluteValue(myNumber, val-> val * 10);
        absoluteValue(myNumber, val-> val - 100);
        absoluteValue(myNumber, val-> "somestring".length() + val - 100);

    }

}
