package 创建型._1_factoryPattern._2_abstractFactory.z老外的语境不太好理解.store;

import 创建型._1_factoryPattern._2_abstractFactory.z老外的语境不太好理解.factory.ChicagoPizzaIngredientFactory;
import 创建型._1_factoryPattern._2_abstractFactory.z老外的语境不太好理解.factory.PizzaIngredientFactory;
import 创建型._1_factoryPattern._2_abstractFactory.z老外的语境不太好理解.pizza.CheesePizza;
import 创建型._1_factoryPattern._2_abstractFactory.z老外的语境不太好理解.pizza.ClamPizza;
import 创建型._1_factoryPattern._2_abstractFactory.z老外的语境不太好理解.pizza.NyStyleCheesePizza;
import 创建型._1_factoryPattern._2_abstractFactory.z老外的语境不太好理解.pizza.Pizza;

public class NYPizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza() {
        return new NyStyleCheesePizza();
    }

    @Override
    public Pizza createPizza(String item) {
        Pizza pizza = null;
        PizzaIngredientFactory pizzaIngredientFactory = new ChicagoPizzaIngredientFactory();

        switch (item) {
            case "cheese":
                pizza = new CheesePizza(pizzaIngredientFactory);
                pizza.setName("New York Style Cheese Pizza");
                break;
            case "clam":
                pizza = new ClamPizza(pizzaIngredientFactory);
                pizza.setName("New york Style Veggie Pizza");
        }

        return pizza;
    }

}
