package statusPattern;

import statusPattern.state.*;

public class StateMachine {

    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;
    State winnerState;
    State fillingState;

    State state = soldOutState;
    int count = 0;


    public StateMachine(int numberGumballs) {
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);
        fillingState = new FillingState(this);
        this.count = numberGumballs;
        if (numberGumballs > 0) {
            state = noQuarterState;
        }
    }

    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    public void releaseBall() {
        System.out.println("糖果正在出仓...");
        if (count != 0) {
            count--;
        }
    }

    public void fillingBall() {
        System.out.println("糖果已售空，正在装填，请稍等...");
        if (count <= 0) {
            count = 6;
        }
    }


    public void setState(State state) {
        this.state = state;
    }


    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getWinnerState() {
        return winnerState;
    }

    public State getFillingState() {
        return fillingState;
    }


    public int getCount() {
        return count;
    }


    @Override
    public String toString() {
        return "StateMachine{" +
                "state=" + state +
                ", count=" + count +
                '}';
    }
}


