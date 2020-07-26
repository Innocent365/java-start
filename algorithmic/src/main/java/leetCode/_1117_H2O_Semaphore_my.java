package leetCode;

import java.util.concurrent.Semaphore;

/**
 * 区别在于，外部的循环还是线程内部的循环
 */
@Deprecated
public class _1117_H2O_Semaphore_my {

    private volatile boolean shit = true;
    private Semaphore semaphoreH = new Semaphore(2);
    private Semaphore semaphoreO = new Semaphore(1);

    public _1117_H2O_Semaphore_my() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        semaphoreH.acquire();
        releaseHydrogen.run();

        if(shit){
            shit = false;
            return;
        }

        if(!shit){
            shit = true;
            semaphoreO.release();
        }
    }


    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        semaphoreO.acquire();
        releaseOxygen.run();

        semaphoreH.release();
        semaphoreH.release();
    }

    public static void main(String[] args) {

        _1117_H2O_Semaphore_my h2O = new _1117_H2O_Semaphore_my();

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
