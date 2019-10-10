package dto;

import java.io.OutputStream;

/**
 * @author hw
 * @version on 2019/2/21
 */
public class Response {


    public Response(OutputStream os) {

    }

    public void writeFile(String fileName){
        System.out.println("输出文件给你");
    }
}
