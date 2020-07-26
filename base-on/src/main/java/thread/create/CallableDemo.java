package thread.create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 通过 Callable 和 Future 创建线程
 * @author hw
 * @version on 2020/5/18
 */
public class CallableDemo {

    public static void main(String[] args) {
        //创建 Callable 实现类的实例，
        MyCallable callableThread = new MyCallable();

        //使用 FutureTask 类来包装 Callable 对象，该 FutureTask 对象封装了该 Callable 对象的 call() 方法的返回值。
        FutureTask<Integer> ft = new FutureTask<>(callableThread);

        new Thread(ft, "有返回值的线程").start();

        try {
            //调用 FutureTask 对象的 get() 方法来获得子线程执行结束后的返回值,
            //注意get方法在线程执行结束前会阻塞
            System.out.println("子线程的返回值：" + ft.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
//创建 Callable 接口的实现类，并实现 call() 方法，该 call() 方法将作为线程执行体，并且有返回值。
class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
        }
        return sum;
    }
}