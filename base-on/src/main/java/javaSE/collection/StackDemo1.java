package javaSE.collection;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 栈：存储一组元素，存取必须遵循先进后出原则
 * 通常用来完成具有后退功能操作的地方。
 * 
 * @author Administrator
 *
 */
public class StackDemo1 {
	public static void main(String[] args) {
		Deque<String> stack = new LinkedList<String>();
		/*
		 * void push(E e)
		 * 入栈操作
		 * 向栈中添加一个元素
		 */
		stack.push("one");
		stack.push("two");
		stack.push("three");
		stack.push("four");
		
		System.out.println(stack);
		/*
		 * 将栈顶元素获取
		 * 出栈操作
		 * E pop()
		 */
		String str = stack.pop();
		System.out.println(str);
		System.out.println(stack);
		
		/*
		 * E peek()
		 * 仅引用栈顶元素，不做出栈操作
		 */
		str = stack.peek();
		System.out.println(str);
		System.out.println(stack);
		
		/*
		 * 遍历栈也是一次性的。
		 */
		while(stack.size()>0){
			str = stack.pop();
			System.out.println(str);
		}
		System.out.println(stack);
		
	}
}







