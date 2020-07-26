package thread.interview;



/**
 *
 * 如何让两个线程依次执行分别依次打印 1-3 三个数字
 *
 *
 */
public class _1_SortPrint {

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runn(), "A");
        Thread threadB = new Thread(new Runn(), "B");

        threadA.start();
        threadA.join();

        threadB.start();
    }

}
class Runn implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}