package leetCode;

/**
 *
 * 或运算的最小翻转次数
 *
 * 三个正整数 a、b 和 c
 * @version on 2020/5/3
 */
public class _1138_minFlips {

    public int minFlips(int a, int b, int c) {
        int count = 0;

        for (int i = 0; i < 32; i++) {
            int t = (c >> i) & 1;
            int l = (a >> i) & 1;
            int r = (b >> i) & 1;

            if (t == 1) {
                if (l == 0 && r == 0) {
                    count++;
                }
            } else {//t==0
                if (l == 1) {
                    count++;
                }
                if (r == 1) {
                    count++;
                }
            }
        }
        return count;
    }



    public static void main(String[] args) {
        //int a = 2, b = 6, c = 5;
        //int a = 4, b = 2, c = 7;
        //int a = 1, b = 2, c = 3;

        int a = -1, b = 2, c = 3;
        System.out.println(new _1138_minFlips().minFlips(a, b, c));
    }
}
