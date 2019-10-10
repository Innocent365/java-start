package factoryPattern.pizza;


import factoryPattern.factory.PizzaIngredientFactory;

public class NyStyleCheesePizza extends CheesePizza {
    public NyStyleCheesePizza(PizzaIngredientFactory pizzaIngredientFactory) {
        super(pizzaIngredientFactory);
    }

    public NyStyleCheesePizza() {
//        name = "纽约披萨";
//        dough = "薄饼";
//        sauce = "大蒜番茄酱";
//
//        toppings.add("意大利reggiano高级干酪");
    }


}
