package 创建型._1_factoryPattern._2_abstractFactory.z老外的语境不太好理解.store;


import 创建型._1_factoryPattern._2_abstractFactory.z老外的语境不太好理解.pizza.Pizza;

/**
 * 工厂方法模式（Factory Method Pattern）通过让子类决定该创建的对象是什么，来达到将对象创建的过程封装的目的
 */
public abstract class PizzaStore {


    //工厂模式的核心
    /***
     * ！！！！工厂方法用来处理对象的创建，并将这样的行为封装在子类中。实现超类代码与子类对象创建代码解耦*
     *      使一个类的实例化延迟到其子类。
     */

    /**
     * （抽象方法） :当然也可以不是抽象，定义一个默认的方法，这样即使没有子类，依然可以创建。
     */
    public abstract
    /** 必须返回一个产品，该产品会被自己定义的方法用到   */
    Pizza
    /** 可能需要参数，也可能不需要，来指定所要的产品*/
    createPizza();
    //将生产知识封装进各个具体创建者，这样的做法，也可以被视为一个框架


    public abstract Pizza createPizza(String item);


    //将收集到的不同羊圈起来，收羊毛
    public Pizza orderPizza() {
        Pizza pizza = createPizza();
        /**所制作出来的披萨一定定义了这些方法*/
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}
/***
 * 简单工厂与工厂模式的区别：
 *      简单工厂是书写的一种方法，将全部的工作（对象的创建）在一个地方处理完了。
 *      而工厂模式更像是一种框架，由子类去自行书写，决定要实现哪种类型具体的对象
 *
 * 依赖倒置原则(Dependency Inversion Principle):要依赖抽象，不要依赖具体类
 *      不能让高层组件依赖低层组件，而且，不管高层或低层组件，“两者都应该依赖与抽象”
 *      所谓高层组件：是由其他低层组件定义其行为的类
 *
 * 下面的指导方针，能避免在OO设计中违反依赖倒置原则：
 *    1.变量不可以持有具体类的引用
 *    2.不要让类派生自具体类
 *    3.不要覆盖基类中已实现的方法
 *          如果覆盖基类中已实现的方法，那么你的基类就不是一个真正适合被继承的抽象。基类中已实现的方法，应该由所有的子类共享
 *
 *  抽象工厂模式与工厂方法模式：
 *          抽象工厂模式：提供一个接口，用于创建相关或依赖对象的 "家族"，而不需要明确指定具体类。
 *              使用对象组合。
 *          工厂方法模式：定义了一个创建对象的接口，但由子类决定要实例化的类是哪一个。工厂方法让类把实例化推迟到子类。
 *              使用继承。
 *       抽象工厂经常会用到工厂方法模式来实现其具体的工厂
 *
 *       工厂方法模式使用继承，抽象工厂模式使用组合  One uses inheritance and one uses composition.One
 *       工厂方法模式产生一个产品，抽象工厂模式创建一系列产品   creates only one product and the other creates a family of products.One makes
 *          use of the concrete types the subclasses create and the other's methods are
 *  * purely implemented to create products.
 *  *
 *  要点：
 *      所有的工厂都是用来封装对象的创建
 *
 *
 *      抽象工厂是对简单工厂（工厂方法模式、工厂模式）中的工厂类进一步抽象成接口，解决了工厂方法中的硬编码问题，
 *      因为以后如有新增新的对象，只要再实现一个对应的工厂类，就完成了扩展。无需修改以前的代码。
 *
 *      普通工厂产出是一个产品（实例），抽象工厂产出是一个抽象（接口）。
 *      区别在于，若添加一个新的产品，前者是修改工厂，后者是创建新工厂（符合“闭合原则”）。
 *
 */

//简单工厂模式
interface Product{
    void use();
}

class ConcreateProductA implements Product{
    @Override
    public void use() {
        System.out.println("A.do");
    }
}
class ConcreateProductB implements Product{
    @Override
    public void use() {
        System.out.println("B.do");
    }
}

class SimpleFactory{
    static Product creatProduct(String s){
        if("A".equals(s)) return new ConcreateProductA();
        if("B".equals(s)) return new ConcreateProductB();
        return null;
    }

    public static void main(String[] args) {
        Product p = SimpleFactory.creatProduct("A");
        p.use();
    }
}



