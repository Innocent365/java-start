package other;

/**
 * 快速设置系统代理
 * @author hw
 * @version on 2019/4/26
 */
public class HttpProxyDemo {
    public static void main(String[] args) {
        System.getProperties().put("http.proxyHost", "someProxyURL");
        System.getProperties().put("http.proxyPort", "someProxyPort");
        System.getProperties().put("http.proxyUser", "someUserName");
        System.getProperties().put("http.proxyPassword", "somePassword");
    }
}
