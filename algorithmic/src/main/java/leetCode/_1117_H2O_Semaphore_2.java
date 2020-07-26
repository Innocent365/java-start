package leetCode;

import java.util.concurrent.Semaphore;

/**
 * 测试不通过
 */
@Deprecated
public class _1117_H2O_Semaphore_2 {

    private Semaphore semaphoreH = new Semaphore(2);
    private Semaphore semaphoreO = new Semaphore(1);

    public _1117_H2O_Semaphore_2() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        semaphoreH.acquire();
        releaseHydrogen.run();

        if(semaphoreH.availablePermits() == 0)
            semaphoreO.release();
    }


    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        semaphoreO.acquire();
        releaseOxygen.run();

        semaphoreH.release();
        semaphoreH.release();
    }

    public static void main(String[] args) {

        _1117_H2O_Semaphore_2 h2O = new _1117_H2O_Semaphore_2();

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
