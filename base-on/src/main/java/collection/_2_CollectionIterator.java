package collection;



import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * 遍历集合：
 * 		集合提供了统一的遍历方式:迭代器模式集合提供了一个方法	Iterator iterator()
 * 该方法会获取一个可以遍历当前集合的迭代器实例。
 * 
 * 需要注意的是Iterator本身是一个接口，不同的集合提供了可以遍历自身的迭代器实现类。但是从该方法
 * 我们可以看出，我们无需记住具体迭代器名字，只需要将它看做是Iterator即可
 * 使用迭代器遍历集合遵循: 问取删,其中删除不是必须的
 *
 */
public class _2_CollectionIterator {
	public static void main(String[] args) {
		Collection c = new HashSet();
		c.add("one");
		c.add("#");
		c.add("two");
		c.add("#");
		c.add("three");
		c.add("#");
		c.add("four");
		
		System.out.println(c);
		
		/*
		 * 若想遍历集合，先获取迭代器
		 */
		//java.util.Iterator
		Iterator it = c.iterator();


		//boolean hasNext() 询问迭代器，集合是否还有元素可以遍历
		while(it.hasNext()){
			Object o = it.next();	//E next()通过迭代器从集合中取出元素
			String str = (String)o;
			//System.out.println(str);
			if("#".equals(str)){

				//c.remove(str);
				/*
				 * 需要注意，在使用迭代器遍历集合的过程中，不得使用集合的方法删除元素。
				 * 只能使用迭代器提供的方法删除。该方法会删除通过next方法获取的元素。
				 */
				it.remove();				
			}
		}
		System.out.println(c);
	}

	@Test//泛型用来声明集合中的元素类型
	// 泛型的实际类型是Object，只是告知编译器应当把它当做什么类型而已。
	public void testGeneric() {
		Collection<String> c = new ArrayList<String>();
		c.add("one");
		c.add("two");
		c.add("three");
		//迭代器的泛型类型应当与其遍历的集合一致
		Iterator<String> it = c.iterator();
		while(it.hasNext()){
			String str = it.next();
			System.out.println(str);
		}

		/** 新循环是编译器认可的，不是虚拟机
		 * 编译器在编译源程序时，会将使用新循环遍历集合的方式改为使用迭代器。所以在新循环内部不能通过集合的方法删除集合元素。 */
		for(String str : c){
			System.out.println(str);
		}
	}
}













