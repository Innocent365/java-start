package encounter;

import org.junit.Test;
import java.util.*;

/**
 * 数组 奇数偶数分开
 */
public class OrderArray {

    public static void main(String[] args) {
        int array[] = new int[]{3,2};

        new OrderArray().swap(array,1,0);
        System.out.println(Arrays.toString(array));
    }

    public void swap(int[] array, int a, int b) {
//        a = b + ((b=a)!=1?0:0);
        Integer temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }


    
    @Test
    public void test(){
        Integer[] array = new Integer[]{1,4,6,2,7,8,13,35,34,62,42,31};

        ArrayList<Integer> oddArr = new ArrayList(array.length/2 + 1);
        ArrayList<Integer> evenArr = new ArrayList(array.length/2 + 1);

        for (int a : array) {
            if(a%2==1) oddArr.add(a);
            else evenArr.add(a);
        }

        oddArr.addAll(evenArr);
        array = oddArr.toArray(new Integer[oddArr.size()]);

        System.out.println(Arrays.toString(array));
    }

    @Test
    public void test2(){
        int[] array = new int[]{1,4,6,2,7,8,  13,35,34,62,42,31};

        int lastOrderIndex = array.length - 1;
        for (int i = 0; i <= lastOrderIndex; i++) {
            if(array[i]%2==0){
                lastOrderIndex = getLastOddNumIndex(array, i, lastOrderIndex);
                swap(array,i,lastOrderIndex);
                lastOrderIndex -= 1;
            }
        }

        System.out.println(Arrays.toString(array));
    }

    private int getLastOddNumIndex(int[] array, int start, int lastOrderIndex){
        if(lastOrderIndex <= start) return start;

        if(array[lastOrderIndex]%2==1){
            return lastOrderIndex;
        }else{
            return getLastOddNumIndex(array, start, lastOrderIndex-1);
        }
    }

}
/**
 * 数组:
 *   1)数组是相同数据类型元素的集合
 *   2)数组是数据类型(引用类型)
 *   3)定义:
 *       int[] arr = new int[4];
 *   4)初始化:
 *       int[] arr = new int[4];           //0,0,0,0
 *       int[] arr = {1,3,5,7};            //1,3,5,7
 *       int[] arr = new int[]{1,3,5,7};  //1,3,5,7
 *       int[] arr;
 *       arr = {1,3,5,7}; //编译错误，{}直接赋值只能声明的同时赋值
 *       arr = new int[]{1,3,5,7}; //正确
 *   5)访问:
 *       int[] arr = new int[3];
 *       System.out.println(arr.length);  //3
 *       通过下标/索引来访问数组中的元素
 *         下标从0开始，最大到.length-1
 *       arr[0]---代表arr中的第1个元素
 *       arr[arr.length-1]---代表arr中的最后一个元素
 *       arr[3] = 100;  //运行时异常，数组下标越界
 *       for(int i=0;i<arr.length;i++){
 *          arr[i] = 100;  //给arr中每个元素赋值为100
 *       }
 *       for(int i=0;i<arr.length;i++){
 *          System.out.println(arr[i]);
 *       }
 *   6)复制:
 *       //从a中的第2个元素开始，复制到a1的第1个元素开始
 *       //复制4个元素
 *       System.arraycopy(a,1,a1,0,4);
 *       //将a中的所有元素复制到a1中，a1的长度为5
 *       int[] a1 = Arrays.copyOf(a,5);
 *       //扩容
 *       a = Arrays.copyOf(a,a.length+1);
 *   7)排序:
 *       Arrays.sort(arr); //对arr升序排列
 *       冒泡算法
 */
