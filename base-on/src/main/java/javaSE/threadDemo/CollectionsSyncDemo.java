package javaSE.threadDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * 使用Collections可以将给定的集合或Map转换为线程安全的
 *
 */
public class CollectionsSyncDemo {
	public static void main(String[] args) {
		List<String> list
			= new ArrayList<String>();
		
		list.add("one");
		list.add("two");
		list.add("three");
		//ArrayList与LinkedList都不是线程安全的
		System.out.println(list);
		//将给定的list集合转换为线程安全的
		list = Collections.synchronizedList(list);
		System.out.println(list);
	
		Set<String> set = new HashSet<String>(list);
		//HashSet也不是线程安全的
		System.out.println(set);
		/*
		 * 转换为一个线程安全的Set集合
		 */
		set = Collections.synchronizedSet(set);
		System.out.println(set);
		
		
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("语文", 90);
		map.put("数学", 98);
		map.put("英语", 95);
		//HashMap不是线程安全的
		System.out.println(map);
		//转换为线程安全的Map
		map = Collections.synchronizedMap(map);
		System.out.println(map);

	}
}








