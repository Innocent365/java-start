package 创建型._1_factoryPattern._2_abstractFactory;

import 创建型._1_factoryPattern._2_abstractFactory.interfaces.Sender;
import 创建型._1_factoryPattern._2_abstractFactory.factory.SmsFactory;
import 创建型._1_factoryPattern._2_abstractFactory.interfaces.Provider;

/**
 * @author hw
 * @version on 2020/6/22
 */
public class Runner {
    public static void main(String[] args) {
        Provider smsProvider = new SmsFactory();
        Sender sender = smsProvider.produce();
        sender.send();
    }
}
