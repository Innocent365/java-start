package common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author hw
 * @version on 2020/3/22
 */
public class SubList {

    /**
     * 检查列表中是否存在子列表满足长度为nums个等差为unit，并返回所有满足条件的起始索引
     * @param list 待检查的列表
     * @param nums 子列表条件个数
     * @param unit 子列表的等差值
     * @return indexs
     */
    public static List<Integer> getSub(List<Integer> list, int nums, int unit) {
        List<Integer> indexs = new ArrayList<>();
        for (int i = 0; i + nums <= list.size(); i++) {
            int index = list.get(i);

            boolean contains = true;
            for (int j = 1; j < nums; j++) {
                int offer = j * unit;
                if (list.get(i + j) != index + offer) {
                    contains = false;
                    break;
                }
            }
            if (contains) {
                indexs.add(index);
            }
        }
        return indexs;
    }

    public static void main(String[] args) {
        Integer[] arr = {0, 2, 4, 6, 8, 10, 12, 16, 18};
        List<Integer> list = new ArrayList<>(Arrays.asList(arr));
        List<Integer> indexs = getSub(list, 4, 2);
        indexs.stream().forEach(System.out::println);
    }
}
