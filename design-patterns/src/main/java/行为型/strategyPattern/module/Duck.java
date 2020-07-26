package 行为型.strategyPattern.module;

import 行为型.strategyPattern.behaviour.IFlyBehaviour;
import 行为型.strategyPattern.behaviour.IQuackBehaviour;

/**
 * 为了实现 "行为"的可变性，将“行为”作为成员变量由用户实现时自行设置
 */
public abstract class Duck {

    char headColor;

    public abstract void display();

    public void swim() {
        System.out.println("All ducks float, even decoys!");
    }

    public void quack() {

    }

    protected IQuackBehaviour quickBehaviour;
    protected IFlyBehaviour flyBehaviour;

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
