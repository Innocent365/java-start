package servlet;

import dto.Request;
import dto.Response;

/**
 * @author hw
 * @version on 2019/2/21
 */
public abstract class HttpServlet {

    public abstract void service(Request request, Response response) throws Exception;
}
