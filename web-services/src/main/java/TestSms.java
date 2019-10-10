/*注意加载xfire-all-1.2.6.jar*/

import org.codehaus.xfire.client.Client;

import java.net.MalformedURLException;
import java.net.URL;

/*用dom4j对返回的xml进行解析*/

public class TestSms {


        public static final String WebService_URL="http://*.*.*.*/services/Sms";    //.asmx?wsdl

        public static void main(String[] args) {
            Client client1 = null;
            try
            {
                client1 = new Client(new URL(WebService_URL));

                String sendbody = "<sendbody>" +
                        "<message>" +
                        "<orgaddr>50</orgaddr><mobile>13823549398</mobile><content>李老师</content><sendtime>20110428101715</sendtime><needreport>0</needreport>" +
                        "</message>" +
                        "……" +
                        "<message>" +
                        "<orgaddr></orgaddr><mobile>13777778888</mobile><content>杨老师</content><sendtime></sendtime>" +
                        "</message>" +
                        "<publicContent>,今天下午举行活动</publicContent>" +
                        "</sendbody>\n";

                String username = "";
                String password = "";
                String batch = "";

                //如果接口有方法名,且需要带参数,则在 invoke注明,参数以Object[]数组形式
                Object[] strResult1=null;
                strResult1= client1.invoke("InsertDownSms", new Object[]{username, password, batch, sendbody});
                System.out.println("调接口返回xml格式-->"+strResult1[0]);
            }
            catch (MalformedURLException e)
            {
                e.printStackTrace();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
}
