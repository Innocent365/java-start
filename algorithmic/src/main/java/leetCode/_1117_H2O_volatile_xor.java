package leetCode;


/**
 * 区别在于，线程的循环还是线程内部的循环
 */
public class _1117_H2O_volatile_xor {

    private final byte first = 1;
    private final byte second = 1 << 1;
    private final byte last = 1 << 2;

    private volatile byte molecule;

    public _1117_H2O_volatile_xor() {
        molecule = 0;
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        if ((molecule & first) == 0) {
            releaseHydrogen.run();
            molecule |= first;
            return;
        }
        if ((molecule & second) == 0) {
            releaseHydrogen.run();
            molecule |= second;
        }

        while (molecule != 0 && (molecule & last) == 0) {
            Thread.sleep(0);
        }
        if (molecule == 7) {
            molecule = 0;
        }
    }


    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        if ((molecule & last) > 0) {
            Thread.sleep(0);
        }

        if ((molecule & last) == 0) {
            releaseOxygen.run();
            molecule |= last;
        }
        while (molecule != 0 && (molecule & second) == 0) {
            Thread.sleep(0);
        }
        if (molecule == 7) {
            molecule = 0;
        }
    }


    public static void main(String[] args) {

        _1117_H2O_volatile_xor h2O = new _1117_H2O_volatile_xor();
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

        threadO.start();
        threadH.start();
    }
}
