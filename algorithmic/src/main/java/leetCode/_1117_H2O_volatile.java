package leetCode;

/**
 * 区别在于，外部的循环还是线程内部的循环
 */
public class _1117_H2O_volatile {

    private volatile boolean[] molecule;

    public _1117_H2O_volatile() {
        molecule = new boolean[3];
        molecule[2] = true;
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        while (!molecule[2]) {
            Thread.sleep(0);
        }
        while (!molecule[0]) {
            releaseHydrogen.run();
            molecule[0] = true;
            return;
        }
        while (!molecule[1]) {
            releaseHydrogen.run();
            molecule[2] = false;
            molecule[1] = true;
        }
    }


    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        while (!molecule[0] || !molecule[1]) {
            Thread.sleep(0);
        }
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        molecule[0] = molecule[1] = false;
        molecule[2] = true;
    }

    public static void main(String[] args) {

        _1117_H2O_volatile h2O = new _1117_H2O_volatile();
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
