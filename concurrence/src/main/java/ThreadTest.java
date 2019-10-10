public class ThreadTest {
    public static void main(String[] args) {
        System.out.println("ThreadTest开始运行。。。");
        new Thread(){
            @Override
            public void run() {
                synchronized(ThreadTest.class){
                    System.out.println("第一次调用");
                    synchronized(ThreadTest.class){
                        System.out.println("第二次调用");
                    }
                }
            }
        }.start();
        System.out.println("ThreadTest结束运行。。。");
    }
}
