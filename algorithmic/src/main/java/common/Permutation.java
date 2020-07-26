package common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 排列
 * @author hw
 * @version on 2020/3/21
 */
public class Permutation {
    /**
     * 给出给定元素的所有 排列（共有n的阶乘种）
     */
    public static void permutation(Character[] chars, int start, List<String> builders){
        if(start == chars.length - 1){
            builders.add(Arrays.toString(chars));
        }
        for (int i = start; i < chars.length; i++) {
            if(i == start || chars[i].equals(chars[start])){//去掉重复的元素
                swap(chars, i, start);
                permutation(chars, start + 1, builders);
                swap(chars, i, start);
            }
        }
    }

    public static <T>void swap(T[] arr, int i, int j){
        T temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void main(String[] args) {
        String chs = "sf";
        List<String> list = new ArrayList<>();
        Character[] characters = new Character[chs.length()];
        for (int i = 0; i < chs.length(); i++) {
            characters[i] = chs.toCharArray()[i];
        }
        permutation(characters, 0, list);
        list.stream().forEach(System.out::println);
    }
}
