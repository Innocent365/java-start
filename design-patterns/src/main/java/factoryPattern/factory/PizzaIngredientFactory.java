package factoryPattern.factory;

import factoryPattern.factory.ingredient.cheese.Cheese;
import factoryPattern.factory.ingredient.clams.Clams;
import factoryPattern.factory.ingredient.dough.Dough;
import factoryPattern.factory.ingredient.pepperoni.Pepperoni;
import factoryPattern.factory.ingredient.sauce.Sauce;
import factoryPattern.factory.ingredient.veggies.Veggies;

public interface PizzaIngredientFactory {

    public Dough createDough();

    public Sauce createSauce();

    public Cheese createCheese();

    public Veggies[] createVeggies();

    public Pepperoni createPepperoni();

    public Clams createClam();


}
