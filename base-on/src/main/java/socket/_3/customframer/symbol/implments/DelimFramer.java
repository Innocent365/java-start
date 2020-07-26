package socket._3.customframer.symbol.implments;

import socket._3.customframer.symbol.interfaces.Framer;

import java.io.*;

/**
 * 基于定界符的成帧方法，定界符为换行符“\n”
 * @author hw
 * @version on 2020/4/15
 */
public class DelimFramer implements Framer {
    private InputStream in;

    //定界符为换行符“\n”
    private static final byte DELIMITER = '\n';

    public DelimFramer(InputStream in) {
        this.in = in;
    }

    @Override
    public void frameMsg(byte[] message, OutputStream out) throws IOException {
        for (byte b : message){
            if(b==DELIMITER){
                //如果已经在消息中检查到界定符，则抛出异常
                throw new IOException("Message contains delimiter");
            }
        }
        out.write(message);
        out.write(DELIMITER);
        out.flush();
    }

    @Override
    public byte[] nextMsg() throws IOException {
        ByteArrayOutputStream messageBuffer = new ByteArrayOutputStream();
        int nextByte;

        while ((nextByte = in.read()) != DELIMITER){
            //如果流已经结束还没有读取到定界符
            if (nextByte != -1) {
                messageBuffer.write(nextByte);
            } else {//读到了流的末尾
                if (messageBuffer.size() == 0) {//发现压根没读到数据
                    return null;
                } else {
                    //还没有定界符，非法消息
                    throw new EOFException("Non-empty message without delimiter");
                }
            }
        }
        return messageBuffer.toByteArray();
    }
}
