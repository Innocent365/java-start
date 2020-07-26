package thread.block;

/**
 * wait方法依赖于同步，而sleep方法可以直接调用，
 * 更深层次的区别在于sleep方法只是暂时让出CPU的执行权，并不释放锁。
 * 而wait方法则需要释放锁(持有的monitor对象锁)。
 */
public class SleepTest {
    public synchronized void sleepMethod(){
        System.out.println("Sleep start---");
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Sleep end---");
    }

    public synchronized void waitMethod(){
        System.out.println("Wait Start---");
        synchronized (this){
            try {
                wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Wait End---");
    }

    public static void main(String[] args) {
        final SleepTest test = new SleepTest();

        for (int i = 0; i < 3; i++) {
            new Thread(()->{
                test.sleepMethod();
            }).start();
        }

        try {
            Thread.sleep(10000);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }

        System.out.println("----------------");

        final  SleepTest test2 = new SleepTest();
        for (int i = 0; i < 3; i++) {
            new Thread(()->{
                test2.waitMethod();
            }).start();
        }
    }
}
