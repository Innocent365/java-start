package javaSE.collection;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author hw
 * @version on 2019/3/27
 * treeMap的数据类型不能不一致
 */
public class TestTreeMap {
    public static void main(String[] args) {
        /* This is how to declare TreeMap */
        TreeMap<Object, String> tmap = new TreeMap<Object, String>();

        /*Adding elements to TreeMap*/
        //tmap.put(1, "Data1");
        //tmap.put(23, "Data2");
        //tmap.put(70, "Data3");
        //tmap.put(4, "Data4");
        //tmap.put(2, "Data5");

        tmap.put("ew", "Data5");
        tmap.put("a", "Data5");
        tmap.put("cw", "Data5");

        /* Display content using Iterator*/
        Set set = tmap.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry)iterator.next();
            System.out.print("key is: "+ mentry.getKey() + " & Value is: ");
            System.out.println(mentry.getValue());
        }

    }
}
