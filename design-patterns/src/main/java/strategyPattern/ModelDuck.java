package strategyPattern;

import strategyPattern.behaviourImpl.FlyNoWayImpl;
import strategyPattern.behaviourImpl.QuackImpl;

public class ModelDuck extends Duck {
    public ModelDuck() {
        flyBehaviour = new FlyNoWayImpl();
        quickBehaviour = new QuackImpl();
    }

    @Override
    public void display() {
        System.out.println("I'm a model duck");
    }
}
