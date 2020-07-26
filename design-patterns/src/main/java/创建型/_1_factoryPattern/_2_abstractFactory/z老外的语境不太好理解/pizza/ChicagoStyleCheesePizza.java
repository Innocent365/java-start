package 创建型._1_factoryPattern._2_abstractFactory.z老外的语境不太好理解.pizza;


import 创建型._1_factoryPattern._2_abstractFactory.z老外的语境不太好理解.factory.PizzaIngredientFactory;

public class ChicagoStyleCheesePizza extends CheesePizza {

    public ChicagoStyleCheesePizza(PizzaIngredientFactory pizzaIngredientFactory) {
        super(pizzaIngredientFactory);
    }

    public ChicagoStyleCheesePizza() {
//        name = "芝加哥风味";
//        dough = "厚饼";
//        sauce = "小番茄";
//
//        toppings.add("意大利白干酪");
    }

    //
    @Override
    public void prepare() {
        System.out.println("Preparing ChicagoStyle " + name);
        dough = pizzaIngredientFactory.createDough();
        sauce = pizzaIngredientFactory.createSauce();
        //cheese = pizzaIngredientFactory.createCheese();
        veggies = pizzaIngredientFactory.createVeggies();
    }

    //
    @Override
    public void cut() {//芝加哥奶酪披萨的不同做法
        System.out.println("将饼切成正方形");
    }

}
