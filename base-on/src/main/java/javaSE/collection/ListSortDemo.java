package javaSE.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 排序字符串
 * @author Administrator
 *
 */
public class ListSortDemo {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("苍老师");
		list.add("范老师");
		list.add("小泽老师");		
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		
		/*
		 * 按照自定义的比较规则比较 
		 */
//		Comparator<String> com
//			= new MyComparator();
		/*
		 * 当我们需要实现一个接口，但是我们对这个
		 * 实现类的对象只用一次。那么就应当首先
		 * 考虑使用匿名内部类形式创建。
		 */
		Comparator<String> com
			= new Comparator<String>(){
				public int compare(String s1, String s2) {
					return s1.length()-s2.length();
				}
		 };
		
		Collections.sort(list, com);
		System.out.println(list);
		
	}
}
/**
 * 当我们使用的类已经实现了Comparable接口并且
 * 定义好了比较大小的规则，但是该规则不能满足我们
 * 对于排序的需求时。又或者我们使用的类没有实现
 * Comparable接口，但我们又不希望改动这个类，却
 * 需要对该类的实例进行排序时，我们都可以单独定义
 * 一个比较器，来完成对他们比较大小的规则进行定义，
 * 从而用来实现排序的需求。
 * @author Administrator
 *
 */
class MyComparator 
			implements Comparator<String>{
	/**
	 * 自定义的比较规则，字符串字符多的大
	 */
	public int compare(String s1, String s2) {
		
		return s1.length()-s2.length();
	}
	
} 












