package leetCode;

import java.util.ArrayList;
import java.util.List;


/**
 * @author hw
 * @version on 2020/3/6
 */
@SuppressWarnings("ALL")
public class _3_MaxSubString {
    /**
     * 第一版
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if(s.length() < 2){
            return s.length();
        }

        int max = 0;
        char[] charArray = s.toCharArray();
        List<Character> list = new ArrayList();
        list.add(charArray[0]);
        for (int i = 1; i < charArray.length; i++) {
            char ch = charArray[i];

            boolean exist = false;
            for (int j = 0; j < list.size(); j++) {
                if (ch == list.get(j)) {
                    exist = true;
                    break;
                }
            }
            if (exist) {
                if (max < list.size()) {
                    max = list.size();
                }
                int num = list.indexOf(ch);
                for (int k = 0; k < num + 1; k++) {
                    list.remove(0);
                }
                //list = list.subList(list.indexOf(i) + 1, list.size());
            }
            list.add(ch);
        }
        return Integer.max(max, list.size());
    }



    public static void main(String[] args) {
        String s1 = "abcabrbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";
        String s4 = "";
        String s5 = " ";
        String s6 = "au";
        String s7 = "aabaab!bb";
        System.out.println(new _3_MaxSubString().lengthOfLongestSubstring(s1));
    }

}
