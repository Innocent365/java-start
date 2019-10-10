package base;



import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TimesForANumber {

    @Test
    public void test(String[] args) {
        int array[] = new int[]{1, 4, 6, 2, 7, 8, 13, 35, 34, 62, 42, 31, 4};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        Map<Integer,Integer> map = new HashMap();
        for (int a: array) {
            if(map.containsKey(a)) map.put(a, map.get(a) + 1);
            else map.put(a,1);
        }

        System.out.println(map.get(4));
    }

    @Test
    public void test1() {
        int array[] = new int[]{1, 4, 6, 2, 7, 8, 13, 35, 34, 62, 42, 31, 4};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        int target = 4;
        int count = 0;
//        for (int a : array) {
//            if(a != target && count != 0) break;
//            if(a==target) count ++;
//        }

        for (int a : array) {
            if(a == target ) {
                count ++;
                continue;
            }
            if(count != 0) break;
        }

        System.out.println(count);
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 3, 3, 3, 4, 5};
        System.out.println(getKCount(a, 3));
    }

    //二分法找到出现k的第一个和最后一个索引
    static int getKCount(int[] a, int k) {
        if (a != null && a.length != 0) {
            int first = getFirstK(a, k, 0, a.length - 1);
            int last = getLastK(a, k, 0, a.length - 1);
            if (first > -1 && last > -1) {
                return last - first + 1;
            }
        }
        return -1;
    }


    static int getFirstK(int[] a, int k, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        int midData = a[mid];
        if (midData == k) {
            if ((mid > 0 && a[mid - 1] != k) || mid == 0) {
                return mid;
            } else {
                end = mid - 1;
            }
        } else if (midData < k) {
            // 在后半段
            start = mid + 1;
        } else if (midData > k) {
            // 在前半段
            end = mid - 1;
        }

        return getFirstK(a, k, start, end);
    }


    static int getLastK(int[] a, int k, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        int midData = a[mid];
        if (midData == k) {
            if ((mid > 0 && a[mid + 1] != k) || mid == a.length - 1) {
                return mid;
            } else {
                start = mid + 1;
            }
        } else if (midData < k) {
            // 在后半段
            start = mid + 1;
        } else if (midData > k) {
            // 在前半段
            end = mid - 1;
        }

        return getLastK(a, k, start, end);
    }
}
