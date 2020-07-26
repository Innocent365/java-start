package 创建型._2_builderPattern;

/**
 * @author hw
 * @version on 2020/6/22
 */
public class TestBuilder {
    public static void main(String[] args) {
        Builder builder = new Builder();
        builder.produceMailSender(10);
    }
}
