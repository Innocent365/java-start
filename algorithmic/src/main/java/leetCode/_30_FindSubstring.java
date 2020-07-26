package leetCode;

import java.util.*;

/**
 * 超时，但是能满足题目要求
 * @author hw
 * @version on 2020/3/21
 */
@SuppressWarnings("ALL")
public class _30_FindSubstring {
    public List<Integer> findSubstring(String s, String[] words) {
        List<String> list = new ArrayList<>();
        permutation(words, 0, list);
        Set<String> set = new HashSet<>(list);
        //list.stream().forEach(System.out::println);

        List<Integer> indexs = new ArrayList<>();
        for (String item : set){
            int from = s.indexOf(item, 0);
            while (from > -1){
                indexs.add(from);
                from = s.indexOf(item, from + 1);
            }
        }

        return indexs;
    }


    /**
     * 给出给定元素的所有 排列（共有n的阶乘种）
     */
    public void permutation(String[] strs, int start, List<String> builders){
        if(start == strs.length - 1){
            builders.add(String.join("", Arrays.asList(strs)));
        }
        for (int i = start; i < strs.length; i++) {
            if(i == start || !strs[i].equals(strs[start])){//去掉重复的元素
                swap(strs, i, start);
                permutation(strs, start + 1, builders);
                swap(strs, i, start);
            }
        }
    }

    public static <T>void swap(T[] arr,int i,int j){
        T temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void main(String[] args) {
        //String words = "sadasa";
        //String[] arr = {"sa","da"};

        //String words = "wordgoodgoodgoodbestword";
        //String[] arr = {"word","good","best","good"};
        //List<Integer> list = new _30_FindSubstring().findSubstring(words, arr);
        //list.stream().forEach(System.out::println);

        //String words = "foobarfoobar";
        //String[] arr = {"foo","bar"};


        String words = "pjzkrkevzztxductzzxmxsvwjkxpvukmfjywwetvfnujhweiybwvvsrfequzkhossmootkmyxgjgfordrpapjuunmqnxxdrqrfgkrsjqbszgiqlcfnrpjlcwdrvbumtotzylshdvccdmsqoadfrpsvnwpizlwszrtyclhgilklydbmfhuywotjmktnwrfvizvnmfvvqfiokkdprznnnjycttprkxpuykhmpchiksyucbmtabiqkisgbhxngmhezrrqvayfsxauampdpxtafniiwfvdufhtwajrbkxtjzqjnfocdhekumttuqwovfjrgulhekcpjszyynadxhnttgmnxkduqmmyhzfnjhducesctufqbumxbamalqudeibljgbspeotkgvddcwgxidaiqcvgwykhbysjzlzfbupkqunuqtraxrlptivshhbihtsigtpipguhbhctcvubnhqipncyxfjebdnjyetnlnvmuxhzsdahkrscewabejifmxombiamxvauuitoltyymsarqcuuoezcbqpdaprxmsrickwpgwpsoplhugbikbkotzrtqkscekkgwjycfnvwfgdzogjzjvpcvixnsqsxacfwndzvrwrycwxrcismdhqapoojegggkocyrdtkzmiekhxoppctytvphjynrhtcvxcobxbcjjivtfjiwmduhzjokkbctweqtigwfhzorjlkpuuliaipbtfldinyetoybvugevwvhhhweejogrghllsouipabfafcxnhukcbtmxzshoyyufjhzadhrelweszbfgwpkzlwxkogyogutscvuhcllphshivnoteztpxsaoaacgxyaztuixhunrowzljqfqrahosheukhahhbiaxqzfmmwcjxountkevsvpbzjnilwpoermxrtlfroqoclexxisrdhvfsindffslyekrzwzqkpeocilatftymodgztjgybtyheqgcpwogdcjlnlesefgvimwbxcbzvaibspdjnrpqtyeilkcspknyylbwndvkffmzuriilxagyerjptbgeqgebiaqnvdubrtxibhvakcyotkfonmseszhczapxdlauexehhaireihxsplgdgmxfvaevrbadbwjbdrkfbbjjkgcztkcbwagtcnrtqryuqixtzhaakjlurnumzyovawrcjiwabuwretmdamfkxrgqgcdgbrdbnugzecbgyxxdqmisaqcyjkqrntxqmdrczxbebemcblftxplafnyoxqimkhcykwamvdsxjezkpgdpvopddptdfbprjustquhlazkjfluxrzopqdstulybnqvyknrchbphcarknnhhovweaqawdyxsqsqahkepluypwrzjegqtdoxfgzdkydeoxvrfhxusrujnmjzqrrlxglcmkiykldbiasnhrjbjekystzilrwkzhontwmehrfsrzfaqrbbxncphbzuuxeteshyrveamjsfiaharkcqxefghgceeixkdgkuboupxnwhnfigpkwnqdvzlydpidcljmflbccarbiegsmweklwngvygbqpescpeichmfidgsjmkvkofvkuehsmkkbocgejoiqcnafvuokelwuqsgkyoekaroptuvekfvmtxtqshcwsztkrzwrpabqrrhnlerxjojemcxel";
        String[] arr = {"dhvf","sind","ffsl","yekr","zwzq","kpeo","cila","tfty","modg","ztjg","ybty","heqg","cpwo","gdcj","lnle","sefg","vimw","bxcb"};
        List<Integer> list = new _30_FindSubstring().findSubstring(words, arr);
        list.stream().forEach(System.out::println);


    }
}
