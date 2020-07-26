package 行为型.strategyPattern.behaviourImpl;

import 行为型.strategyPattern.behaviour.IFlyBehaviour;

public class FlyNoWayImpl implements IFlyBehaviour {
    @Override
    public void fly() {
        System.out.println("I can't fly");
    }
}
