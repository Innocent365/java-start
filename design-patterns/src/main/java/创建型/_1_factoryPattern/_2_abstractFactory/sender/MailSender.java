package 创建型._1_factoryPattern._2_abstractFactory.sender;


import 创建型._1_factoryPattern._2_abstractFactory.interfaces.Sender;

/**
 * @author hw
 * @version on 2020/6/22
 */
public class MailSender implements Sender {
    @Override
    public void send() {
        System.out.println("This is mail sender!");
    }
}
