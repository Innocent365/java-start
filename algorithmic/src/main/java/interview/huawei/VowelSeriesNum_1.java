package interview.huawei;

/**
 * 元音字母 aeiou, 查找一段字符串中仅包含元音字母字串的最大串长度
 */
public class VowelSeriesNum_1 {

    public int getMaxLength(String str) {
        int[] target = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};

        int max = 0;

        int f = 0, l = str.length();
        while (f < l && f + max < l) {
            int ch = (int) str.charAt(f);
            boolean exist = false;
            for (int i = 0; i < target.length; i++) {
                if (ch == target[i]) {
                    exist = true;
                    break;
                }
            }

            if (!exist) {
                f++;
                continue;
            } else {
                while (f + max < l && valid(str, f, f + max)) {
                    max += 1;
                }
                f++;
            }
        }

        return max;
    }

    public static boolean valid(String arr, int start, int end) {
        int[] target = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};

        for (int i = start; i <= end; i++) {
            boolean exist = false;
            for (int j = 0; j < target.length; j++) {
                if ((int) arr.charAt(i) == target[j]) {
                    exist = true;
                    break;
                }
            }

            if (!exist) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String str = "asdbuioadevauufghadadaqaaa";
        System.out.println(new VowelSeriesNum_1().getMaxLength(str));
    }
}
