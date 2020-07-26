package jvm.methodarea;

import java.util.HashSet;
import java.util.Set;

/**
 * 常量池溢出：
 *  jdk6及以下
 *      VM Args: -XX:PermSize=6M -XX:MaxPermSize=6M
 *
 * jdk7起，原本存放在永久代的字符串常量池被移至java堆中，因此vm参数限制对其毫无意义
 *      VM Args: -Xmx6M
 *      java.lang.OutOfMemoryError: GC overhead limit exceeded
 *
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {

        Set<String> set = new HashSet<>();

        short i = 0;
        while (true){
            set.add(String.valueOf(i++).intern());
        }
    }
}
