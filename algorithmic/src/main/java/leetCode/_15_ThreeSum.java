package leetCode;

import java.util.*;

/**
 * @author hw
 * @version on 2020/3/16
 */
@SuppressWarnings("ALL")
public class _15_ThreeSum {

    /**
     * 暴力法
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if(nums[i] + nums[j] + nums[k] == 0){
                        List list = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(list);
                        set.add(list);
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1, k = nums.length - 1;
            while (j < k){
                if(-nums[i] == nums[j] + nums[k]){
                    set.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    k--;
                }else if(-nums[i] < nums[j] + nums[k]){
                    k--;
                }else if(-nums[i] > nums[j] + nums[k]){
                    j++;
                }
            }
        }

        return new ArrayList<>(set);
    }

    /**
     * 简化2的代码
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            while (j < k){
                if(-nums[i] <= nums[j] + nums[k]){
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    k--;
                }else if(-nums[i] < nums[j] + nums[k]){
                    k--;
                }else if(-nums[i] > nums[j] + nums[k]){
                    j++;
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        //int[] array ={-1, 0, 1, 2, -1, -4};
        //List<List<Integer>> set = new _15_ThreeSum().threeSum(array);
        //set.stream().forEach(System.out::println);

        //int[] array ={-1, 0, 1, 2, -1, -4};
        int[] array ={0,0,0,0};
        List<List<Integer>> list = new _15_ThreeSum().threeSum2(array);
        list.stream().forEach(System.out::println);
    }
}
