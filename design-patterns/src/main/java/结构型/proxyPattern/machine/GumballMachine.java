package 结构型.proxyPattern.machine;


import 结构型.proxyPattern.machine.state.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GumballMachine extends UnicastRemoteObject implements GumballMachineRemote {

    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;
    State winnerState;

    private State state = soldOutState;
    private int count = 0;
    private String location;

    public GumballMachine(String location, int numberGumballs) throws RemoteException {
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);
        this.count = numberGumballs;
        this.location = location;

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


    public void setState(State state) {
        this.state = state;
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

    public int getCount() {
        return count;
    }

    public State getWinnerState() {
        return winnerState;
    }

    public String getLocation() {
        return location;
    }

    public State getState() {
        return state;
    }

    @Override
    public String toString() {
        return "StateMachine{" +
                "state=" + state +
                ", count=" + count +
                '}';
    }
}
