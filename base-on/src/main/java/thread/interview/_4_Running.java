package thread.interview;

import java.util.Random;
import java.util.RandomAccess;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 线程 A B C 各自开始准备，直到三者都准备完毕，然后再同时运行 。
 * 也就是要实现一种 线程之间互相等待 的效果
 */
public class _4_Running {

    public static void main(String[] args) {

        //Cyclic循环，Barrier栅栏。当等待的人数符合个数时撤掉栅栏。
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        new Athlete("A", cyclicBarrier).start();
        new Athlete("B", cyclicBarrier).start();
        new Athlete("C", cyclicBarrier).start();
    }

}
class Athlete extends Thread{

    private CyclicBarrier cyclicBarrier;

    public Athlete(String name, CyclicBarrier barrier) {
        super(name);
        this.cyclicBarrier = barrier;
    }

    @Override
    public void run() {
        super.run();
        System.out.println(getName() + "热身准备 start-----");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getName() + "热身完毕 end-------");

        try {
            //开始等待
            cyclicBarrier.await();
            System.out.println(getName() + "开始跑步---");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getName() + "结束跑步");
    }
}
