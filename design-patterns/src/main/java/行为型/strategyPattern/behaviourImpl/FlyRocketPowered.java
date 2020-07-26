package 行为型.strategyPattern.behaviourImpl;


import 行为型.strategyPattern.behaviour.IFlyBehaviour;

/**
 * 火箭推力
 */
public class FlyRocketPowered implements IFlyBehaviour {
    @Override
    public void fly() {
        System.out.println("I'm flying with a rocket!");
    }
}
