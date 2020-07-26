package 行为型.strategyPattern.behaviourImpl;


import 行为型.strategyPattern.behaviour.IQuackBehaviour;

/**
 * 叽叽叫
 */
public class SqueakImpl implements IQuackBehaviour {
    @Override
    public void quack() {
        System.out.println("Squeak");
    }
}
