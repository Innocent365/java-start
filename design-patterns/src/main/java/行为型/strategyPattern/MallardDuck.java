package 行为型.strategyPattern;

import 行为型.strategyPattern.behaviourImpl.FlyWithWingsImpl;
import 行为型.strategyPattern.behaviourImpl.QuackImpl;
import 行为型.strategyPattern.module.Duck;

/**
 * 野鸭
 */
public class MallardDuck extends Duck {

    public MallardDuck() {
        quickBehaviour = new QuackImpl();
        flyBehaviour = new FlyWithWingsImpl();
    }

    @Override
    public void display() {
        //外观是红头；
    }

}
