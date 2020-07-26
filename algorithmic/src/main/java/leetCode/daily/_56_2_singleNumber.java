package leetCode.daily;

/**
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 * 例如：
 *      输入：nums = [9,1,7,9,7,9,7]
 *      输出：1
 *
 * 限制：
 *      1 <= nums.length <= 10000
 *      1 <= nums[i] < 2^31
 *
 *
 * @author hw
 * @version on 2020/5/1
 */
public class _56_2_singleNumber {

    //哈希表
    public int singleNumber1(int[] nums){
        int[] ary = new int[10000];
        for (int num : nums) {
            ary[num] ++;
        }
        for (int i = 0; i < ary.length; i++) {
            if(ary[i] == 1){
                return i;
            }
        }
        return 0;
    }

    //位运算
    public int singleNumber2(int[] nums){
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : nums) {
                if((num &(1<<i)) > 0){
                    count ++;
                }
            }
            if(count % 3 > 0){
                ans ^= (1<<i);//采用异或的方法生成二进制中的每一位
                //ans |= (1<<i);//都可以
                //ans += (1<<i);//也可以
            }
        }

        return ans;
    }

    //状态机 todo
    //https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/solution/zhuang-tai-ji-jie-jue-ci-wen-ti-xiang-jie-shu-zi-d/
    public int singleNumber3(int[] nums){
        return 0;
    }


    public static void main(String[] args) {
        int[] nums = {9,7,7,9,3,9,7};
        _56_2_singleNumber instance = new _56_2_singleNumber();

        System.out.println(instance.singleNumber1(nums));
    }

}
