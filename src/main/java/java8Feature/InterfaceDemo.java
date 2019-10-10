package java8Feature;

import java.util.function.Supplier;

/**
 * 接口中允许提供默认方法
 */
public interface InterfaceDemo {
    void doSomthing();

    //在Java中接口只能作为声明但不能提供任何实现。但默认方法打破了这一原则：在接口中可以为default标记的方法提供实现，如下：
    default void doDefaultSomthing(){       //（如果有必要的话，可以覆盖这个默认实现）

    }


    //接口可以声明（并且可以提供实现）静态方法
    static InterfaceDemo create(Supplier<InterfaceDemo> supplier ) {
        return supplier.get();
    }



}
