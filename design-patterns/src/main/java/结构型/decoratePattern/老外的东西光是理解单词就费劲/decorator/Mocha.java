package 结构型.decoratePattern.老外的东西光是理解单词就费劲.decorator;


import 结构型.decoratePattern.老外的东西光是理解单词就费劲.beverage.Beverage;

public class Mocha extends CondimentDecorator {

    private Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public double cost() {
        return .20 + beverage.cost();
    }
}
