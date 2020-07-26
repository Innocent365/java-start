package leetCode;

/**
 * @author hw
 * @version on 2020/3/9
 */
public class _8_MyAtoi {
    public int myAtoi(String str) {
        str = str.trim();
        if(str.length()<1) return 0;

        char first = str.charAt(0);
        if(first>57) return 0;
        if(first < 48 && first != 43 && first != 45) return 0;

        StringBuilder sb = new StringBuilder();
        sb.append(first);
        for (int i = 1; i < str.length(); i++) {
            int x = str.charAt(i);
            if(x < 48 || x > 57){
                break;
            }
            sb.append((char) x);
        }

        if(sb.length()==1){
            if(sb.charAt(0) > 48 && sb.charAt(0) <58) {
                return Integer.valueOf(sb.toString());
            }else return 0;
        }

        try{
            return Integer.valueOf(sb.toString());
        }catch (NumberFormatException e){
            if(first == 45){
                return Integer.MIN_VALUE;
            }else{
                return Integer.MAX_VALUE;
            }
        }
    }

    public static void main(String[] args) {
        //for (int i = 0; i < 120; i++) {
        //    System.out.println(i + ": --> " + (char)i);
        //}

        //0-9: 48-57
        //+: 43
        //-: 45


        String s1 = "42";
        String s2 = "  -42";
        String s3 = "4193 with words";
        String s4 = "words and 987";
        String s6 = "+";
        String s7 = "-";
        String s8 = "4";
        String s9 = "+-2";


        System.out.println(new _8_MyAtoi().myAtoi(s1));
        System.out.println(new _8_MyAtoi().myAtoi(s2));
        System.out.println(new _8_MyAtoi().myAtoi(s3));
        System.out.println(new _8_MyAtoi().myAtoi(s4));
        System.out.println(new _8_MyAtoi().myAtoi("-91283472332"));
        System.out.println(new _8_MyAtoi().myAtoi(s6 ));
        System.out.println(new _8_MyAtoi().myAtoi(s7 ));
        System.out.println(new _8_MyAtoi().myAtoi(s8 ));
        System.out.println(new _8_MyAtoi().myAtoi(s9 ));
        System.out.println(new _8_MyAtoi().myAtoi("3.14159" ));
        System.out.println(new _8_MyAtoi().myAtoi("-3.14159" ));
        System.out.println(new _8_MyAtoi().myAtoi("2147483648" ));
    }
}
