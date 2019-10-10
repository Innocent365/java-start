package strategyPattern;

import strategyPattern.behaviour.IFlyBehaviour;
import strategyPattern.behaviour.IQuackBehaviour;

public abstract class Duck {

    char headColor;

    public abstract void display();

    public void swim() {
        System.out.println("All ducks float, even decoys!");
    }

    public void quack() {

    }

    IQuackBehaviour quickBehaviour;
    IFlyBehaviour flyBehaviour;

    public void performQuack() {
        quickBehaviour.quack();
    }

    public void performFly() {
        flyBehaviour.fly();
    }

    public void setFlyBehaviour(IFlyBehaviour flyBehaviour) {   //让实现类动态实现算法
        this.flyBehaviour = flyBehaviour;
    }

    public void setQuickBehaviour(IQuackBehaviour quickBehaviour) {
        this.quickBehaviour = quickBehaviour;
    }
}
