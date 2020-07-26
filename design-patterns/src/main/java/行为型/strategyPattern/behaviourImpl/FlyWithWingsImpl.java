package 行为型.strategyPattern.behaviourImpl;

import 行为型.strategyPattern.behaviour.IFlyBehaviour;

/**
 * 用翅膀飞
 */
public class FlyWithWingsImpl implements IFlyBehaviour {
    @Override
    public void fly() {
        System.out.println("I'm flying!");
    }
}
