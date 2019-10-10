package javaSE.threadDemo;
/**
 *
 * 使用 同步块 来有效的减少同步范围，可以提高代码并发运行的效率。
 * @author Administrator
 *
 */
public class SyncDemo2 {
	public static void main(String[] args) {
		final Shop shop = new Shop();
		Thread t1 = new Thread(){
			public void run(){
				try {
					shop.buy();
				} catch (Exception e) {}
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				try {
					shop.buy();
				} catch (Exception e) {}
			}
		};
		t1.start();
		t2.start();
	}
}

class Shop{
	/*
	 * 假设该方法需要同步(试衣服的过程)
	 */
	public void buy() throws InterruptedException{
		//运行buy方法的线程
		Thread t = Thread.currentThread();
		
		System.out.println(
			t.getName()+":正在选衣服..."
		);
		Thread.sleep(5000);
		
		synchronized(this){
			System.out.println(
				t.getName()+":正在试衣服..."
			);
			Thread.sleep(5000);
		}
		System.out.println(
			t.getName()+":结账离开"
		);
		
	}
}












