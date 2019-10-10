package javaSE.collection;



import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * java.util.Collection
 * 集合，用于存储一组元素。由于定义了维护数据结构
 * 的相关方法，所以使用起来比数组方便。 
 * @author Administrator
 *
 */
public class CollectionDemo {

	@Test
	public void testCollectionAPI() {

		Collection c = new ArrayList();

		boolean empty = c.isEmpty();	//判断当前集合是否不包含元素
		System.out.println("集合不含有元素:"+empty);

		 // int size() 返回当前集合的元素数量
		System.out.println("size:"+c.size());


		//boolean add(E e) 向当前集合中添加一个新元素，若添加成功返回true
		c.add("one");
		c.add("two");
		c.add("three");
		c.add("four");		
		System.out.println(c);
		
		System.out.println("size:" + c.size());
		System.out.println( "集合是否不含有元素:"+c.isEmpty());

		c.clear();	//清空集合元素
		System.out.println("size:"+c.size());
		System.out.println("集合是否不含有元素:"+c.isEmpty());
	}

	@Test
	public void testObj(){
		Collection c = new ArrayList();

		c.add(new Point(1,2));
		c.add(new Point(3,4));
		c.add(new Point(5,6));

		// 集合toString输出的格式: [元素1.toString(),元素2.toString()]
		System.out.println(c);

		/*
		 * boolean contains(E e) 判断当前集合是否包含给定的元素			//类似boolean containsAll(Collection c)
		 * 判断标准:  查看给定对象与集合中现有对象是否有 equals比较为true的，有则认为包含。
		 */
		Point p = new Point(1,2);
		boolean contains = c.contains(p);
		System.out.println("包含:"+contains);
	}
}









