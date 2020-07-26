package 创建型._1_factoryPattern._2_abstractFactory.z老外的语境不太好理解.factory;

import 创建型._1_factoryPattern._2_abstractFactory.z老外的语境不太好理解.factory.ingredient.cheese.Cheese;
import 创建型._1_factoryPattern._2_abstractFactory.z老外的语境不太好理解.factory.ingredient.cheese.ReggianoiCheese;
import 创建型._1_factoryPattern._2_abstractFactory.z老外的语境不太好理解.factory.ingredient.clams.Clams;
import 创建型._1_factoryPattern._2_abstractFactory.z老外的语境不太好理解.factory.ingredient.clams.FreshClams;
import 创建型._1_factoryPattern._2_abstractFactory.z老外的语境不太好理解.factory.ingredient.dough.Dough;
import 创建型._1_factoryPattern._2_abstractFactory.z老外的语境不太好理解.factory.ingredient.dough.ThinCrustDough;
import 创建型._1_factoryPattern._2_abstractFactory.z老外的语境不太好理解.factory.ingredient.pepperoni.Pepperoni;
import 创建型._1_factoryPattern._2_abstractFactory.z老外的语境不太好理解.factory.ingredient.pepperoni.SlicedPepperoni;
import 创建型._1_factoryPattern._2_abstractFactory.z老外的语境不太好理解.factory.ingredient.sauce.MarinaraSauce;
import 创建型._1_factoryPattern._2_abstractFactory.z老外的语境不太好理解.factory.ingredient.sauce.Sauce;
import 创建型._1_factoryPattern._2_abstractFactory.z老外的语境不太好理解.factory.ingredient.veggies.*;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoiCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies veggies[] = {new Garlic(), new Onion(), new Mushroom(), new RedPepper()};
        return veggies;
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClam() {
        return new FreshClams();    //纽约使用新鲜的蛤蜊，芝加哥必须使用冷冻的
    }
}
