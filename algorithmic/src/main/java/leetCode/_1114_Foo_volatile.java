package leetCode;

/**
 * @author hw
 * @version on 2020/5/21
 */
public class _1114_Foo_volatile {

    private volatile char step = 1;

    public _1114_Foo_volatile() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        step = 2;
    }

    public void second(Runnable printSecond) throws InterruptedException {

        while (step != 2);
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        step = 3;
    }

    public void third(Runnable printThird) throws InterruptedException {

        while (step != 3);
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

    public static void main(String[] args) {
        Runnable run1 = new Runnable() {
            @Override
            public void run() {
                System.out.print("first");
            }
        };

        Runnable run2 = new Runnable() {
            @Override
            public void run() {
                System.out.print("second");
            }
        };

        Runnable run3 = new Runnable() {
            @Override
            public void run() {
                System.out.print("third");
            }
        };

        _1114_Foo_volatile foo = new _1114_Foo_volatile();

        Thread threadA = new Thread(()->{
            try {
                foo.first(run1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadB = new Thread(()->{
            try {
                foo.second(run2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadC = new Thread(()->{
            try {
                foo.third(run3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
    }
}