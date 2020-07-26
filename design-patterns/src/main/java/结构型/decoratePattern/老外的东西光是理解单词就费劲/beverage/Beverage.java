package 结构型.decoratePattern.老外的东西光是理解单词就费劲.beverage;

public abstract class Beverage {

    public enum Size {
        tall, grande, venti
    }

    Size size = Size.grande;
    String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public Size getSize() {
        return size;
    }

    public abstract double cost();
}
