package collection.assit;
/**
 * 该类用于测试Collections排序自定义类型的元素
 * @author Administrator
 *
 */
public class Point implements Comparable<Point>{
	private int x;
	private int y;
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public String toString(){
		return "("+x+","+y+")";
	}
	/**
	 * 该方法用于定义Point两个实例间比较大小的
	 * 规则。
	 * 返回值是一个int,并不关心具体值是多少，只
	 * 关注取值范围:
	 * 若返回值>0:当前对象比参数对象大
	 * 若返回值<0:当前对象比参数对象小
	 * 若返回值=0:两个对象相等。
	 */
	public int compareTo(Point p) {
		/*
		 * 点到原点的距离长的就大
		 */
		int len = this.x*this.x+this.y*this.y;
		int plen = p.x*p.x+p.y*p.y;		
		return len-plen;
	}

}
