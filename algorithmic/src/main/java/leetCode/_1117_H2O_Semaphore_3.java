package leetCode;

import java.util.concurrent.Semaphore;

/**
 * copy别人的，可以
 */
public class _1117_H2O_Semaphore_3 {

    private Semaphore semaphoreH = new Semaphore(2);
    private Semaphore semaphoreO = new Semaphore(2);//初始这里为0还是2都可以

    public _1117_H2O_Semaphore_3() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        semaphoreH.acquire();
        releaseHydrogen.run();

        semaphoreO.release();
    }


    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        semaphoreO.acquire(2);
        releaseOxygen.run();

        semaphoreH.release(2);
    }

    public static void main(String[] args) {

        _1117_H2O_Semaphore_3 h2O = new _1117_H2O_Semaphore_3();

        Runnable releaseHydrogen = () -> System.out.print("H");
        Runnable releaseOxygen = () -> System.out.print("O");

        int n = 10;
        Thread threadH = new Thread(() -> {
            try {
                for (int i = 0; i < 2*n; i++) {
                    h2O.hydrogen(releaseHydrogen);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadO = new Thread(() -> {
            try {
                for (int i = 0; i < n; i++) {
                    h2O.oxygen(releaseOxygen);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadO.start();
        threadH.start();
    }
}
