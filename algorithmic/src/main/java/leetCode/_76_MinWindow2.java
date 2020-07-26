package leetCode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author hw
 * @version on 2020/3/26
 */
@SuppressWarnings("All")
public class _76_MinWindow2 {

    /**
     * 用什么Map，数组不香吗？
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        int[] count = new int[128];
        for (char ch : t.toCharArray()) {
            count[ch]++;
        }

        int from = 0, to = 0, length = -1;

        int[] temp = new int[128];
        for (int i = 0; i < t.length(); i++) {
            temp[s.charAt(i)]++;
        }

        int left = 0, right = t.length() - 1;
        while (true) {
            for (int i = 0; i < count.length; i++) {
                while (count[i] > temp[i]) {
                    if (right < s.length()-1) {
                        temp[s.charAt(++right)]++;
                    }
                    if(right == s.length()-1){
                        if(count[i] > temp[i]){
                            return s.substring(from, length > -1 ? to + 1 : 0);
                        }
                    }
                }
            }
            while (temp[s.charAt(left)] > count[s.charAt(left)]) {
                temp[s.charAt(left)]--;
                left++;
            }
            if (length == -1 || right - left < length) {
                from = left;
                to = right;
                length = to - from + 1 ;
            }
            if (length == t.length()) {
                return s.substring(left, right + 1);
            }
            if (right == s.length() - 1) {
                return s.substring(from, to + 1);
            }
            temp[s.charAt(left)]--;
            left++;
        }
    }


    public static void main(String[] args) {
        //String S = "ADOBECODEBANC", T = "ABC";
        //String S = "AA", T = "AA";
        //String S = "AA", T = "A";
        //String S = "A", T = "AA";
        //String S = "A", T = "A";
        //String S = "A", T = "B";
        //String S = "AB", T = "A";
        //String S = "AB", T = "B";
        //String S = "cabwefgew cwaefgc f", T = "cae";//"aefgc"、"cwae"
        //String S = "aaabdabcefaecbef", T = "abc";//"aefgc"、"cwae"

        String S ="ask_not_what_your_country_can_do_for_you_ask_what_you_can_do_for_your_country";
        String T = "ask_country";

        System.out.println(new _76_MinWindow2().minWindow(S, T));

        //System.out.println((int)'a'+ "~" + (int)'z');
        //System.out.println((int)'A' + "~" + (int)'Z');

        for (int i = 0; i < 128; i++) {
            System.out.print((char) i + "、");
        }
    }
}
