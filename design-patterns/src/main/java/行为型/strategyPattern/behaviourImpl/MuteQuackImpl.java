package 行为型.strategyPattern.behaviourImpl;

import 行为型.strategyPattern.behaviour.IQuackBehaviour;

/**
 * 哑巴
 */
public class MuteQuackImpl implements IQuackBehaviour {

    @Override
    public void quack() {
        System.out.println("<< Silence >>");
    }
}
