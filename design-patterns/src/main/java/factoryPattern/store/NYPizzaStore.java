package factoryPattern.store;

import factoryPattern.factory.ChicagoPizzaIngredientFactory;
import factoryPattern.factory.PizzaIngredientFactory;
import factoryPattern.pizza.CheesePizza;
import factoryPattern.pizza.ClamPizza;
import factoryPattern.pizza.NyStyleCheesePizza;
import factoryPattern.pizza.Pizza;

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
