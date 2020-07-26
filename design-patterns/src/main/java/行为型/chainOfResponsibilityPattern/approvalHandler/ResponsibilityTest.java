package 行为型.chainOfResponsibilityPattern.approvalHandler;

/**
 * @author hw
 * @version on 2020/2/24
 */
public class ResponsibilityTest {
    public static void main(String[] args) {
        LeaveRequest request = new LeaveRequest();
        request.setLeaveDays(20);
        request.setName("小明");

        AbstractLeaveHandler directLeader = new DirectLeaderLeaveHandler("县令");
        DeptManagerLeaveHandler deptManager = new DeptManagerLeaveHandler("知府");
        GManagerLeaveHandler gManager = new GManagerLeaveHandler("总督");

        directLeader.setNextHandler(deptManager);
        deptManager.setNextHandler(gManager);

        directLeader.handlerRequest(request);
    }
}
