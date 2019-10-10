package strategyPattern.behaviourImpl;

import strategyPattern.behaviour.IFlyBehaviour;

public class FlyNoWayImpl implements IFlyBehaviour {
    @Override
    public void fly() {
        System.out.println("I can't fly");
    }
}
