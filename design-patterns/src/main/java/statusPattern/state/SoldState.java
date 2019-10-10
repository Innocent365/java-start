package statusPattern.state;

import statusPattern.StateMachine;

public class SoldState implements State {

    StateMachine stateMachine;

    public SoldState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("感谢您投币，请按下扳手");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("这是您的退币，请收好！");
    }

    @Override
    public void turnCrank() {
        System.out.println("正在出糖果，请稍等……");
    }

    @Override
    public void dispense() {
        stateMachine.releaseBall();
        if (stateMachine.getCount() > 0) {
            stateMachine.setState(stateMachine.getNoQuarterState());
        } else {
            System.out.println("你的糖果，请收好");
//            stateMachine.setState(stateMachine.getSoldOutState());
            stateMachine.setState(stateMachine.getFillingState());//如果把填充也算做一直状态，那么和售空状态有什么区别
        }
    }
}
