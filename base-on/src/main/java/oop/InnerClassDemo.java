package oop;
//匿名内部类
public class InnerClassDemo  {

	class InnerClass {
		//内部类需要在外部类实例化后才能实例化，其语法看起来挺诡异的。
	}

	//TODO 完善内部类与匿名内部类
	public static void main(String[] args) {

		//new InnerClass();//编译错误， 不能再静态方法中直接new内部类，必须现有外部对象实例
		new InnerClassDemo().new InnerClass();//这样子可以有


		/*
		//编译错误，接口不能被实例化
		//Inter2 o = new Inter2();
		
		//1.创建了Inter2的一个子类，没有名字
		//2.为该子类创建了一个对象，名为o1
		//3.在大括号中{}，为那个子类的类体
		Inter2 o1 = new Inter2(){
		};
		
		//1.创建了Inter2的一个子类，没有名字
		//2.为该子类创建了一个对象，名为o2
		//3.在大括号中{}，为那个子类的类体
		Inter2 o2 = new Inter2(){	
		};
		
		
		Inter3 o3 = new Inter3(){
			public void show(){
				System.out.println("showshow");
			}
		};
		//Inter3的子类中包括了show()方法
		//o3为Inter3的子类的对象
		//用子类的对象o3去调了子类中的show()方法
		o3.show();
		*/


		//匿名内部类
		AnonymousClass test = new AnonymousClass() {
			@Override
			void doSth() {
				System.out.println("我是匿名内部类");
			}
		};
		FuncInterface test2 = new FuncInterface() {
			@Override
			public void doSth() {
				System.out.println("我是匿名内部类");
			}
		};

		
		final int num = 250; //num必须为final的

		Internel3 o4 = new Internel3(){
			public void show(){
				System.out.println(num);
			}
		};

		Internel2 o5 = new Internel2(){
		};
	}

	/**
	 * 普通类中也可以定义接口
	 */
	interface Climb{

	}
}

interface Internel3{
	void show();
}


interface Internel2{
}


abstract class AnonymousClass{
	abstract void doSth();
}

interface FuncInterface{
	abstract void doSth();
}