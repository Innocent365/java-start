package interview.huawei;

import java.util.Arrays;

/**
 * 小于等于10个人，每个人都有不多于1张的五福，最多有五张。
 * 统计能集齐多少张
 */
public class FiveFu {
    public static void main(String[] args) {
        String str = "00001,11110,11100,11111";
        String[] groups = str.split(",");

        int[] arr = new int[5];
        for (int i = 0; i < groups.length; i++) {
            for (int j = 0; j < 5; j++) {
                arr[j] += Character.getNumericValue(groups[i].charAt(j));
            }
        }

        //1.正常人的写法
        System.out.println(Arrays.stream(arr).min().getAsInt());

        //2.
        Arrays.sort(arr);
        System.out.println(arr[0]);

        //3.这样写有什么问题吗，没有，从来没有！！！
        int min = arr[0];
        for (int i = 1; i < 5; i++) {
            if(arr[i] < min){
                min = arr[i];
            }
        }

        //4.而我面试中是怎么写的
        min = Math.min(arr[0], arr[1]);
        min = Math.min(min, arr[2]);
        min = Math.min(min, arr[3]);
        min = Math.min(min, arr[4]);

        System.out.println(min);
    }
}
