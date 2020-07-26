package thread.multhreadsafe.synchronizedKeyword;
/**
 *
 * 当一个类中的多个方法同时被synchronized修饰后，这些方法就是互斥的。
 * 但是需要注意，静态方法与非静态方法之间没有互斥效果。原因在于他们锁的对象不同。
 * 		非静态方法锁的是方法所属的对象，而静态方法锁的是类对象。
 * 所以，有没有同步效果或互斥效果，关键在于不同线程看到的是否为相同的上锁对象。
 *
 */
public class SyncDemo3 {
	public static void main(String[] args) {
		final Foo foo = new Foo();
		Thread t1 = new Thread(){
			public void run(){
				foo.a();
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				foo.b();
			}
		};
		t1.start();
		t2.start();
	}
}

class Foo{
	public synchronized void a(){
		Thread t = Thread.currentThread();
		System.out.println(t.getName()+":调用a方法.");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		System.out.println(
			t.getName()+":调用完a方法了.");
	}
	public synchronized void b(){
		Thread t = Thread.currentThread();
		System.out.println(t.getName()+":调用b方法.");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		System.out.println(t.getName()+":调用完b方法了.");
	}
}





