package leetCode;

import java.util.function.IntConsumer;

/**
 * 打印零与奇odd 偶even数
 *
 * 使用无锁替换lock
 */
@SuppressWarnings("All")
public class _1116_ZeroEvenOdd_volatile {
    private int n;

    /**
     * 使用-1，0和1分别代表打印0，偶数和奇数
     */
    private volatile int stage = -1;


    public _1116_ZeroEvenOdd_volatile(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {

        int index = 0;
        while (index < n) {////0将会打印n次
            while (stage != -1);
            printNumber.accept(0);
            index += 1;
            stage = (index & 1);
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        int index = 2;
        while (index <= n){
            while (stage != 0);
            printNumber.accept(index);
            index += 2;//偶数打印 n/2次
            stage = -1;
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        int index = 1;
        while (index <= n){
            while (stage != 1);
            printNumber.accept(index);
            index +=2;//奇数打印 n/2次
            stage = -1;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        _1116_ZeroEvenOdd_volatile bean = new _1116_ZeroEvenOdd_volatile(51);

        Thread threadA = new Thread(() -> {
            try {
                bean.zero(p -> {
                    System.out.print(p);
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                bean.odd(p -> {
                    System.out.print(p);
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadC = new Thread(() -> {
            try {
                bean.even(p -> {
                    System.out.print(p);
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
    }
}
