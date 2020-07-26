package 结构型.decoratePattern.老外的东西光是理解单词就费劲.beverage;


public class Espresso extends Beverage {

    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
