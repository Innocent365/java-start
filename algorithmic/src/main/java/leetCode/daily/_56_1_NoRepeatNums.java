package leetCode.daily;

import java.util.LinkedList;
import java.util.List;

/**
 * 一个整型数组 nums 里除！两个！数字之外，其他数字都出现了！两次！。
 * 请写程序找出这两个只出现一次的数字。
 * 限制： 2 <= nums <= 10000
 * <p>
 * 要求时间复杂度是O(n): 只循环一次
 * 空间复杂度是O(1)：不创建额外变量
 *
 * @author hw
 * @version on 2020/4/28
 */
public class _56_1_NoRepeatNums {


    public int[] singleNumbers1(int[] nums) {
        List<Integer> list = new LinkedList<Integer>();
        for (int num : nums) {
            if (!list.removeIf(p -> p == num)) {
                list.add(num);
            }
        }
        return list.stream().mapToInt(p -> p).toArray();
    }

    /**
     * 哈希表
     * @param nums
     * @return
     */
    public int[] singleNumbers2(int[] nums) {
        int max = 10001;
        int[] array = new int[max];
        for (int num : nums) {
            array[num] += 1;
        }
        int x = -1, y = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                if (x == -1) {
                    x = i;
                } else {
                    y = i;
                    break;
                }
            }
        }
        return new int[]{x, y};
    }

    /**
     * 官方思路的自我实现（丑）
     *      it work!
     */
    public int[] singleNumbers3(int[] nums){

        int swap = 0;
        for (int i = 0; i < nums.length; i++) {
            swap ^= nums[i];
        }
        System.out.println(swap);

        int x_k = 1;
        while (((swap^x_k)&x_k) != 0){
            x_k <<= 1;
        }
        System.out.println(x_k);


        int[] sub1 = new int[nums.length];
        int[] sub2 = new int[nums.length];
        int index_sub1 = 0;
        int index_sub2 = 0;
        for (int num : nums) {
            if((num&x_k)==0){
                sub1[index_sub1 ++] = num;
            }else{
                sub2[index_sub2 ++] = num;
            }
        }

        int val1 = 0;
        System.out.println("sub1------");
        for (int i = 0; i < index_sub1; i++) {
            System.out.print(sub1[i] + ",");
            val1 ^= sub1[i];
        }
        System.out.println("reslut1: " +val1);

        int val2 = 0;
        System.out.println("sub2------");
        for (int i = 0; i < index_sub2; i++) {
            System.out.print(sub2[i] + ",");
            val2 ^= sub2[i];
        }
        System.out.println("reslut2: " +val2);

        return new int[]{val1, val2};
    }

    /**
     * 官方写法：方法一：分组异或
     * @param nums
     * @return
     */
    public int[] singleNumbers4(int[] nums){
        int xorSum = 0;
        int[] ret = new int[]{0,0};
        for (int i:nums){
            xorSum ^= i;
        }
        //找到xorSum最低位等于1的数字：原式是x&(x^(x-1))
        int lowbit = xorSum & (-xorSum);

        for (int num : nums) {
            ret[(num & lowbit) > 0 ? 0 : 1] ^= num;
        }

        return ret;
    }


    public static void main(String[] args) {
        //int[] nums = {4, 1, 4, 6};
        int[] nums = {1,2,10,4,1,4,3,3};


        int result[] = new _56_1_NoRepeatNums().singleNumbers4(nums);
        for (int i : result) {
            System.out.print(i + ", ");
        }

    }
}
