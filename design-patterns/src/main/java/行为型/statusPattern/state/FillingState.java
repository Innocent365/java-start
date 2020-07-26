package 行为型.statusPattern.state;

import 行为型.statusPattern.StateMachine;

public class FillingState implements State {

    StateMachine stateMachine;

    public FillingState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    @Override
    public void insertQuarter() {
        stateMachine.setState(stateMachine.getNoQuarterState());
    }

    @Override
    public void ejectQuarter() {
        stateMachine.setState(stateMachine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        stateMachine.setState(stateMachine.getNoQuarterState());
    }

    @Override
    public void dispense() {
        stateMachine.setState(stateMachine.getNoQuarterState());
    }
}
