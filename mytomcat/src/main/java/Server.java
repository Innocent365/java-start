import dto.Request;
import dto.Response;
import org.dom4j.DocumentException;
import servlet.LoginServlet;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Map;

/**
 * @author hw
 * @version on 2019/2/21
 */
public class Server {

    //计数器
    private static int count = 0;

    private static Map<String, String> handleMaps;


    public static void main(String[] args) {
        ServerSocket ss = null;
        Socket socket = null;

        try {
            ss = new ServerSocket(9090);
            System.out.println("服务器已经初始化，等待客户端连接中…………");

            while (true){
                socket = ss.accept();
                count ++ ;
                System.out.println("第"+count+"次连接服务器");

                //获取输入流，输入流里有响应请求信息
                Request request = new Request(socket.getInputStream());

                Response response = new Response(socket.getOutputStream());

                //业务逻辑
                String uri = request.getUri();
                //静态资源请求
                if (isStatic(uri)){
                    response.writeFile(uri.substring(1));
                }else if(uri.endsWith(".action")){
                    handleMaps = configUtils.getClassName("_6/spring/mytomcat/WEB-INF/web.xml");

                    LoginServlet servlet = null;
                    if (uri.endsWith("login.action")){
                        servlet = new LoginServlet();
                    }
                    try{
                        servlet.service(request, response);
                    }catch (Exception ex){
                        ex.printStackTrace();
                    }
                }

                //============发送服务返回信息=============
                OutputStream os = socket.getOutputStream();
                String html = "<html><head><title>元宵节快乐</title></head><body>" + new Date() +"<br/>服务器回复：多吃汤圆</body></html>";
                os.write(html.getBytes());
                os.flush();
                os.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    private static boolean isStatic(String uri){
        if(uri.endsWith(".action")){
            return false;
        }
        return true;
    }
}
