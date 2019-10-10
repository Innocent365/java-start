package proxyPattern.machine.state;


import proxyPattern.machine.GumballMachine;

public class SoldState implements State {

    GumballMachine stateMachine;

    public SoldState(GumballMachine stateMachine) {
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
            stateMachine.fillingBall();
        }
    }
}
