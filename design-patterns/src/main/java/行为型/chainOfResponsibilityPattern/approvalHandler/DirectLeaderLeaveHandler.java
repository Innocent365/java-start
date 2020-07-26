package 行为型.chainOfResponsibilityPattern.approvalHandler;

/**
 * @author hw
 * @version on 2020/2/24
 */
public class DirectLeaderLeaveHandler extends AbstractLeaveHandler {

    public DirectLeaderLeaveHandler(String name) {
        this.handlerName = name;
    }

    @Override
    protected void handlerRequest(LeaveRequest request) {
        if(request.getLeaveDays() <= this.MIN){
            System.out.println("直接主管：" + handlerName + ",已经处理，流程结束");
            return;
        }

        if(this.nextHandler != null){
            this.nextHandler.handlerRequest(request);
        }else {
            System.out.println("审批拒绝！");
        }
    }
}
