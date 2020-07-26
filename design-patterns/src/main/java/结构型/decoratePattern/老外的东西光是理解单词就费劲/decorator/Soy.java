package 结构型.decoratePattern.老外的东西光是理解单词就费劲.decorator;

import 结构型.decoratePattern.老外的东西光是理解单词就费劲.beverage.Beverage;

public class Soy extends CondimentDecorator {

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    private Beverage beverage;


    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    @Override
    public double cost() {
        double cost = 0.56 + beverage.cost();
        switch (beverage.getSize()) {
            case tall:
                return cost + 0.10;
            case grande:
                return cost + 0.15;
            case venti:
                return cost + 0.20;
        }
        return cost;
    }
}
