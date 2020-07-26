package leetCode;

import java.util.*;

/**
 * @author hw
 * @version on 2020/3/7
 */
@SuppressWarnings("Duplicates")
public class _5_LongestPalindrome {
    public String longestPalindrome(String s) {
        if(s.length()<2) {
            return s;
        }

        int max = 1;
        List<Character> result = new ArrayList<>();
        result.add(s.charAt(0));

        char[] charArray = s.toCharArray();
        List<Character> list = new ArrayList();
        for (int i = 0; i < charArray.length; i++) {
            list.add(charArray[i]);
            if(list.size() <= max){
                continue;
            }

            List<Character> temp = getPalindrome(list, max);
            if(temp != null){
                max = temp.size();
                result = temp;
            }
        }
        return result.toString().replaceAll("[,\\s\\[\\]]", "");
    }

    public List<Character> getPalindrome(List<Character> originList, int digit){
        List<Character> tmp = new ArrayList<>(originList);
        for (int i = 0, arrLength = tmp.size(); i < arrLength/2; i++) {
            if (!tmp.get(i).equals(tmp.get(arrLength-1-i))){
                if(arrLength - 1 > digit){
                    tmp.remove(0);
                    return getPalindrome(tmp, digit);
                }else{
                    return null;
                }
            }
        }
        return tmp;
    }

    public boolean isPalindrome(List<Character> arr){
        boolean b = true;
        for (int i = 0, arrLength = arr.size(); i < arrLength/2; i++) {
            Character ch = arr.get(i);
            if (!ch.equals(arr.get(arrLength-1-i))){
                b = false;
                break;
            }
        }
        return b;
    }

    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "ab";
        String sa = "aa";
        String s3 = "aba";
        String s4 = "abab";
        String s5 = "abbdabbd";
        String s6 = "abcdcba";
        String s7 = "esbtzjaaijqkgmtaajpsdspfiqtvxsgfvijpxrvxgfumsuprzlyvhclgkhccmcnquukivlpnjlfteljvykbddtrpmxzcrdqinsnlsteonhcegtkoszzonkwjevlasgjlcquzuhdmmkhfniozhuphcfkeobturbuoefhmtgcvhlsezvkpgfebbdbhiuwdcftenihseorykdguoqotqyscwymtjejpdzqepjkadtftzwebxwyuqwyeegwxhroaaymusddwnjkvsvrwwsmolmidoybsotaqufhepinkkxicvzrgbgsarmizugbvtzfxghkhthzpuetufqvigmyhmlsgfaaqmmlblxbqxpluhaawqkdluwfirfngbhdkjjyfsxglsnakskcbsyafqpwmwmoxjwlhjduayqyzmpkmrjhbqyhongfdxmuwaqgjkcpatgbrqdllbzodnrifvhcfvgbixbwywanivsdjnbrgskyifgvksadvgzzzuogzcukskjxbohofdimkmyqypyuexypwnjlrfpbtkqyngvxjcwvngmilgwbpcsseoywetatfjijsbcekaixvqreelnlmdonknmxerjjhvmqiztsgjkijjtcyetuygqgsikxctvpxrqtuhxreidhwcklkkjayvqdzqqapgdqaapefzjfngdvjsiiivnkfimqkkucltgavwlakcfyhnpgmqxgfyjziliyqhugphhjtlllgtlcsibfdktzhcfuallqlonbsgyyvvyarvaxmchtyrtkgekkmhejwvsuumhcfcyncgeqtltfmhtlsfswaqpmwpjwgvksvazhwyrzwhyjjdbphhjcmurdcgtbvpkhbkpirhysrpcrntetacyfvgjivhaxgpqhbjahruuejdmaghoaquhiafjqaionbrjbjksxaezosxqmncejjptcksnoq";
        String s8 = "kztakrekvefgchersuoiuatzlmwynzjhdqqftjcqmntoyckqfawikkdrnfgbwtdpbkymvwoumurjdzygyzsbmwzpcxcdmmpwzmeibligwiiqbecxwyxigikoewwrczkanwwqukszsbjukzumzladrvjefpegyicsgctdvldetuegxwihdtitqrdmygdrsweahfrepdcudvyvrggbkthztxwicyzazjyeztytwiyybqdsczozvtegodacdokczfmwqfmyuixbeeqluqcqwxpyrkpfcdosttzooykpvdykfxulttvvwnzftndvhsvpgrgdzsvfxdtzztdiswgwxzvbpsjlizlfrlgvlnwbjwbujafjaedivvgnbgwcdbzbdbprqrflfhahsvlcekeyqueyxjfetkxpapbeejoxwxlgepmxzowldsmqllpzeymakcshfzkvyykwljeltutdmrhxcbzizihzinywggzjctzasvefcxmhnusdvlderconvaisaetcdldeveeemhugipfzbhrwidcjpfrumshbdofchpgcsbkvaexfmenpsuodatxjavoszcitjewflejjmsuvyuyrkumednsfkbgvbqxfphfqeqozcnabmtedffvzwbgbzbfydiyaevoqtfmzxaujdydtjftapkpdhnbmrylcibzuqqynvnsihmyxdcrfftkuoymzoxpnashaderlosnkxbhamkkxfhwjsyehkmblhppbyspmcwuoguptliashefdklokjpggfiixozsrlwmeksmzdcvipgkwxwynzsvxnqtchgwwadqybkguscfyrbyxudzrxacoplmcqcsmkraimfwbauvytkxdnglwfuvehpxd";
        String s9 = "miycvxmqggnmmcwlmizfojwrurwhwygwfykyefxbgveixykdebenzitqnciigfjgrzzbtgeazyrbiirmejhdwcgjzwqolrturjlqpsgunuqerqjevbheblmbvgxyedxshswsokbhzapfuojgyfhctlaifrisgzqlczageirnukgnmnbwogknyyuynwsuwbumdmoqwxprykmazghcpmkdcjduepjmjdxrhvixxbfvhybjdpvwjbarmbqypsylgtzyuiqkexgvirzylydrhrmuwpmfkvqllqvekyojoacvyrzjevaupypfrdguhukzuqojolvycgpjaendfetkgtojepelhcltorueawwjpltehbbjrvznxhahtuaeuairvuklctuhcyzomwrrznrcqmovanxmiyilefybkbveesrxkmqrqkowyrimuejqtikcjfhizsmumajbqglxrvevexnleflocxoqgoyrzgqflwiknntdcykuvdcpzlakljidclhkllftxpinpvbngtexngdtntunzgahuvfnqjedcafzouopiixw";
        long now = System.currentTimeMillis();
        String re = new _5_LongestPalindrome().longestPalindrome(s7);
        System.out.println(re);
        System.out.println(System.currentTimeMillis()- now);
    }
}
