package collection;



import collection.assit.Point;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * List继承自Collection接口
 * List是可重复集，并且有序。
 * List的特点:可以根据下标操作元素，和数组很像。
 * 常用实现类:ArrayList,LinkedList
 * @author Administrator
 *
 * * List独有方法介绍2
 */
@SuppressWarnings("all")
public class _3_ListDemo {
	public static void main(String[] args) {
		//java.util.List
		List<String> list = new ArrayList<String>();
		//向集合添加元素
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");

		/*
		 * 插入操作
		 * void add(int index,E e) 将给定的元素添加到给定的位置上，原位置上及后续元素都顺序向后移动
		 */

		System.out.println(list);
		//[one,2,two,three]
		list.add(1,"2");
		System.out.println(list);

		/*
		 * E remove(int index)
		 * 删除当前集合中给定位置对应的元素，返回值为被删除的元素
		 */
		String old = list.remove(2);
		System.out.println("被删除的是:"+old);

		/*
		 * List提供了一组get,set方法可以根据下标操作元素
		 * 
		 * E get(int index)
		 * 获取当前集合中给定下标对应的元素
		 */
		System.out.println(list);
		//获取第二个元素
		String str = list.get(1);
		System.out.println(str);
		
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		
		/*
		 * E set(int index,E e)
		 * 将给定的元素设置到给定的位置上，返回值
		 * 为原位置上的元素。
		 * 替换元素操作。
		 */
		//[one,二,three,four]
		old = list.set(1, "二");
		System.out.println(list);
		System.out.println("被替换的是:"+old);
	}

	@Test//list列表操作
	public void test() {
		List<Integer> list= new ArrayList<Integer>();
		//向集合中添加数字0-9
		for(int i=0;i<10;i++){
			list.add(i);
		}
		System.out.println(list);

		/*
		 * 取当前list集合的子集
		 * 3-7
		 * List subList(int start,int end)
		 * 获取当前集合中指定范围内的元素并返回。
		 */
		List<Integer> subList
				= list.subList(3, 8);
		System.out.println(subList);
		/*
		 * 将子集中每个元素扩大10倍
		 */
		for(int i=0;i<subList.size();i++){
			int num = subList.get(i);
			num = num * 10;
			subList.set(i, num);
			//下边一句顶上边三句
			//subList.set(i, subList.get(i) * 10);
		}
		System.out.println(subList);
		/*
		 * 修改子集中的元素就是修改原集合的元素。
		 */
		System.out.println(list);


		/*
		 * 删除集合中2-8
		 */
		list.subList(2, 9).clear();
		System.out.println(list);
	}

	@Test
	public void testSortList() {
		List<Point> list = new ArrayList<Point>();
		list.add(new Point(1,2));
		list.add(new Point(6,5));
		list.add(new Point(2,2));
		System.out.println(list);

		/*
		 * sort方法排序的集合元素必须实现
		 * Comparable接口，才能进行比较大小，
		 * 从而进行自然排序。
		 */
		Collections.sort(list);
		System.out.println(list);
	}


	/**
	 * 一行代码初始化 list
	 */
	@Test
	public void getSimpleList(){
		Point point = new Point(1,2);
		List<Point> list1 =  Collections.singletonList(point);

		Point point1 = new Point(2,3);
		//List<Point> list = Arrays.asList(point, point1);慎用, 不能增删元素
		Point[] arr = new Point[]{point, point1};
		List<Point> list = new ArrayList<Point>(Arrays.asList(point, point1));
		//上面的写法，如果是基本类型，一定要转换为包装类

	}

	/**
	 * ArrayList 有些额外的方法，如果在创建 ArrayList 对象时，向上引用为 List， 这些方法就不能用了
	 * TODO
	 */
}







