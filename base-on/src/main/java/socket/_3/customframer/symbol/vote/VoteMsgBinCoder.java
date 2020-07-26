package socket._3.customframer.symbol.vote;

import socket._3.customframer.symbol.vote.interfaces.VoteMsgCoder;

import java.io.*;

/**
 * @author hw
 * @version on 2020/4/15
 */
public class VoteMsgBinCoder implements VoteMsgCoder {

    public static final int MIN_WIRE_LENGTH = 4;
    public static final int MAX_WIRE_LENGTH = 16;
    public static final int MAGIC = 0x5400;
    public static final int MAGIC_MASK = 0xfc00;
    public static final int MAGIC_SHIFT = 8;
    public static final int RESPONSE_FLAG = 0x0200;
    public static final int INQUIRE_FLAG = 0x0100;

    @Override
    public byte[] toWrite(VoteMsg msg) throws IOException {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(byteStream);

        short magicAndFlags = MAGIC;
        if (msg.isInquiry()) {
            magicAndFlags |= INQUIRE_FLAG;
        }
        if (msg.isResponse()) {
            magicAndFlags |= RESPONSE_FLAG;
        }
        out.writeShort(magicAndFlags);

        out.writeShort(msg.getCandidateId());
        if (msg.isResponse()) {
            out.writeInt(msg.getCandidateId());
        }
        out.flush();
        byte[] data = byteStream.toByteArray();
        return data;
    }

    @Override
    public VoteMsg fromWire(byte[] input) throws IOException {
        if (input.length < MIN_WIRE_LENGTH) {
            throw new IOException("Runt message");
        }

        ByteArrayInputStream byteInput = new ByteArrayInputStream(input);
        DataInputStream in = new DataInputStream(byteInput);
        int magic = in.readShort();
        if((magic & MAGIC_MASK) != MAGIC){
            throw new IOException("Bad Magic #: " + ((magic & MAGIC_MASK >> MAGIC_SHIFT)));
        }
        boolean resp = ((magic & RESPONSE_FLAG) != 0);
        boolean inq = ((magic & INQUIRE_FLAG) != 0);
        short candidateId = in.readShort();
        if (candidateId < 0 || candidateId > 1000) {
            throw new IOException("Bad candidate ID: " + candidateId);
        }
        int count = 0;
        if (resp) {
            count = in.readInt();
            if (count < 0) {
                throw new IOException("Bad vote count: " + count);
            }
        }
        return new VoteMsg(resp, inq, candidateId, count);
    }
}
/*
 *二进制格式使用固定大小的消息，每条消息由一个特殊字节开始，
 * 该字节的最高六位为一个”魔术值“010101，该字节的最低两位对两个布尔值进行了编码，消息的第二个字节总是 0，
 * 第三、四个字节包含了 candidateID 值，只有响应消息的最后 8 个字节才包含了选票总数信息。
 *
 * 字节序列格式如下图所示：
 *
 * 11111
 *  0  1  2  3  4  5  6  7  8  9  0  1  2  3  4  5
 * +--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
 * |    Magic    |Flags|           ZERO            |
 * +--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
 * |                CandidateID                    |
 * +--+--+--+--t--+--+--+--+--+--+--+--+--+--+--+--+
 * |                                               |
 * |        Vote Count （only in response）         |
 * |                                               |
 * +--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
 */
