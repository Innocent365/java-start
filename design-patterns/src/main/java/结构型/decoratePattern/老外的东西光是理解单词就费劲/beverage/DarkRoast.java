package 结构型.decoratePattern.老外的东西光是理解单词就费劲.beverage;

public class DarkRoast extends Beverage {

    public DarkRoast() {
        description = "DarkRoast";
    }

    public DarkRoast(Size size) {
        this();
        this.size = size;
    }

    @Override
    public double cost() {
        return 0.34;
    }
}
