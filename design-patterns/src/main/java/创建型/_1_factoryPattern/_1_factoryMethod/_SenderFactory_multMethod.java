package 创建型._1_factoryPattern._1_factoryMethod;

/**
 * 多个工厂方法模式，解决type拼写错误的问题，
 *  ----可以用 Enum 啊
 */
public class _SenderFactory_multMethod {

    public Sender produceMail(){
        return new MailSender();
    }

    public Sender produceSms(){
        return new SmsSender();
    }


    public static void main(String[] args) {
        _SenderFactory_multMethod factory = new _SenderFactory_multMethod();
        Sender sender = factory.produceMail();

        sender.send();
    }
}
