package _3.javaSE.collection;



import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * 数组转换为List集合:
 * 		由于Set集合不能存放重复元素，所以可能导致数组转换为Set集合后丢失元素，这样Set就不能完全表示原数组内容，故此数组不能转换为Set集合*
 *
 */
public class ArrayToListDemo {
	public static void main(String[] args) {
		String[] array = {"one","two","three"};
		
		/*
		 * Arrays.asList()
		 * 将给定的数组转换为List集合
		 */
		List<String> list = Arrays.asList(array);
		System.out.println(list);

		//转后的集合是只读的，不能add、remove新元素
		//list.add("four");


		/*
		 * 修改集合现有元素，原数组对应的元素也被改变了。
		 */
		list.set(0, "1");
		System.out.println(list);		
		for(String str : array){
			System.out.println(str);
		}
		
		/*
		 * 若想向集合中添加新元素。 只能创建一个新集合
		 * 所有的集合都支持一个构造方法，参数为 一个集合。这个构造方法的作用是:
		 * 		创建当前集合，并且当前集合中会包含给定集合中的所有元素。
		 */
		List<String> list1 = new ArrayList<String>(list);
		System.out.println(list1);
		list1.add("four");
		System.out.println(list1);
	}

	@Test//Collection提供了一个方法toArray()可以将当前集合转换为数组
	public void collection2Array() {
		Collection<String> c = new ArrayList<String>();
		c.add("one");
		c.add("two");
		c.add("three");

		//Object[] array = c.toArray();
		/*
		 * toArray方法会判断当前给定的数组是否可以存下集合中所有元素，
		 * 	可以就使用，不可以就创建一个数组。
		 */
		String[] array = c.toArray(new String[c.size()]);

		for(String s : array){
			System.out.println(s);
		}
	}
}








