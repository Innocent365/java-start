package collection;



import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Dueue双端队列，用于存数一组元素，具有先进先出或后进先出的特点
 * 支持所有元素在头部和尾部进行插入、删除、获取
 * @author Administrator
 *
 */
public class _6_DueueDemo {
	public static void main(String[] args) {

		Deque<String> deque = new LinkedList<String>(Arrays.asList("one", "two"));
		/*
		 * 入栈方法:
		 * boolean push(E e)
		 * 向栈头追加新元素
		 */
		deque.push("three");//[three, one, two]
		System.out.println(deque);
		
		/*
		 * E pop()
		 * 从栈头获取元素
		 */
		String str = deque.pop();//three
		System.out.println(str);
		System.out.println(deque);//[one, two]
		
		/*
		 * E peek()
		 * 同样可以获取队首元素，但是不会做出队
		 * 操作。
		 */
		str = deque.peek();//one
		System.out.println(str);
		System.out.println(deque);//[one, two]
		
		System.out.println("size:"+deque.size());
	}

	@Test//队列的遍历是一次性的
	public void testIterator() {
		Deque<String> queue = new LinkedList<String>();

		queue.push("one");
		queue.push("two");
		queue.push("three");
		queue.push("four");
		System.out.println(queue);
		for(int i=queue.size();i>0;i--){
//		while(queue.size()>0){
			String str = queue.pop();
			System.out.println(str);
		}

		System.out.println(queue);
	}
}









