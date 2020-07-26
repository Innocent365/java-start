package 创建型._1_factoryPattern._1_factoryMethod;


/**
 * @author hw
 * @version on 2020/6/22
 */
public class MailSender implements Sender {
    @Override
    public void send() {
        System.out.println("This is mail sender");
    }
}
