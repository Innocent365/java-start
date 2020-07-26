package 创建型._1_factoryPattern._2_abstractFactory.z老外的语境不太好理解;

import 创建型._1_factoryPattern._2_abstractFactory.z老外的语境不太好理解.store.ChicagoPizzaStore;
import 创建型._1_factoryPattern._2_abstractFactory.z老外的语境不太好理解.store.NYPizzaStore;
import 创建型._1_factoryPattern._2_abstractFactory.z老外的语境不太好理解.store.PizzaStore;

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
