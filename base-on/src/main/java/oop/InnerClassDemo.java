package oop;
//匿名内部类
public class InnerClassDemo {
	public static void main(String[] args) {
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