package factoryPattern;

import factoryPattern.store.ChicagoPizzaStore;
import factoryPattern.store.NYPizzaStore;
import factoryPattern.store.PizzaStore;

/**
 * 。
 */
public class PizzaTestDrive {
    public static void main(String[] args) {
        PizzaStore nyStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();

        nyStore.orderPizza();
        chicagoStore.orderPizza();
    }
}
