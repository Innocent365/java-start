package leetCode;

import java.util.*;

/**
 * @author hw
 * @version on 2020/3/7
 */
public class _4_MedianSorted {
    public static void main(String[] args) {
        int[] nums1 = {1, 95, 96, 97, 98, 99};
        int[] nums2 = {78, 79, 80};

        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};
        System.out.println(new _4_MedianSorted().findMedianSortedArrays2(nums1, nums2));

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList();
        double result;
        for(int a:nums1){
            list.add(a);
        }
        for(int b:nums2){
            list.add(b);
        }
        list.sort(Integer::compareTo);
        int length = list.size();
        if(length%2 ==0){
            result =  (list.get(length/2 - 1) + list.get(length/2))/2d;
        }else{
            result =  list.get(length/2);
        }
        return result;
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {

        int[] array = new int[nums1.length + nums2.length];
        int len1 = nums1.length;
        for (int i = 0; i < array.length; i++) {
            if(i>=len1){
                array[i] = nums2[i - len1];
            }else{
                array[i] = nums1[i];
            }
        }
        Arrays.sort(array);
        double result;
        int length = array.length;
        if(length%2 ==0){
            result =  (array[length/2 - 1] + array[length/2])/2d;
        }else{
            result =  array[length/2];
        }
        return result;
    }
}
