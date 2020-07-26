package interview.huawei;

import java.util.Arrays;

/**
 * 元音字母 aeiou, 查找一段字符串中仅包含元音字母字串的最大串长度
 */

@SuppressWarnings("All")
public class VowelSeriesNum_2 {

    public int getMaxLength(String str) {
        char[] target = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        int[] signal = new int[str.length()];
        Arrays.fill(signal, 0);
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            for (int j = 0; j < target.length; j++) {
                if(target[j] == ch){
                    if(i==0){
                        signal[i] = 1;
                    }else{
                        signal[i] += signal[i-1] + 1;
                    }
                    break;
                }
            }
        }


        return Arrays.stream(signal).max().getAsInt();
    }

    public static void main(String[] args) {
        String str = "asdbuioadevauufghadadaAaaa";
        System.out.println(new VowelSeriesNum_2().getMaxLength(str));
    }
}
