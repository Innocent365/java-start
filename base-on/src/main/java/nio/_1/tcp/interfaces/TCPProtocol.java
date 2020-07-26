package nio._1.tcp.interfaces;

import java.io.IOException;
import java.nio.channels.SelectionKey;

/**
 * 定义了通用TCPSelectorServer类与特定协议之间的接口，
 * 它把与具体协议相关的处理各种IO操作分离了出来，以使不同的协议都能方便的使用
 * @author hw
 * @version on 2020/4/16
 */
public interface TCPProtocol {

    void handleAccept(SelectionKey key) throws IOException;

    void handleRead(SelectionKey key) throws IOException;

    void handleWrite(SelectionKey key) throws IOException;
}
