package decoratePattern.decorator;


import decoratePattern.beverage.Beverage;

public abstract class CondimentDecorator extends Beverage {

    public abstract String getDescription();
}
