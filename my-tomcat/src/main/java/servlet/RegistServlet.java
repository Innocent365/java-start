package servlet;


import dto.Request;
import dto.Response;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @author hw
 * @version on 2019/2/21
 */
public class RegistServlet extends HttpServlet {
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(Request servletRequest, Response servletResponse) throws ServletException, IOException {
        System.out.println("注册成功！");
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
