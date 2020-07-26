package 创建型._1_factoryPattern._2_abstractFactory.z老外的语境不太好理解.factory;

import 创建型._1_factoryPattern._2_abstractFactory.z老外的语境不太好理解.factory.ingredient.cheese.Cheese;
import 创建型._1_factoryPattern._2_abstractFactory.z老外的语境不太好理解.factory.ingredient.clams.Clams;
import 创建型._1_factoryPattern._2_abstractFactory.z老外的语境不太好理解.factory.ingredient.dough.Dough;
import 创建型._1_factoryPattern._2_abstractFactory.z老外的语境不太好理解.factory.ingredient.pepperoni.Pepperoni;
import 创建型._1_factoryPattern._2_abstractFactory.z老外的语境不太好理解.factory.ingredient.sauce.Sauce;
import 创建型._1_factoryPattern._2_abstractFactory.z老外的语境不太好理解.factory.ingredient.veggies.Veggies;

public interface PizzaIngredientFactory {

    public Dough createDough();

    public Sauce createSauce();

    public Cheese createCheese();

    public Veggies[] createVeggies();

    public Pepperoni createPepperoni();

    public Clams createClam();


}
