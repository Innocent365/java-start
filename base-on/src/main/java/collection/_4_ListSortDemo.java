package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 排序字符串
 * @author Administrator
 *
 */
public class _4_ListSortDemo {
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
		//Comparator<String> com = new MyComparator();
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
