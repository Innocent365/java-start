package interview;


import java.util.*;

/**
 * 新国都 机试 题，
 * 在一个字符串中，找到所有的大小写字母，按出现频率排列，若出现频率相同，则按字典顺序排列
 * 若没有，输入空字符串
 *
 * @author hw
 * @version on 2020/7/20
 */
public class XinGuoDu {
    public static void main(String[] args) {
        //a-z 97-122
        //A-Z 65-90

        String text = "org.apache.coyote.AbstractProtocol.init Initializing ProtocolHandler [\"ajp-nio-8009\"]";
        System.out.println(new XinGuoDu().事后更新的(text));
    }

    public String 现场写的(String str) {
        int[] times = new int[26];
        char[] chs = str.toCharArray();

        for (char ch : chs) {
            if (ch >= 65 && ch <= 90) {
                times[ch - 65]++;
            }
            if (ch >= 97 && ch <= 122) {
                times[ch - 97]++;
            }
        }

        TreeMap<Integer, StringBuilder> map = new TreeMap<>();
        for (int i = 0; i < times.length; i++) {
            if (times[i] == 0) {
                continue;
            }

            StringBuilder sb = map.get(times[i]);
            if (sb == null) {
                sb = new StringBuilder();
            }
            sb.append((char) (i + 97));
            map.put(times[i], sb);
        }
        StringBuilder result = new StringBuilder();

        Set<Integer> set = map.descendingKeySet();
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            result.append(map.get(iterator.next()).toString());
        }

        return result.toString();
    }

    public String 事后更新的(String str) {
        TreeMap<Character, Integer> map = new TreeMap<>();

        char[] chs = str.toCharArray();
        for (char ch : chs) {
            int index = map.get(ch) == null ? 0 : map.get(ch);
            if ((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122)) {
                map.put(ch, index + 1);
            }
        }

        TreeMap<Integer, StringBuilder> reverseMap = new TreeMap<>();
        Iterator<Character> iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            Character i = iterator.next();
            Integer times = map.get(i);

            StringBuilder sb = reverseMap.get(times);
            if(sb == null){
                sb = new StringBuilder(i);
            }
            sb.append(i);
            reverseMap.put(times, sb);
        }

        StringBuilder result = new StringBuilder();
        Iterator<Integer> iterator1 = reverseMap.descendingKeySet().iterator();
        while (iterator1.hasNext()){
            result.append(reverseMap.get(iterator1.next()));
        }

        return result.toString();
    }
}
