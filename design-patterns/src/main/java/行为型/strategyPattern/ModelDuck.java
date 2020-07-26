package 行为型.strategyPattern;

import 行为型.strategyPattern.behaviourImpl.FlyNoWayImpl;
import 行为型.strategyPattern.behaviourImpl.QuackImpl;
import 行为型.strategyPattern.module.Duck;

/**
 * 塑料鸭
 */
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
