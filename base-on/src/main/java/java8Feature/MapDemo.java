package java8Feature;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hw
 * @version on 2020/7/20
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();

        map.put('a', 10);
        map.put('b', 20);
        map.put('c', 30);
        map.put('d', null);

        Integer value = map.put('z', 100);//put方法默认返回当前值
        System.out.println(value);

        System.out.println("--------------");
        /**
         * putIfAbsent(key, value)，
         *  absent缺席
         *
         *  如果 value 为null的时候(或找不到key的时候)，才设置。此时返回的是 null
         *
         */
        Integer val = map.putIfAbsent('e', 11);
        System.out.println(val);
        System.out.println(map.get('e'));

        val = map.putIfAbsent('d', 11);
        System.out.println(val);
        System.out.println(map.get('d'));

        //否则，若存在，不改变当前值
        map.putIfAbsent('a', 111);
        System.out.println(map.get('a'));

        /**
         * computeIfAbsent
         */
        //map.computeIfAbsent()

    }


}
