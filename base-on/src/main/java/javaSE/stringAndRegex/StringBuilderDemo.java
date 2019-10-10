package javaSE.stringAndRegex;


import org.junit.Test;

public class StringBuilderDemo {

    public static void main(String[] args) {
        String str = "上海自来水来自海上";
        StringBuilder sb = new StringBuilder(str);
        String rev = sb.reverse().toString();
        if(str.equals(rev)){
            System.out.println("是回文");
        }else{
            System.out.println("不是回文");
        }
    }

    @Test //手写回文判断
    public void test() {
        String str = "上海自来水水来自海上";
        boolean rev = true;
        for (int i = 0, len = str.length(); i < len; i++) {
            if(i==len/2) break;
            if(str.charAt(i) != str.charAt(len-1-i)){
                rev = false;
                break;
            }
        }

        if(rev){
            System.out.println("是回文");
        }else{
            System.out.println("不是回文");
        }
    }
}
