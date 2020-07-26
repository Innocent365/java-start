package 行为型.statusPattern.state;

import 行为型.statusPattern.StateMachine;

import java.util.Random;

public class HasQuarterState implements State {

    Random randomWinner = new Random(System.currentTimeMillis());
    StateMachine stateMachine;

    public HasQuarterState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("您已经投过币了！");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("稍等，这就退给您！");
        stateMachine.setState(stateMachine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("稍等，正在准备糖果……");
        int winner = randomWinner.nextInt(10);
        if (winner == 0 && stateMachine.getCount() > 1) {
            stateMachine.setState(stateMachine.getWinnerState());
        } else {
            stateMachine.setState(stateMachine.getSoldState());
        }
    }

    @Override
    public void dispense() {
        System.out.println("正在发放糖果");
    }
}
