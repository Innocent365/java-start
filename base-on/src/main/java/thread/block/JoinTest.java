package thread.block;

/**
 * 在没有使用join方法之间，线程是并发执行的，而使用join方法后，所有线程是顺序执行的。
 *
 *
 * join方法内部是通过wait方法来将线程的阻塞，
 *  如果join的线程还在执行，则将当前线程阻塞起来，直到join的线程执行完成，当前线程才能执行。
 *  这里的join只调用了wait方法，却没有对应的notify方法，
 *      原因是Thread的start方法中做了相应的处理，所以当join的线程执行完成以后，会自动唤醒主线程继续往下执行。
 */
public class JoinTest implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "Start");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "End");
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new JoinTest());
            thread.start();

            //当join的线程执行完成以后，会自动唤醒主线程继续往下执行，。
            //  所以此时main方法在thread线程没执行结束前不会继续for循环
            thread.join();//注意：使用join方法必须在线程start之后否则不起作用
        }
    }
}
