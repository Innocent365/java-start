package socket._3.customframer.symbol.vote;

/**
 * @author hw
 * @version on 2020/4/15
 */
public class VoteMsg {
    /**
     * true代表是查询请求，false表示该消息是投票请求
     */
    private boolean isInquiry;
    /**
     * 是否是返回消息
     */
    private boolean isResponse;
    /**
     * 候选人id：0~1000
     */
    private short candidateId;
    /**
     * 所查询的获选人获得的总票数
     */
    private int voteCount;

    public static final int MAX_CANDIDATE_ID = 1000;

    public VoteMsg(boolean isInquiry, boolean isResponse, short candidateId, int voteCount) {
        if(voteCount !=0 && !isResponse){
            throw new IllegalArgumentException("Request vote count must be zero");
        }
        if(candidateId <0 || candidateId > MAX_CANDIDATE_ID){
            throw new IllegalArgumentException("Bad Candidate ID: " + candidateId);
        }
        if(voteCount < 0){
            throw new IllegalArgumentException("Total must be >= zero");
        }

        this.isInquiry = isInquiry;
        this.isResponse = isResponse;
        this.candidateId = candidateId;
        this.voteCount = voteCount;
    }

    public boolean isInquiry() {
        return isInquiry;
    }

    public void setInquiry(boolean inquiry) {
        isInquiry = inquiry;
    }

    public boolean isResponse() {
        return isResponse;
    }

    public void setResponse(boolean response) {
        isResponse = response;
    }

    public short getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(short candidateId) {
        if(candidateId < 0 || candidateId > MAX_CANDIDATE_ID){
            throw new IllegalArgumentException("Bad Candidata ID: " + candidateId);
        }
        this.candidateId = candidateId;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int count) {
        if((count != 0 && !isResponse) || count < 0){
            throw new IllegalArgumentException("Bad vote count");
        }
        this.voteCount = count;
    }

    @Override
    public String toString() {
        String res = (isInquiry ? "Inquiry" : "vote") + " for candidate " + candidateId;
        if(isResponse){
            res = "response to " + res + "who now has " + voteCount + " vote(s)";
        }
        return res;
    }
}
