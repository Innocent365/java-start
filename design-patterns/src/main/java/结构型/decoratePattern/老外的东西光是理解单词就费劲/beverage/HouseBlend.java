package 结构型.decoratePattern.老外的东西光是理解单词就费劲.beverage;


public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return .89;
    }
}
