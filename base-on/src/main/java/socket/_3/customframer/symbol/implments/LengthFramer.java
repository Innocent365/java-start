package socket._3.customframer.symbol.implments;

import socket._3.customframer.symbol.interfaces.Framer;

import java.io.*;

/**
 * 基于长度的成帧方法，适用于长度小于 65535 个字节的消息
 * @author hw
 * @version on 2020/4/15
 */
public class LengthFramer implements Framer {

    public static final int MAX_MESSAGE_LENGTH = 65535;
    public static final int BYTE_MASK = 0xff;
    public static final int SHORT_MASK = 0xffff;
    public static final int BYTE_SHIFT = 8;

    private DataInputStream in;

    public LengthFramer(InputStream in) {
        this.in = new DataInputStream(in);
    }

    @Override
    public void frameMsg(byte[] message, OutputStream out) throws IOException {
        if(message.length > MAX_MESSAGE_LENGTH){
            throw new IOException("Message too long");
        }
        //对字节流message添加成帧信息（右移）
        out.write((message.length >> BYTE_SHIFT) & BYTE_MASK);
        out.write(message.length & BYTE_MASK);
        out.write(message);
        out.flush();
    }

    @Override
    public byte[] nextMsg() throws IOException {
        int length;
        try {
            //该方法读取2个字节，将它们作为big-endian整数进行解释，并以int型整数返回它们的值
            //  big-endian 顺序:（从左边开始，由高位到低位发送）
            length = in.readUnsignedShort();
        }catch (EOFException e){
            return null;
        }

        byte[] msg = new byte[length];
        //该方法处阻塞等待，直到接收到足够的字节来填满指定的数组
        in.readFully(msg);

        return msg;
    }
}
