package strategyPattern;

import strategyPattern.behaviour.IQuackBehaviour;

public abstract class DuckCall implements IQuackBehaviour {
    @Override
    public void quack() {
        System.out.println("strategyPattern.DuckCall form strategyPattern.DuckCall device");
    }
}