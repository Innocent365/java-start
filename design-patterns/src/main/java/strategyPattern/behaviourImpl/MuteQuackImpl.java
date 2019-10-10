package strategyPattern.behaviourImpl;

import strategyPattern.behaviour.IQuackBehaviour;

public class MuteQuackImpl implements IQuackBehaviour {

    @Override
    public void quack() {
        System.out.println("<< Silence >>");
    }
}
