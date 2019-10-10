package strategyPattern.behaviourImpl;


import strategyPattern.behaviour.IQuackBehaviour;

public class SqueakImpl implements IQuackBehaviour {
    @Override
    public void quack() {
        System.out.println("Squeak");
    }
}
