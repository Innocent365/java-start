package 结构型.decoratePattern.老外的东西光是理解单词就费劲.beverage;


public class Decaf extends Beverage {

    public Decaf() {
        description = "Decaf";
    }

    @Override
    public double cost() {
        return 0.99f;
    }
}
