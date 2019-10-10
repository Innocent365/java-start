package factoryPattern.factory;

import factoryPattern.factory.ingredient.cheese.Cheese;
import factoryPattern.factory.ingredient.cheese.ReggianoiCheese;
import factoryPattern.factory.ingredient.clams.Clams;
import factoryPattern.factory.ingredient.clams.RefrigerantClams;
import factoryPattern.factory.ingredient.dough.Dough;
import factoryPattern.factory.ingredient.dough.ThinCrustDough;
import factoryPattern.factory.ingredient.pepperoni.Pepperoni;
import factoryPattern.factory.ingredient.pepperoni.SlicedPepperoni;
import factoryPattern.factory.ingredient.sauce.MarinaraSauce;
import factoryPattern.factory.ingredient.sauce.Sauce;
import factoryPattern.factory.ingredient.veggies.Garlic;
import factoryPattern.factory.ingredient.veggies.Mushroom;
import factoryPattern.factory.ingredient.veggies.Veggies;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {
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
        Veggies[] veggies = {new Garlic(), new Mushroom()};
        return veggies;
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClam() {
        return new RefrigerantClams();
    }
}
