package leetCode;

/**
 * 一个整数数组 nums，其中恰好有两个元素只出现一次, 其余所有元素均出现两次。
 *
 * @author hw
 * @version on 2020/5/3
 */
public class _260_singleNumber {
    public int[] singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }

        //从低到高 找到ans第一个不为0的数
        int i = ans & (-ans);

        //分开两组，可以确定目标两个数分别在不同的组
        int[] res = {0, 0};
        for (int num : nums) {
            res[(num & i) == 0 ? 1 : 0] ^= num;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 2, 5};
        int res[] = new _260_singleNumber().singleNumber(nums);
        System.out.println(res[0] + ", " + res[1]);
    }
}
