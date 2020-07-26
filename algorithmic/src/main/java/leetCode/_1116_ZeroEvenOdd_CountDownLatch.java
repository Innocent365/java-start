package leetCode;

import java.util.concurrent.CountDownLatch;
import java.util.function.IntConsumer;

/**
 * @author hw
 * @version on 2020/6/6
 */

@SuppressWarnings("All")
@Deprecated
public class _1116_ZeroEvenOdd_CountDownLatch {

    private final int n;


    public _1116_ZeroEvenOdd_CountDownLatch(int n) {
        this.n = n;
    }

    private int num = 0;
    private CountDownLatch zero = new CountDownLatch(0);
    private CountDownLatch even = new CountDownLatch(1);
    private CountDownLatch odd = new CountDownLatch(1);

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while (num < n) {
            zero.await();
            printNumber.accept(0);
            num++;
            if ((num & 1) > 0) {
                odd.countDown();
            } else {
                even.countDown();
            }
            zero = new CountDownLatch(1);
        }
    }


    public void even(IntConsumer printNumber) throws InterruptedException {
        while (num <= n) {
            even.await();
            printNumber.accept(num);
            zero.countDown();
            even = new CountDownLatch(1);
            if(num + 1>=n){
                break;
            }
        }
    }


    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (num <= n) {
            odd.await();
            printNumber.accept(num);
            zero.countDown();
            odd = new CountDownLatch(1);
            if(num + 1>=n){
                break;
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        _1116_ZeroEvenOdd_CountDownLatch bean = new _1116_ZeroEvenOdd_CountDownLatch(5);

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
