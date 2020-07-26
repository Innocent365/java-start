package leetCode;

/**
 * @author hw
 * @version on 2020/5/3
 */
public class _264_nthUglyNumber {

    public int nthUglyNumber(int n) {

        int[] nums = new int[n];
        nums[0] = 1;

        int begin = 1, i=1;
        while (i<n){
            switch (i%4) {
                case 1:
                    nums[i++] = begin * 2;
                    continue;

                case 2:
                    nums[i++] = begin * 3;
                    continue;

                case 3:
                    nums[i++] = begin * 4;
                    continue;

                case 0:
                    nums[i++] = begin * 5;
                    begin = begin * 3;
            }
        }

        return nums[nums.length-1];
    }

    public static void main(String[] args) {
        System.out.println(new _264_nthUglyNumber().nthUglyNumber(10));
    }

}
