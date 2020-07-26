package dto;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author hw
 * @version on 2019/2/21
 */
public class Request  {

    private String uri;

    //解析请求得到uri，请求资源
    public Request(InputStream is) throws IOException {
        byte[] buff = new byte[1024];
        int len = is.read(buff);//读取buff放到请求字节数组里面
        if(len > 0){
            String msg = new String(buff, 0, len);
            System.out.println("----" + msg + "----");
        }else{
            System.out.println("bad Request");
        }
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
