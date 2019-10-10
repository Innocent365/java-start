package strategyPattern.behaviourImpl;

import strategyPattern.behaviour.IFlyBehaviour;

public class FlyWithWingsImpl implements IFlyBehaviour {
    @Override
    public void fly() {
        System.out.println("I'm flying!");
    }
}
