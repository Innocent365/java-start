package javaSE.stringAndRegex;

import java.text.MessageFormat;
import java.util.Date;

/**
 * @author hw
 * @version on 2019/4/20
 */
public class StringFormatDemo {

    public static void main(String[] args) {
        System.out.println(MessageFormat.format("Hello, {0}", "Tom"));

        System.out.println(String.format("Hi, %s", "Jack"));

        System.out.println(String.format("Year is %tY", new Date()));
        System.out.println(String.format("Month is %tm", new Date()));
        System.out.println(String.format("Day is %td", new Date()));
    }


}
