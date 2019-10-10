package strategyPattern;

import strategyPattern.behaviourImpl.FlyWithWingsImpl;
import strategyPattern.behaviourImpl.QuackImpl;

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
