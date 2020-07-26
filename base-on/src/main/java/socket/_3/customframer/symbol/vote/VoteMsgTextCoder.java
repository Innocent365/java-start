package socket._3.customframer.symbol.vote;

import socket._3.customframer.symbol.vote.interfaces.VoteMsgCoder;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 文本模式（字符）对消息进行编码的程序，该协议指定使用 ASCII 字符集对文本进行编码
 * @author hw
 * @version on 2020/4/15
 */
public class VoteMsgTextCoder implements VoteMsgCoder {

    public static final String MAGIC = "Voting";
    public static final String VOTESTR = "v";
    public static final String INQSTR = "i";
    public static final String RESPONSESTR = "R";

    public static final String CHARSETNAME = "US-ASCII";
    public static final String DELIMSTR = " ";
    public static final int MAX_WIRE_LENGTH = 2000;

    @Override
    public byte[] toWrite(VoteMsg msg) throws IOException {
        String msgStr = MAGIC + DELIMSTR + (msg.isInquiry() ? INQSTR : VOTESTR)
                + DELIMSTR + (msg.isResponse() ? RESPONSESTR : "")
                + msg.getCandidateId() + DELIMSTR
                + msg.getVoteCount();
        byte[] data = msgStr.getBytes(CHARSETNAME);
        return data;
    }

    @Override
    public VoteMsg fromWire(byte[] msg) throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream(msg);
        Scanner scanner = new Scanner(new InputStreamReader(in, CHARSETNAME));

        boolean isInquiry;
        boolean isResponse;
        short candidateId;
        int voteCount;
        String token;

        try {
            token = scanner.next();
            if(!token.equals(MAGIC)){//首先检查”魔术字符串“
                throw new IOException("Bad magic string: " + token);
            }
            token = scanner.next();
            if (token.equals(VOTESTR)) {
                isInquiry = false;
            }else if (!token.equals(INQSTR)){
                throw new IOException("Bad vote/inq indicator: " + token);
            }else {
                isInquiry = true;
            }

            token = scanner.next();
            if (token.equals(RESPONSESTR)) {
                isResponse = true;
                token = scanner.next();
            }else {
                isResponse = false;
            }

            candidateId = Short.parseShort(token);
            if(isResponse){
                token = scanner.next();
                voteCount = Integer.parseInt(token);
            }else {
                voteCount = 0;
            }
        }catch (IOException ioe){
            throw new IOException("parse error...");
        }

        return new VoteMsg(isResponse, isInquiry, candidateId, voteCount);
    }
}
