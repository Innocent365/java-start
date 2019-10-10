package strategyPattern.behaviourImpl;


import strategyPattern.behaviour.IFlyBehaviour;

public class FlyRocketPowered implements IFlyBehaviour {
    @Override
    public void fly() {
        System.out.println("I'm flying with a rocket!");
    }
}
