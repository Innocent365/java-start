package collection;

import java.util.*;

/**
 * @author hw
 * @version on 2020/4/1
 */
@SuppressWarnings("all")
public class TreeMapDemo {

    public static void main(String[] args) {

        TreeMap<Object, String> tmap = new TreeMap<Object, String>();

        tmap.put("ew", "Data5");
        tmap.put("a", "Data5");
        tmap.put("cw", "Data5");

        //tmap.put(1, "data");
        //抛异常：java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Integer


        //treeMap特有的获取元素：
        Object firstKey = tmap.firstKey();//获取集合内第一个元素
        Object lastKey =tmap.lastKey();//获取集合内最后一个元素
        SortedMap<Object,String> headMap =  tmap.headMap("a");//返回从头到toKey的集合：不包含toKey
        SortedMap<Object,String> tailMap =  tmap.tailMap("a");//返回fromKey到尾的集合：包含fromKey

        Object lowerKey =tmap.lowerKey("jiaboyan");//获取集合内的key小于"jiaboyan"的key
        Object ceilingKey =tmap.ceilingKey("jiaboyan");//获取集合内的key大于等于"jiaboyan"的key
        SortedMap<Object,String> sortedMap =tmap.subMap("a","my");//获取集合的key从"a"到"jiaboyan"的元素



        Set<Map.Entry<Object, String>> set = tmap.entrySet();


        //遍历方式1
        for (Map.Entry<Object, String> entry: set){
            System.out.print("key is: "+ entry.getKey() + " & Value is: ");
            System.out.println(entry.getValue());
        }

        ////遍历方式2
        Iterator<Map.Entry<Object, String>> iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry mentry = iterator.next();
            System.out.print("key is: "+ mentry.getKey() + " & Value is: ");
            System.out.println(mentry.getValue());
        }

    }
}
