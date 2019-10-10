package _1.base;



import org.junit.Test;

import java.util.Arrays;

public class ArrayDemo {

    @Test//2.数组的初始化
    public void testInit() {
        int[] arr = new int[4];  //0,0,0,0
        arr[0] = 100;
        arr[1] = 200;
        arr[2] = 300;

        int[] arr1 = {1,3,4,5};  //1,3,4,5
        int[] arr2 = new int[]{1,3,4,5}; //1,3,4,5\
        int[] arr3;
        //arr3 = {1,3,4,5}; //编译错误，只能声明同时时
        arr3 = new int[]{1,3,4,5}; //正确
    }
    
    @Test//6.数组的排序
    public void testSort() {
        int[] arr = {1,45,34,2,12};

        Arrays.sort(arr); //对arr数组升序排
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    @Test//5.数组的复制
    public void testCopy1() {
        int[] a = {10,20,30,40,50};
        //扩容
        a = Arrays.copyOf(a,a.length+1);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }

    }
    
    @Test
    public void testCopy2() {
        int[] a = {10,20,30,40,50};

        int[] a1 = new int[6]; //0,0,0,0,0,0

        //a:源数组
        //1:源数组的起始下标
        //a1:目标数组
        //0:目标数组的起始下标
        //4:要复制的元素的个数
        System.arraycopy(a,1,a1,0,4);
        for(int i=0;i<a1.length;i++){ //0,0,0,10,20,0
            System.out.println(a1[i]);
        }
    }
    
    @Test//求数组中的最大值
    public void getMaxOfArray() {
        int[] arr = new int[10];

        for(int i=0;i<arr.length;i++){
            arr[i] = (int)(Math.random()*100);
            System.out.println(arr[i]);
        }

        int max = arr[0]; //假设第1个数为最大值
        for(int i=1;i<arr.length;i++){ //遍历剩余元素
            if(arr[i]>max){   //若数组元素大于max
                max = arr[i]; //改变max的值为较大的数
            }
        }
        System.out.println("最大值为:"+max);

        //扩容
        arr = Arrays.copyOf(arr,arr.length+1);
        arr[arr.length-1] = max; //将最大值赋值给最后一个元素

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] x = new int[0];
        System.out.println(x.length);

    }
}
