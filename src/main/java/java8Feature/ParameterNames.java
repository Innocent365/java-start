package java8Feature;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 *  Java编译器的新特性:
 *  1.方法参数的名字能保留在Java字节码
 */
public class ParameterNames {
    public static void main(String[] args) throws NoSuchMethodException {
        Method method = ParameterNames.class.getMethod("main", String[].class);
        for (final Parameter parameter: method.getParameters()){
            System.out.println("Paramter: " + parameter.getName());
        }

    }
}
