package leetCode;

/**
 *
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 *
 */
public class _50_MyPow {

    /**
     * for循环相乘
     *
     */
    public double myPow1(double x, int n) {
        if (x == 0) return 0;
        if (x == 1 || n == 0) return 1;

        double val = x;
        long m = n;
        if (n < 0) {
            m = -(long) n;
            val = 1d / x;
            x = val;
        }

        for (int i = 1; i < m; i++) {
            x *= val;
        }

        return x;
    }

    /**
     * 利用公式 ：对于偶数的n: x^n = (x^2)^(n/2)
     */
    public double myPow2(double x, int n) {
        if (x == 0) return 0;
        if (x == 1 || n == 0) return 1;

        double val = x;
        long m = n;
        if (n < 0) {
            m = -(long) n;
            val = 1d / x;
        }

        return reduce(val, m) ;
    }

    public double reduce(double x, long n) {
        if (n == 1) {
            return x;
        }

        return reduce(x * x, n / 2) * (((n & 1) > 0) ? x : 1);
    }

    /**
     * 干掉递归
     */
    public double myPow3(double x, int n) {
        if (x == 0) return 0;
        if (x == 1 || n == 0) return 1;

        double val = x;
        long m = n;
        if (n < 0) {
            m = -(long) n;
            val = 1d / x;
        }

        double ans = 1;
        for (long i = m; i > 0; i/=2) {
            if ((i & 1) > 0) {
                ans *= val;
            }
            val *= val;
        }
        return ans;
    }

    /**
     * 看多优雅
     */
    public double myPow4(double x, int n) {
        if (n == 0) { return 1; }
        if (n == 1) { return x; }
        if (n == -1) { return 1 / x; }
        double half = myPow4(x, n / 2);
        double rest = myPow4(x, n % 2);
        return rest * half * half;
    }

    public static void main(String[] args) {

        System.out.println(new _50_MyPow().myPow3(2.10000, 3));
        System.out.println(new _50_MyPow().myPow3(2.00000, 3));
        System.out.println(new _50_MyPow().myPow3(2.00000, 10));
        System.out.println(new _50_MyPow().myPow3(2.00000, -2));
        System.out.println(new _50_MyPow().myPow3(2.00000, 2147483647));
        System.out.println(new _50_MyPow().myPow3(2.00000, -2147483648));

        System.out.println(-(-2147483648));
        System.out.println((long) Math.abs(-2147483648));
        System.out.println(-Integer.MIN_VALUE);
    }
}
