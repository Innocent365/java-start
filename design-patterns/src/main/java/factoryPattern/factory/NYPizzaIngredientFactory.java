package factoryPattern.factory;

import factoryPattern.factory.ingredient.cheese.Cheese;
import factoryPattern.factory.ingredient.cheese.ReggianoiCheese;
import factoryPattern.factory.ingredient.clams.Clams;
import factoryPattern.factory.ingredient.clams.FreshClams;
import factoryPattern.factory.ingredient.dough.Dough;
import factoryPattern.factory.ingredient.dough.ThinCrustDough;
import factoryPattern.factory.ingredient.pepperoni.Pepperoni;
import factoryPattern.factory.ingredient.pepperoni.SlicedPepperoni;
import factoryPattern.factory.ingredient.sauce.MarinaraSauce;
import factoryPattern.factory.ingredient.sauce.Sauce;
import factoryPattern.factory.ingredient.veggies.*;

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
