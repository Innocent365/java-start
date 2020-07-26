package jvm.stack;

/**
 * 请于32位虚拟机操作，64位不抛异常
 * 操作系统有假死风险，请先保存当前工作
 * VM Args: -Xss2M
 */
public class JavaVMStackOOM {

    private void dontStop(){
        while (true);
    }

    public void stackLeakByThread(){
        while (true){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
