package jvm.stack;

/**
 * VM Args: -Xss128k
 *
 * StackOverflowError:
 *      栈深度溢出
 *
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak(){
        stackLength ++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF stackSOF = new JavaVMStackSOF();
        try {
            stackSOF.stackLeak();
        }catch (Throwable e){
            System.out.println("stackLength: " + stackSOF.stackLength);
            throw e;
        }
    }
}
