package leetCode;

import java.util.function.IntConsumer;

/**
 * volatile 配合无限循环
 *
 * @author hw
 * @version on 2020/5/23
 */
@Deprecated
public class _1116_ZeroEvenOdd_volatile3 {
    private int n;

    private volatile boolean zero = true;
    private volatile boolean odd = true;
    private volatile boolean even = false;

    private volatile boolean run = true;

    public _1116_ZeroEvenOdd_volatile3(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {

        while (run) {
            while (!zero) {
                Thread.sleep(0);
            }
            printNumber.accept(0);
            zero = false;
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {

        int i = 2;
        for (; i <= n; i+=2) {
            while (zero || !even){
                Thread.sleep(0);
            }
            printNumber.accept(i);
            zero = true;
            even = false;
            odd = true;
        }
        run = false;
        //if(i == n){
        //    printNumber.accept(i);
        //    run = false;
        //}
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        int i = 1;
        for (; i <= n; i+=2) {
            while (zero || !odd){
                Thread.sleep(0);
            }
            printNumber.accept(i);
            zero = true;
            even = true;
            odd = false;
        }
        run = false;

    }

    public static void main(String[] args) throws InterruptedException {

        //for (int i = 0; i < 50; i++) {

        _1116_ZeroEvenOdd_volatile3 bean = new _1116_ZeroEvenOdd_volatile3(5);
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
