package leetCode;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * 打印零与奇odd 偶even数
 *
 * @author hw
 * @version on 2020/5/22
 */
@SuppressWarnings("All")
public class _1116_ZeroEvenOdd_Semaphore_ShareNum {
    private int n;

    private volatile int num = 0;

    /**
     * 交通信号灯
     */
    private Semaphore zero = new Semaphore(1);
    private Semaphore even = new Semaphore(0);
    private Semaphore odd = new Semaphore(0);


    public _1116_ZeroEvenOdd_Semaphore_ShareNum(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while (num < n){
            zero.acquire();
            printNumber.accept(0);
            num ++;
            if ((num & 1) > 0) {
                odd.release();
            } else {
                even.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {

        while (num < n){
            even.acquire();
            printNumber.accept(num);
            zero.release();
            if(num + 1 >= n){
                break;
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (num < n){
            odd.acquire();
            printNumber.accept(num);
            zero.release();
            if(num + 1 >= n){
                break;
            }
        }
    }

    public static void main(String[] args) {
        _1116_ZeroEvenOdd_Semaphore_ShareNum bean = new _1116_ZeroEvenOdd_Semaphore_ShareNum(5);

        Thread threadA = new Thread(() -> {
            try {
                bean.zero(p -> {
                    if (p != 0) {
                        throw new RuntimeException("必须是0");
                    }
                    System.out.print(p);
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                bean.odd(p -> {
                    if (p % 2 == 0) {
                        throw new RuntimeException("必须是奇数");
                    }
                    System.out.print(p);
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadC = new Thread(() -> {
            try {
                bean.even(p -> {
                    if (p % 2 == 1) {
                        throw new RuntimeException("必须是偶数");
                    }
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
