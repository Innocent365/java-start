package decoratePattern.beverage;

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
