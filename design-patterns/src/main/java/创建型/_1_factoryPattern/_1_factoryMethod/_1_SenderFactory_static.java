package 创建型._1_factoryPattern._1_factoryMethod;

/**
 * 静态工厂模式：
 *      不需要new工厂实例了
 */
public class _1_SenderFactory_static {

    public static Sender produce(String type) {
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
        Sender sender = _1_SenderFactory_static.produce("sms");
        sender.send();
    }
}
