package oop.demo;
//static final常量演示
public class StaticFinalDemo {
	public static void main(String[] args) {
		
		//1.在方法区中加载Aoo.class
		//2.在方法区中存储静态变量a
		//3.去方法区中获取a的值0并输出
		System.out.println(Aoo.a);
		
		//与System.out.println(360)等价
		System.out.println(Aoo.NUM);
		
		//Aoo.NUM = 480; //编译错误，常量不能被修改
	}
}

class Aoo{
	public static int a; //静态变量
	 final static public  int NUM = 360; //常量
}