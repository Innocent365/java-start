package base.referAndValueType;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hw
 * @version on 2020/4/8
 */
public class ReferDemo2 {
    public static void main(String[] args) {
        System.out.println(getMap().get("KEY"));
        System.out.println(getInt());
    }

    public static Map<String, String> getMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("KEY", "INIT");
        try {
            map.put("KEY", "TRY");
            return map;
        }
        catch (Exception e) {
            map.put("KEY", "CATCH");
        }
        finally {
            map.put("KEY", "FINALLY");//起了作用
            map = null;//没起作用
        }
        return map;
    }

    public static Integer getInt() {
       Integer a = 10;
        try {
            a = 20;
            return a;
        }
        catch (Exception e) {

        }
        finally {
            a = 150;//没起作用
        }
        return a;
    }
}
