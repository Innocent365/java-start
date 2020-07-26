package collection;

import java.util.Comparator;

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
public class MyComparator
			implements Comparator<String> {
	/**
	 * 自定义的比较规则，字符串字符多的大
	 * 大于0时，前面的比后面的大
	 */
	@Override
	public int compare(String s1, String s2) {
		return s1.length()-s2.length();
	}

}
