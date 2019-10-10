package strategyPattern.behaviourImpl;

import strategyPattern.behaviour.IQuackBehaviour;

public class QuackImpl implements IQuackBehaviour {
    @Override
    public void quack() {
        System.out.println("Quack");
    }
}
