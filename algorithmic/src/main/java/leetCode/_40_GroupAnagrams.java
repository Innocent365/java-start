package leetCode;

import java.util.*;

/**
 * @author hw
 * @version on 2020/3/26
 */
public class _40_GroupAnagrams {

    /**
     * 官方思路
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams3(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        int[] count = new int[26];
        for(String s: strs){
            Arrays.fill(count, 0);
            for (char ch: s.toCharArray()){
                count[ch - 'a'] ++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < count.length; i++) {
                sb.append("#").append(count[i]);
            }

            List<String> list = map.computeIfAbsent(sb.toString(), k -> new ArrayList<>());
            list.add(s);
        }

        return new ArrayList<>(map.values());
    }

    /**
     * 不行，哈希表的key不能标识唯一
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<Integer, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            int hash = 0;
            for (int j = 0; j < arr.length; j++) {
                hash += Objects.hash(arr[j]);
            }
            List<String> list = map.computeIfAbsent(hash, k -> new ArrayList());
            list.add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String temp = new String(arr);
            List<String> list = map.computeIfAbsent(temp, k -> new ArrayList());
            list.add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> list = new _40_GroupAnagrams().groupAnagrams3(arr);
        for (int i = 0; i < list.size(); i++) {
            System.out.print("[");
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(j ==0 ?"":" ");
                System.out.print(list.get(i).get(j) + (j!=list.get(i).size()-1?",":""));
            }
            System.out.println("]");
        }
    }
}
