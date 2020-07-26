package leetCode;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

/**
 * 打印零与奇odd 偶even数
 *
 * @author hw
 * @version on 2020/5/22
 */
@Deprecated
public class _1116_ZeroEvenOdd_volatile_AtomicInteger_1 {
    private int n;

    //待打印的数
    private AtomicInteger inc = new AtomicInteger(0);


    private volatile boolean zero = true;

    public _1116_ZeroEvenOdd_volatile_AtomicInteger_1(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while (inc.get() < n) {
            if (zero) {
                printNumber.accept(0);
                inc.incrementAndGet();
                zero = false;
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (inc.get() < n) {
            if ((inc.get() & 1) == 0 && !zero) {
                printNumber.accept(inc.get());
                System.out.println("-");
                zero = true;
            }
        }
        if (inc.get() == n && (inc.get() & 1) == 0){
            printNumber.accept(inc.get());
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (inc.get() < n) {
            if ((inc.get() & 1) > 0 && !zero) {
                printNumber.accept(inc.get());
                System.out.println("---");
                zero = true;
            }
        }
        if (inc.get() == n && (inc.get() & 1) > 0){
            printNumber.accept(inc.get());
        }
    }

    public static void main(String[] args) throws InterruptedException {

        //for (int i = 0; i < 50; i++) {

        _1116_ZeroEvenOdd_volatile_AtomicInteger_1 bean = new _1116_ZeroEvenOdd_volatile_AtomicInteger_1(5);
        IntConsumer consumer = (p -> {
            System.out.print(p);
        });


        Thread threadA = new Thread(() -> {
            try {
                bean.zero(consumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                bean.odd(consumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadC = new Thread(() -> {
            try {
                bean.even(consumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
        System.out.println();


        //Thread.sleep(1000);
        //System.exit(0);
        //}

    }
}
