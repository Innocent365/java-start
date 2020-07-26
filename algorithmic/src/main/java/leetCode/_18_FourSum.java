package leetCode;

import java.util.*;

/**
 * @author hw
 * @version on 2020/3/21
 */
@SuppressWarnings("ALL")
public class _18_FourSum {
    /**
     * copy from _15_threeSum
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> set = new HashSet<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum < target) {
                        left++;
                    } else if (sum == target) {
                        set.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        right--;
                    } else if (sum > target) {
                        right--;
                    }
                }
            }
        }

        return new ArrayList<>(set);
    }

    /**
     * 散列表解决问题
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum2(int[] nums, int target) {
        Set<List<Integer>> set = new HashSet<>();
        //Arrays.sort(nums);
        Map<Integer, LinkedList<Integer[]>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];

                LinkedList targetList = map.get(target - sum);
                if(targetList != null){
                    Iterator<Integer[]> it = targetList.iterator();
                    while (it.hasNext()){
                        Integer[] tuple = it.next();
                        if(tuple[1] < i){
                            List<Integer> list = Arrays.asList(new Integer[]{nums[i], nums[j], nums[tuple[0]], nums[tuple[1]]});
                            Collections.sort(list);
                            set.add(list);
                        }
                    }
                }

                LinkedList linkedList = map.get(sum);

                if (linkedList == null){
                    linkedList = new LinkedList();
                    map.put(sum, linkedList);
                }
                linkedList.push(new Integer[]{i, j});

            }
        }
        return new ArrayList<>(set);
    }

    /**
     * copy 这个set的写法可以
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum3(int[] nums, int target) {
        // 建立去重的容器
        Set<List<Integer>> result_set = new TreeSet<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                for (int i = 0; i < o1.size(); i++) {
                    if (!o1.get(i).equals(o2.get(i)))
                        return o1.get(i) - o2.get(i);
                }
                return 0;
            }
        });
        return null;
    }


    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2, -1};
        List<List<Integer>> list = new _18_FourSum().fourSum3(nums, 0);
        list.stream().forEach(System.out::println);
    }
}
