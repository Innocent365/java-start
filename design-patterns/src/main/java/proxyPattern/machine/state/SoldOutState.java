package proxyPattern.machine.state;


import proxyPattern.machine.GumballMachine;

public class SoldOutState implements State {

    GumballMachine stateMachine;

    public SoldOutState(GumballMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("对不起，糖果已售罄，请选择退币！");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("无币可退！");
    }

    @Override
    public void turnCrank() {
        System.out.println("转动手柄也没用，糖果已售罄");
    }

    @Override
    public void dispense() {
        System.out.println("没用的，不会有糖果的");
    }
}
