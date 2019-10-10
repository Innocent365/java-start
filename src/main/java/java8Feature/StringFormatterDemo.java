package java8Feature;

import java.text.MessageFormat;

/**
 * @author hw
 * @version on 2019/3/20
 */
public class StringFormatterDemo {
    public static void main(String[] args) {
        String pattern = "My name is {0}, age {1}";
        System.out.println(MessageFormat.format(pattern, "huangwu", 18));
    }


}
