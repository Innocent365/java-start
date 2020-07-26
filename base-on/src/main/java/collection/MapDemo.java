package collection;



import org.junit.Test;

import java.util.*;

/**
 * http://cmsblogs.com/?p=176&vip=1
 *
 * Map:以key-value对的形式存储元素
 * 看起来更像是一个多行两列的表格。
 * 为了解决value可读性差，使用key做解释说明等
 * 工作时，可以使用Map来存储。
 *
 * Map本身是一个接口不能实例化，常用的实现类:HashMap(散列表,哈希表)
 *
 */
public class MapDemo {

	@Test
	public void startMap() {
		//java.util.*
		/*
		 * Map的key,value的类型要分别指定。
		 */
		/*
		 * V put(K k,V v)
		 * 将给定的key-value对存入Map中。
		 *
		 * Map要求，key在Map中是不允许重复的。
		 *
		 *
		 * 若给定的key在Map中不存在，则返回值为 NULL，若存在，那么就是替换value操作。 那么返回的就是被替换的value
		 */

		Map<String,Integer> map  = new HashMap<String,Integer>();

		//这里接受返回值不要使用基本类型，避免空指针的出现
		//int num = map.put("语文", 95);//java.lang.NullPointerException
		//System.out.println(num);
		map.put("数学", 98);
		map.put("物理", 97);
		map.put("化学", 99);
		map.put("英语", 98);

		//System.out.println(map);
		map.put("语文", 100);
		map.put("历史", null);
		//System.out.println(map);


		/*
		 * V get(K k)
		 * 根据给定的key获取对应的value
		 * 若当前Map中没有找到给定的key，则返回
		 * 值为null
		 */
		Integer num2 = map.get("化学");
		System.out.println(num2);

		num2 = map.get("历史");
		System.out.println(map.containsKey("历史"));
		System.out.println(num2);

	}

	@Test
	public void Iterator(){
		Map<Character, String> map = new HashMap<Character, String>();
		map.put('a', "A");
		map.put('b', "B");
		map.put('b', "C");

		Set<Character> set = map.keySet();
		for (Character e: set) {
			String v = map.get(e);
			//System.out.println(v);
		}

		Iterator i = set.iterator();
		while (i.hasNext()){
			Object x = i.next();
		}

		Collection a =  map.values();
		a.forEach(System.out::println);

		//Map.Entry<Character, String> pair = new AbstractMap.SimpleEntry<Character, String>('a', "S");


	}

	@Test
	public void testEntry() {
		Map<String,Integer> map = new HashMap<>();
		map.put("数学", 98);
		map.put("物理", 97);
		map.put("化学", 99);
		map.put("英语", 98);

		//无序集合（插入和遍历顺序不一致:
		/*
		 * Set<Entry> entrySet()
		 * 该方法会将Map中的每一组键值对(每个键值对用一个Entry的实例保存)存入一个Set集合后返回。
		 */
		Set<Map.Entry<String,Integer>> entrySet = map.entrySet();

		for(Map.Entry<String,Integer> e:entrySet){
			String k = e.getKey();
			Integer v = e.getValue();
			System.out.println(k+":"+v);
		}

		/*
		 * 遍历所有的value：  Collection<V> values()
		 */
		Collection<Integer> values = map.values();
		for(Integer value : values){
			System.out.println("value:"+value);
		}

		/*
		 * V remove(K k)
		 * 删除当前map中对应key的这一组键值对。并且将对应的value返回。
		 */
		Integer old = map.remove("英语");
		System.out.println("被删的记录中value是:"+old);
		System.out.println(map);
	}

	public void testContains(String[] args) {
		Map<String, Integer> map= new HashMap<String, Integer>();
		map.put("数学", 98);
		map.put("物理", 97);
		map.put("化学", 99);
		map.put("英语", 98);

		boolean tf = map.containsKey("英语");
		System.out.println("含有:"+tf);

	}
}







