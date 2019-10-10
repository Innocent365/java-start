package decoratePattern;

import decoratePattern.beverage.Beverage;
import decoratePattern.beverage.DarkRoast;
import decoratePattern.decorator.Mocha;
import decoratePattern.decorator.Soy;
import decoratePattern.decorator.Whip;

/***
 * 运行时扩展，远比编译时期继承威力大
 *
 *      在不修改任何底层代码的情况下，给你的对象赋予新的职责
 *  设计原则：类应该对扩展开放，对修改关闭
 */
public class StarbuzzCoffee {


    /***
     *      * 1.装饰者和被装饰对象有相同的超类型
     *      * 2.你可以用一个或多个装饰者包装一个对象
     *      * 3.既然装饰者和被装饰对象有相同的超类型，所以在任何需要原始对象（被包装的）场合。可以用装饰过的对象代替它。
     *      * 4.装饰者可以在所委托被装饰者的行为之前 与（或） 之后，加上自己的行为，以达到特定目的。
     *      * 5.对象可以在任何时候被装饰，所以可以在运行时动态地、不限量地用你喜欢的装饰者来装饰对象。
     *      */

    public static void main(String[] args) {

//        Beverage beverage = new Espresso();
//        System.out.println(beverage.getDescription() + " $" + beverage.cost());
//
//        Beverage beverage2 = new DarkRoast();
//        beverage2 = new Mocha(beverage2);
//        beverage2 = new Mocha(beverage2);
//        beverage2 = new Whip(beverage2);
//        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());

        Beverage beverage3 = new DarkRoast(Beverage.Size.grande);
        beverage3 = new Soy(beverage3);
        beverage3 = new Mocha(beverage3);
        beverage3 = new Whip(beverage3);
        System.out.println(beverage3.getDescription() + " $" + beverage3.cost());

    }

}
