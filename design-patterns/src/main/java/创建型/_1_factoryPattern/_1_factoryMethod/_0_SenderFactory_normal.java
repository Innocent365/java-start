package 创建型._1_factoryPattern._1_factoryMethod;

/**
 * 普通工厂模式
 */
public class _0_SenderFactory_normal {

    public Sender produce(String type) {
        switch (type) {
            case "mail":
                return new MailSender();
            case "sms":
                return new SmsSender();
            default:
                System.out.println("请输入正确的类型");
                return null;
        }
    }

    public static void main(String[] args) {
        _0_SenderFactory_normal factory = new _0_SenderFactory_normal();
        Sender sender = factory.produce("sms");

        sender.send();
    }
}
