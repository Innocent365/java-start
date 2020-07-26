package 创建型._1_factoryPattern._2_abstractFactory.z老外的语境不太好理解.pizza;


import 创建型._1_factoryPattern._2_abstractFactory.z老外的语境不太好理解.factory.PizzaIngredientFactory;

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
