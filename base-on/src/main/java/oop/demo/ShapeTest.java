package oop.demo;
//求一组图形中的最大面积
public class ShapeTest {
	public static void main(String[] args) {
		//Shape s = new Shape(); //编译错误，抽象类不能被实例化
		
		Shape[] shapes = new Shape[4];
		shapes[0] = new Square(1); //向上造型
		shapes[1] = new Square(2);
		shapes[2] = new Circle(1);
		shapes[3] = new Circle(2);
		
		maxArea(shapes);
		
	}
	
	public static void maxArea(Shape[] shapes){
		double max = shapes[0].area();
		int maxIndex = 0; //记录最大面积下标
		for(int i=1;i<shapes.length;i++){
			double area = shapes[i].area();
			if(area > max){
				max = area;
				maxIndex = i;
			}
		}
		System.out.println("最大面积为:"+max+",所在下标为:"+maxIndex);
	}
}

abstract class Shape{ //抽象类
	protected double c; //周长
	public abstract double area(); //抽象方法
}
class Square extends Shape{
	public Square(double c){
		this.c = c;
	}
	public double area(){ //重写抽象方法
		return 0.0625*c*c;
	}
}
class Circle extends Shape{
	public Circle(double c){
		this.c = c;
	}
	public double area(){ //重写抽象方法
		return 0.0796*c*c;
	}
}










