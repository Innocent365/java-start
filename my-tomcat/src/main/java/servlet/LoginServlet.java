package servlet;


import dto.Request;
import dto.Response;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author hw
 * @version on 2019/2/21
 */
public class LoginServlet extends HttpServlet {
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(Request request, Response response) throws ServletException, IOException {
        String url = request.getUri();
        String userName = url.substring(url.indexOf("userName="));
        String pwd = url.substring(url.indexOf("password="));


        System.out.println("登陆成功！");
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
