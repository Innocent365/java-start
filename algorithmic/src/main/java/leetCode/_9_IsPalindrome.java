package leetCode;

/**
 * @author hw
 * @version on 2020/3/9
 */
public class _9_IsPalindrome {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int digit = 0;
        while (x/Math.pow(10, digit)>=1){
            digit++;
        }
        for (int i = 0; i < digit/2; i++) {
            int start = (int) (x/(Math.pow(10,digit-i-1))%10);
            int end = (int) (x/Math.pow(10,i)%10);
            if(start != end){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //System.out.println(new IsPalindrome().isPalindrome(-121));
        //System.out.println(new IsPalindrome().isPalindrome(123));
        //System.out.println(new IsPalindrome().isPalindrome(1234));
        //
        System.out.println(new _9_IsPalindrome().isPalindrome(121));
        System.out.println(new _9_IsPalindrome().isPalindrome(1221));

        System.out.println(new _9_IsPalindrome().isPalindrome(10));
        ;
    }
}
