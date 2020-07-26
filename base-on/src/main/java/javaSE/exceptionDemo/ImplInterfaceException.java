package javaSE.exceptionDemo;

import java.io.IOException;

class ThrowExceptionDemo implements ImplInterfaceException{

    /**
     *  某个类实现了一个接口      //（和继承了一个父类稍稍有点区别（继承类不能抛出父类方法无关异常））
     *      1.可以选择不抛异常，也可以选择抛出一个和父类（或接口）方法无关的异常
     *      2.抛出的异常类型不能比父类（或接口）抛出的异常类型更宽泛  不能 throws Exception
     *
     * @throws IOException
     */
    @Override
    public void doSth() throws IOException {}

    @Override
    public void doAnything() throws ClassNotFoundException {}

    @Override
    //public void doLittlething() throws Exception {}
    public void doLittlething() throws IndexOutOfBoundsException{}
}

public interface ImplInterfaceException{
    void doSth() throws IOException;

    void doAnything() throws ReflectiveOperationException;

    void doLittlething() throws NullPointerException;
}
