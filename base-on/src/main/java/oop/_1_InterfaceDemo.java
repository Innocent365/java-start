package oop;

/**
 * 接口中只能定义静态常量和抽象方法, 不能含有静态代码块以及静态方法
 * 		可以继承其他接口, 但不可以继承类(包括抽象类)
 */
public interface _1_InterfaceDemo {
	/**
	 * 接口的属性默认public static final修饰
	 */
	public static final int NUM = 5;
	int NUM2 = 6; //默认public static final
	//private int NUM3 = 6; //强加private、protected 会编译错误

	/**
	 * 方法默认public abstract
	 */
	public abstract void show();
	void say(); //

	//public void sayHi(){} //编译错误，只能常量和抽象方法


	/**
	 * 接口中可以定义接口，有点奇葩，有点扯淡
	 */
	interface Kill{

	}
}
