package 行为型.strategyPattern.behaviourImpl;

import 行为型.strategyPattern.behaviour.IQuackBehaviour;

public class QuackImpl implements IQuackBehaviour {
    @Override
    public void quack() {
        System.out.println("Quack");
    }
}
