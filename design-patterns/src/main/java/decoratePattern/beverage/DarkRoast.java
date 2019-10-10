package decoratePattern.beverage;

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
