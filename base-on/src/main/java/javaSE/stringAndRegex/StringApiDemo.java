package javaSE.stringAndRegex;

/**
 * @author hw
 * @version on 2019/5/27
 */
public class StringApiDemo {
    public static void main(String[] args) {
        String token = "loanplatform-".concat("2Day(new Date()) + UUIDUtil.genRandomNumStr(6)");
        System.out.println(token);
    }
}
