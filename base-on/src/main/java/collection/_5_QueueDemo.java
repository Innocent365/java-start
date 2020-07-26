package collection;



import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Queue队列，用于存数一组元素，但是存取必须遵循先进先出原则。
 * @author Administrator
 *
 */
public class _5_QueueDemo {
	public static void main(String[] args) {
		/*
		 * 由于LinkedList的特性:可以存一组元素,存取效率高。
		 * 所以LinkedList也实现了队列接口。
		 */
		//java.util.Queue
		Queue<String> queue = new LinkedList<String>(Arrays.asList("one", "two"));
		/*
		 * 入队方法:
		 * boolean offer(E e)
		 * 向队列末尾追加新元素
		 */
		queue.offer("three");//"one", "two", "three"
		System.out.println(queue);
		
		/*
		 * E poll()
		 * 从队首获取元素
		 * 出队的操作
		 */
		String str = queue.poll();//"one"
		System.out.println(str);
		System.out.println(queue);//"two", "three"
		
		/*
		 * E peek()
		 * 同样可以获取队首元素，但是不会做出队
		 * 操作。
		 */
		str = queue.peek();//"one"
		System.out.println(str);
		System.out.println(queue);//"two", "three"
		
		System.out.println("size:"+queue.size());
	}

	@Test//队列的遍历是一次性的。 因为只有队首的元素出队，才能得到队列的第二个元素
	public void testIterator() {
		Queue<String> queue = new LinkedList<String>();

		queue.offer("one");
		queue.offer("two");
		queue.offer("three");
		queue.offer("four");
		System.out.println(queue);
		for(int i=queue.size();i>0;i--){
//		while(queue.size()>0){
			String str = queue.poll();
			System.out.println(str);
		}

		System.out.println(queue);
	}
}









