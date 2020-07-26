package 行为型.chainOfResponsibilityPattern.approvalHandler;

/**
 * @author hw
 * @version on 2020/2/24
 */
public class GManagerLeaveHandler extends AbstractLeaveHandler{
    public GManagerLeaveHandler(String name) {
        this.handlerName = name;
    }

    @Override
    protected void handlerRequest(LeaveRequest request) {
        if(request.getLeaveDays() > this.MIDDLE && request.getLeaveDays() <= this.MAX){
            System.out.println("总经理：" + handlerName + "已经结束，流程结束");
            return;
        }

        if(this.nextHandler != null){
            this.nextHandler.handlerRequest(request);
        }else {
            System.out.println("审批拒绝！");
        }
    }
}
