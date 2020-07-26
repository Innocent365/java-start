package 创建型._1_factoryPattern._2_abstractFactory.factory;


import 创建型._1_factoryPattern._2_abstractFactory.interfaces.Provider;
import 创建型._1_factoryPattern._2_abstractFactory.interfaces.Sender;
import 创建型._1_factoryPattern._2_abstractFactory.sender.MailSender;

/**
 * @author hw
 * @version on 2020/6/22
 */
public class MailFactory implements Provider {
    @Override
    public Sender produce() {
        return new MailSender();
    }
}
