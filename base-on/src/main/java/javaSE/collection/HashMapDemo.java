package javaSE.collection;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

    public static void main(String[] args) {
        Map map = new HashMap();    //构造一个具有默认初始容量 (16) 和默认加载因子 (0.75) 的空 HashMap。
        Map map2 = new HashMap(50);     //构造一个带指定初始容量和默认加载因子 (0.75) 的空 HashMap。
        Map map3 = new HashMap(60, 0.23f); //构造一个带指定初始容量和加载因子的空 HashMap。

        /** 加载因子 loadFactor：表示哈希表在其容量自动增加之前可以达到多满的一种尺度，衡量一个散列表的控件使用程度
         * 因此如果负载因子越大，对空间的利用更充分，然而后果是查找效率的降低；如果负载因子太小，那么散列表的数据将过于稀疏，对空间造成严重浪费。
         * 系统默认负载因子为0.75，一般情况下我们是无需修改的。
         *       HashMap()：构造一个具有默认初始容量 (16) 和默认加载因子 (0.75) 的空 HashMap。
         *       HashMap(int initialCapacity)：构造一个带指定初始容量和默认加载因子 (0.75) 的空 HashMap。
         *       HashMap(int initialCapacity, float loadFactor)：构造一个带指定初始容量和加载因子的空 HashMap。
         *
         *我们知道在Java中最常用的两种结构是数组和模拟指针(引用)，几乎所有的数据结构都可以利用这两种来组合实现，HashMap也是如此。
         * 实际上HashMap是一个“链表散列”，如图是它数据结构：
         *  HashMap底层实现还是数组，只是数组的每一项都是一条链。其中参数initialCapacity就代表了该数组的长度。下面为HashMap构造函数的源码：
         *
         *
         * 每次新建一个HashMap时，都会初始化一个table数组。table数组的元素为Entry节点。
         *
         */

        map.put("key", "value");
    }




//http://cmsblogs.com/?p=176

}
