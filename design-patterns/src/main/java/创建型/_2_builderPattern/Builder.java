package 创建型._2_builderPattern;

import 创建型._1_factoryPattern._1_factoryMethod.MailSender;
import 创建型._1_factoryPattern._1_factoryMethod.Sender;
import 创建型._1_factoryPattern._1_factoryMethod.SmsSender;

import java.util.ArrayList;
import java.util.List;

/**
 * 建造者模式？？
 *      一个集合打包生产发货？
 *
 */
public class Builder {

    private List<Sender> list = new ArrayList<Sender>();

    public void produceMailSender(int count){
        for (int i = 0; i < count; i++) {
            list.add(new MailSender());
        }
    }

    public void produceSmsSender(int count){
        for (int i = 0; i < count; i++) {
            list.add(new SmsSender());
        }
    }

}
