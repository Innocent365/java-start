package socket._3.customframer.symbol.interfaces;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author hw
 * @version on 2020/4/15
 */
public interface Framer {
    /**
     * 用来添加成帧信息并将指定消息输出到指定流
     * @param message
     * @param out
     * @throws IOException
     */
    void frameMsg(byte[] message, OutputStream out) throws IOException;

    /**
     * 扫描指定的流，从中抽取出下一条消息。
     * @return
     * @throws IOException
     */
    byte[] nextMsg() throws IOException;
}
