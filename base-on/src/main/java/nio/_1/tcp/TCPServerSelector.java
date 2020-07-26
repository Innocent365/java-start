package nio._1.tcp;

import nio._1.tcp.implments.EchoSelectorProtocol;
import nio._1.tcp.interfaces.TCPProtocol;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;

/**
 * @author hw
 * @version on 2020/4/16
 */
public class TCPServerSelector {

    //缓冲区的长度
    private static final int BUFSIZE = 256;

    //select方法等待信道准备好的最长时间
    private static final int TIMEOUT = 3000;

    public static void main(String[] args) throws IOException {
        args = new String[]{"8020", "8021", "8022", "8023", "8024", "8025",};
        Selector selector = Selector.open();
        for (String arg : args) {
            //实例化一个信道
            ServerSocketChannel listnChannel = ServerSocketChannel.open();
            //将该信道绑定到指定端口
            listnChannel.socket().bind(new InetSocketAddress(Integer.parseInt(arg)));
            //配置信道为非阻塞模式
            listnChannel.configureBlocking(false);
            listnChannel.register(selector, SelectionKey.OP_ACCEPT);
        }
        //创建一个实现了协议接口的对象
        TCPProtocol protocol = new EchoSelectorProtocol(BUFSIZE);
        while (true) {
            if (selector.select(TIMEOUT) == 0) {
                System.out.print(".");
                continue;
            }
            //获取准备好的信道所关连的Key集合的iterator实例
            Iterator<SelectionKey> keyIter = selector.selectedKeys().iterator();
            //循环取得集合中的每个键值
            while (keyIter.hasNext()) {
                SelectionKey key = keyIter.next();
                if (key.isAcceptable()) {
                    protocol.handleAccept(key);
                }

                if (key.isReadable()) {
                    protocol.handleRead(key);
                }

                if (key.isValid() && key.isWritable()) {
                    protocol.handleWrite(key);
                }

                keyIter.remove();
            }
        }
    }


}
