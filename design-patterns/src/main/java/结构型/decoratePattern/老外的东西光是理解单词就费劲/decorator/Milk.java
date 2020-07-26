package 结构型.decoratePattern.老外的东西光是理解单词就费劲.decorator;


import 结构型.decoratePattern.老外的东西光是理解单词就费劲.beverage.Beverage;

public class Milk extends CondimentDecorator {

    private Beverage beverage;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }

    @Override
    public double cost() {
        return 0.77 + beverage.cost();
    }
}
