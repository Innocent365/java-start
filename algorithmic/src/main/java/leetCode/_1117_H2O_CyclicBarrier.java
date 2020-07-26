package leetCode;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 区别在于，外部的循环还是线程内部的循环
 */
public class _1117_H2O_CyclicBarrier {

    private volatile Boolean shit = null;

    private CyclicBarrier barrier = new CyclicBarrier(3, () -> {
        shit = null;
    });


    public _1117_H2O_CyclicBarrier() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        try {

            releaseHydrogen.run();
            barrier.await();

            if (shit == null) {
                shit = false;
                return;
            }
            if (!shit) {
                shit = true;
            }
            while (shit){
                Thread.sleep(0);
            }
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }


    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        try {
            releaseOxygen.run();
            barrier.await();

        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

        _1117_H2O_CyclicBarrier h2O = new _1117_H2O_CyclicBarrier();

        Runnable releaseHydrogen = () -> System.out.print("H");
        Runnable releaseOxygen = () -> System.out.print("O");

        Thread threadH = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    h2O.hydrogen(releaseHydrogen);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadO = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    h2O.oxygen(releaseOxygen);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadH.start();
        threadO.start();
    }
}
