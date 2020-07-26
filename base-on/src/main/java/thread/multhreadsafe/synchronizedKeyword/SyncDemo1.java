package thread.multhreadsafe.synchronizedKeyword;
/**
 *
 * 使用 synchronized 同步方法（同步方法实际是锁定对象）
 *
 */
public class SyncDemo1 {
	public static void main(String[] args) {
		final Table table = new Table();

		Thread t1 = new Thread(){
			public void run() {
				while(true){
					int bean = table.getBean();
					//模拟CPU没有时间了
					Thread.yield();
					System.out.println("线程1:"+bean);
				}
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				while(true){
					int bean = table.getBean();
					Thread.yield();
					System.out.println("线程2:"+bean);
				}
			}
		};
		t1.start();
		t2.start();
	}
}

class Table{
	//桌子上有20个豆子
	private int beans = 20;
	/**
	 * 当一个方法被synchronized修饰后，该方法就是一个同步方法了。
	 * 多个线程调用时不会同时进到方法内部。
	 * 需要注意的是synchronized一定会给一个对象上锁。在这里，锁的是当前方法所属的对象。
	 * 也就是上面main方法中创建的table实例。
	 * 由于两个线程调用的是同一个table的getBean方法。所以两个线程不能同时进到方法内部。
	 */
	public synchronized int getBean(){
		if(beans==0){
			throw new RuntimeException("没有豆子了!");
		}
		Thread.yield();
		return beans--;
	}
}











