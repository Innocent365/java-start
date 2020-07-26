package leetCode;

import java.util.function.IntConsumer;

 /**
  * 打印零与奇odd 偶even数
  * 使用wait, notify 总觉得有点似是而非。
  *
  */
 @SuppressWarnings("All")
 public class _1116_ZeroEvenOdd_wait_my {
     private int n;

     private volatile int num = 0;


     public _1116_ZeroEvenOdd_wait_my(int n) {
         this.n = n;
     }

     // printNumber.accept(x) outputs "x", where x is an integer.
     public void zero(IntConsumer printNumber) throws InterruptedException {
         for (int i = 0; i < n; i++) {
             synchronized (this) {
                 while ((num & 1) > 0) {
                     this.wait();
                 }
                 printNumber.accept(0);
                 num++;
                 this.notifyAll();
             }
         }
     }

     public void even(IntConsumer printNumber) throws InterruptedException {
         for (int i = 2; i <= n; i += 2) {
             synchronized (this) {
                 while ((num & 1) == 0 || num % 4 != 3) {
                     this.wait();
                 }
                 printNumber.accept(i);
                 num++;
                 this.notifyAll();
             }
         }
     }

     public void odd(IntConsumer printNumber) throws InterruptedException {
         for (int i = 1; i <= n; i += 2) {
             synchronized (this) {
                 while ((num & 1) == 0 || num % 4 != 1) {
                     this.wait();
                 }
                 printNumber.accept(i);
                 num++;
                 this.notifyAll();
             }
         }
     }

     public static void main(String[] args) throws InterruptedException {
         _1116_ZeroEvenOdd_wait_my bean = new _1116_ZeroEvenOdd_wait_my(5);

         Thread threadA = new Thread(() -> {
             try {
                 bean.zero(p -> {
                     System.out.print(p);
                 });
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         });

         Thread threadB = new Thread(() -> {
             try {
                 bean.odd(p -> {
                     System.out.print(p);
                 });
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         });

         Thread threadC = new Thread(() -> {
             try {
                 bean.even(p -> {
                     System.out.print(p);
                 });
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         });

         threadA.start();
         threadB.start();
         threadC.start();
     }
 }
