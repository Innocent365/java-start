


import org.junit.Test;

import java.util.Arrays;

public class Shuffle {

    int[] array = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13};


    public static void main(String[] args) {
        Shuffle shuffle = new Shuffle();

        int[] array = shuffle.array;

        for (int i = array.length-1, j; i > 0; i--) {
            j = (int) (array.length * Math.random());
            shuffle.swap(array,i, j);
        }

        System.out.println(Arrays.toString(array));
    }

    private void swap(int[] array, int a, int b) {
        array[a] = array[a] + array[b];
        array[b] = array[a] - array[b];
        array[a] = array[a] - array[b];
    }

    @Test
    public void testSwap() {
        int a = 10, b = 20;
        int c = a;
        a = b;
        b = c;
        System.out.println("a:" + a + "; b=" + b);
    }

    @Test
    public void testSwap2() {
        int a = 10, b = 20;
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("a:" + a + "; b=" + b);
    }

    @Test
    public void testSwap3() {
        int a = 10, b = 20;
        a = b + ((b = a)!=0?0:0);
        System.out.println("a:" + a + "; b=" + b);
    }
}
