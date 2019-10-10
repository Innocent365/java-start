package strategyPattern;

import strategyPattern.behaviourImpl.FlyRocketPowered;

/**
 * 策略模式 定义了算法族，分别封装起来，让他们之间可以相互替换。
 * 此模式让算法的变化独立于使用算法的客户。
 */
public class MiniDuckSimulator {

    /**
     * 设计原则：
     * 1.找出应用中可能需要变化之处，把他们独立出来，封装！
     * （至于是用接口还是抽象类，或者实现类，功能类，就需要你好好掌握设计模式）*
     * <p>
     * 2.针对接口编程，而不是针对实现。
     * （以前是继承与父类或某个接口，并由自行实现而来，太依赖于“实现”）
     * <p>
     * 3.多用组合，少用继承（“有一个” 可能比 “是一个” 更好）
     */
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.performQuack();
        mallard.performFly();

        Duck model = new ModelDuck();
        model.performQuack();
        model.setFlyBehaviour(new FlyRocketPowered());
        model.performFly();
    }
}

//1.鸭子的行为在子类里不断的改变，并且让所有的子类都有这些行为是不恰当的
//2.Java 接口不具有实现代码，所以继承接口无法达到代码的复用。意味着无论何时要修改某个行为，必须得在每一个定义此行为的类中修改它

//大多数的模式和原则，都着眼于软件变化的主题, 都允许系统局部改变独立于其他部分