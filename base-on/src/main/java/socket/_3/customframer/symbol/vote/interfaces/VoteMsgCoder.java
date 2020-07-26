package socket._3.customframer.symbol.vote.interfaces;

import socket._3.customframer.symbol.vote.VoteMsg;

import java.io.IOException;

/**
 * @author hw
 * @version on 2020/4/15
 */
public interface VoteMsgCoder {
    /**
     * 方法用于根据一个特定的协议，将投票消息转换成一个字节序列
     * @param msg
     * @return
     * @throws IOException
     */
    byte[] toWrite(VoteMsg msg) throws IOException;

    /**
     * 根据相同的协议，对给定的字节序列进行解析，并根据信息的内容返回一个该消息类的实例
     * @param input
     * @return
     * @throws IOException
     */
    VoteMsg fromWire(byte[] input)throws IOException;
}
