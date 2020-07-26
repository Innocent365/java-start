package 创建型._1_factoryPattern._2_abstractFactory.factory;

import 创建型._1_factoryPattern._2_abstractFactory.interfaces.Provider;
import 创建型._1_factoryPattern._2_abstractFactory.interfaces.Sender;
import 创建型._1_factoryPattern._2_abstractFactory.sender.SmsSender;

/**
 * @author hw
 * @version on 2020/6/22
 */
public class SmsFactory implements Provider {
    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
