package leetCode;

/**
 * 判断给定的数是否为丑数。
 * 丑数就是只包含质因数 2, 3, 5 的正整数
 */
public class _263_isUgly {

    public boolean isUgly(int num) {

        while (true) {
            if (num == 0) return false;
            if (num == 1) return true;
            if ((num & 1) == 0) {//能被2整除， 可能能被5整除
                num = (num >> 1);
                continue;
            }
            if (num % 3 == 0) {
                num /= 3;
                continue;
            }
            if ((num % 5) == 0) {
                num /= 5;
            } else {
                return false;
            }
        }
    }

    /**
     * 简化写法, 我觉得目前效率最高
     */
    public boolean isUgly2(int num) {
        while (num > 1 && (num % 2 == 0 || num % 3 == 0 || num % 5 == 0)) {
            if (num % 2 == 0)
                num /= 2;
            if (num % 3 == 0)
                num /= 3;
            if (num % 5 == 0)
                num /= 5;
        }
        return num == 1;
    }

    //递归写法
    public boolean isUgly3(int num) {
        if (num < 1)
            return false;
        return search(num);//开始递归
    }

    public boolean search(int num){
        if(num == 1){
            return true;
        }
        return num % 5 == 0 ? search(num/5) :
                num % 3 == 0 ? search(num/3) :
                        num % 2 == 0 && search(num / 2);
    }

    public static void main(String[] args) {
        System.out.println(new _263_isUgly().isUgly3(5));
        System.out.println(new _263_isUgly().isUgly3(6));
        System.out.println(new _263_isUgly().isUgly3(7));
        System.out.println(new _263_isUgly().isUgly3(8));
        System.out.println(new _263_isUgly().isUgly3(9));
        System.out.println(new _263_isUgly().isUgly3(10));
        System.out.println(new _263_isUgly().isUgly3(11));
        System.out.println(new _263_isUgly().isUgly3(14));
        //System.out.println(7 & 101);
    }
}
