package 结构型.proxyPattern.machine.state;


import 结构型.proxyPattern.machine.GumballMachine;

public class WinnerState implements State {

    GumballMachine stateMachine;

    public WinnerState(GumballMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    @Override
    public void insertQuarter() {

    }

    @Override
    public void ejectQuarter() {

    }

    @Override
    public void turnCrank() {

    }

    @Override
    public void dispense() {
        System.out.println("恭喜你，两个糖果");
        stateMachine.releaseBall();
        if (stateMachine.getCount() == 0) {
            stateMachine.setState(stateMachine.getSoldOutState());
        } else {
            stateMachine.releaseBall();
            if (stateMachine.getCount() > 0) {
                stateMachine.setState(stateMachine.getNoQuarterState());
            } else {
                System.out.println("Oops, out of gumballs");
                stateMachine.setState(stateMachine.getSoldOutState());
            }
        }
    }
}
