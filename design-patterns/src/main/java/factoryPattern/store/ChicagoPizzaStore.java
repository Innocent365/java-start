package factoryPattern.store;


import factoryPattern.factory.ChicagoPizzaIngredientFactory;
import factoryPattern.factory.PizzaIngredientFactory;
import factoryPattern.pizza.CheesePizza;
import factoryPattern.pizza.ChicagoStyleCheesePizza;
import factoryPattern.pizza.ClamPizza;
import factoryPattern.pizza.Pizza;

public class ChicagoPizzaStore extends PizzaStore {

    @Override
    public Pizza createPizza() {
        return new ChicagoStyleCheesePizza();
    }

    @Override
    public Pizza createPizza(String item) {
        Pizza pizza = null;
        PizzaIngredientFactory pizzaIngredientFactory = new ChicagoPizzaIngredientFactory();

        switch (item) {
            case "cheese":
                pizza = new CheesePizza(pizzaIngredientFactory);
                pizza.setName("Chicago Style Cheese Pizza");
                break;
            case "clam":
                pizza = new ClamPizza(pizzaIngredientFactory);
                pizza.setName("Chicago Style Veggie Pizza");
        }

        return pizza;
    }
}
