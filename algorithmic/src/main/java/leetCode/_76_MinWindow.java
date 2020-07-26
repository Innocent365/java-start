package leetCode;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author hw
 * @version on 2020/3/26
 */
public class _76_MinWindow {
    /**
     * 压缩窗口只能写到这个程度了，数据大了会超时，会报递归错误
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        int[] count = new int[128];
        for (char ch : t.toCharArray()) {
            count[ch]++;
        }

        final int[][] temp = {new int[128]};
        for (int i = 0; i < s.length(); i++) {
            temp[0][s.charAt(i)]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] > temp[0][i]) {
                return "";
            }
        }
        List<Integer[]> list = new ArrayList<>();

        Consumer<Integer[]> track = new Consumer<Integer[]>() {

            @Override
            public void accept(Integer[] integers) {

                int left = integers[0], right = integers[1];

                while (left + t.length() <= right) {
                    int _left = s.charAt(left);
                    int _right = s.charAt(right);

                    if (count[_left] == 0){
                        temp[0][_left]--;
                        left++;
                        continue;
                    }
                    if (count[_right] == 0) {
                        right--;
                        temp[0][_right]--;
                        continue;
                    }

                    if (count[_left] < temp[0][_left] &&
                            count[_right] < temp[0][_right]
                    ) {
                        int[] tmp = temp[0].clone();
                        temp[0][_right]--;
                        this.accept(new Integer[]{left, right-1});
                        temp[0] = tmp;

                        temp[0][_left]--;
                        left++;
                    }else{
                        if (count[_left] < temp[0][_left]){
                            temp[0][_left]--;
                            left++;
                        }
                        else if (count[_right] < temp[0][_right]) {
                            right--;
                            temp[0][_right]--;
                        }else {
                            break;
                        }
                    }
                }
                list.add(new Integer[]{left, right});
            }
        };

        int left = 0, right = s.length() - 1;
        int[] min = new int[2];
        track.accept(new Integer[]{left, right});
        Iterator<Integer[]> iterator = list.iterator();
        while (iterator.hasNext()){
            Integer[] arr = iterator.next();
            left = arr[0];
            right = arr[1];
            System.out.println("[" + left + ", " + right + "]");
            System.out.println(s.substring(left, right + 1));
            if(min[1] == 0 || min[1] - min[0] > right - left){
                min = new int[]{left, right};
            }
        }

        return s.substring(min[0], min[1] + 1);
    }


    public static void main(String[] args) {
        //String S = "ADOBECODEBANC", T = "ABC";
        //String S = "AA", T = "AA";
        //String S = "AA", T = "A";
        //String S = "cabwefgew cwaefgc f", T = "cae";//"aefgc"、"cwae"
        //String S = "aaabdabcefaecbef", T = "abc";//"aefgc"、"cwae"

        String S ="ask_not_what_your_country_can_do_for_you_ask_what_you_can_do_for_your_country";
        String T = "ask_country";

        System.out.println(new _76_MinWindow().minWindow(S, T));

        //System.out.println((int)'a'+ "~" + (int)'z');
        //System.out.println((int)'A' + "~" + (int)'Z');

        for (int i = 0; i < 128; i++) {
            System.out.print((char)i + "、");
        }
    }
}
