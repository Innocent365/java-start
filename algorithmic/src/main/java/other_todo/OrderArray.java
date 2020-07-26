package other_todo;


import org.junit.Test;

import java.util.*;

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

    @Test
    public void test3() {
        int[] array = new int[]{1,4,6,2,7,8,  13,35,34,62,42,31};
        int[] newArr = new int[array.length];


        while (array.length>0){

        }

    }
}
