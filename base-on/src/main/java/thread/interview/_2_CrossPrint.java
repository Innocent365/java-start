package thread.interview;


/**
 * 希望 A 在打印完 1 后，再让 B 打印 1, 2, 3，最后再回到 A 继续打印 2, 3
 */
public class _2_CrossPrint {

    public static void main(String[] args) throws InterruptedException {
        new _2_CrossPrint().method3();
    }


    public void method1() {
        Thread threadB = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }, "B");

        Thread threadA = new Thread(() -> {
            int num = 0;
            while (num++ < 3) {
                System.out.println(Thread.currentThread().getName() + ":" + num);
                if (num == 1) {
                    try {
                        threadB.start();
                        threadB.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "A");
        threadA.start();
    }

    volatile boolean flag = false;

    public void method2() throws InterruptedException {

        Thread threadA = new Thread(() -> {
            System.out.println("A:1");
            while (!flag) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 2; i <= 3; i++) {
                System.out.println("A:" + i);
            }
        });
        threadA.start();

        Thread.sleep(300);
        //Thread.yield();
        //threadA.join();//错误不能这么干

        new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("B:" + i);
            }
            flag = true;
        }).start();
    }

    public void method3() {
        Object lock = new Object();

        Thread threadA = new Thread(() -> {
            synchronized (lock) {
                System.out.println("A:1");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("A:2");
                System.out.println("A:3");
            }
        });

        Thread threadB = new Thread(() -> {
            //对 B 而言，由于 A 最开始得到了锁，导致 B 无法执行；
            //直到 A 调用 lock.wait() 释放控制权后， B 才得到了锁；
            synchronized (lock) {
                System.out.println("B:1");
                System.out.println("B:2");
                System.out.println("B:3");
                //调用 lock.notify() 方法，唤醒正在 wait 的 A;
                lock.notify();
            }
        });

        threadA.start();
        threadB.start();

    }
}
