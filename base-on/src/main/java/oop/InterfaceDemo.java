package oop;

/**
 * 接口中可以包含属性，默认final修饰
 */

public class InterfaceDemo {

	//protected int a;      //private、protected  not allowed here， 可以加 static 关键字，但多余
	int b = 2;  //

	public static void main(String[] args) {
		//Inter5 o1 = new Inter5(); //编译错误，接口不能被实例化
		Inter6 o2 = new Eoo(); //向上造型
		Inter5 o3 = new Eoo(); //向上造型
		//Inter4 o4 = new Eoo(); //编译错误
	}
}

//接口的继承
interface Inter5{
	void a();
}
interface Inter6 extends Inter5{
	void b();
}
class Eoo implements Inter6{
	public void b(){}
	public void a(){}
}

//又继承又实现，接口的多实现
interface Inter3{
	void a();
}
interface Inter4{
	void b();
}
abstract class Coo{
	abstract void c();
}
class Doo extends Coo implements Inter3,Inter4{
	public void a(){}
	public void b(){}
	void c(){}
}

//接口的实现
interface Inter2{
	void a();
	void b();
}
class Boo implements Inter2{
	public void a(){}
	public void b(){}
}




//接口的语法
interface Inter1{
	public static final int NUM = 5;
	public abstract void show();
	
	int NUM2 = 6; //默认public static final
	void say(); //默认public abstract
	
	//public void sayHi(){} //编译错误，只能常量和抽象方法
}











