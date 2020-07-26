package thread.multhreadsafe;
/**
 * 当多个线程同时操作一段数据时，由于线程切换的不确定性，可能会导致逻辑出现混乱。
 */
public class Problem {
	public static void main(String[] args) {
		Table table = new Table();

		//Thread t1 = new Thread(){
		//	public void run() {
		//		while(true){
		//			int bean = table.getBean();
		//			//模拟CPU没有时间了
		//			//Thread.yield();
		//			System.out.println("线程1:"+bean);
		//		}
		//	}
		//};
		//Thread t2 = new Thread(){
		//	public void run(){
		//		while(true){
		//			int bean = table.getBean();
		//			//Thread.yield();
		//			System.out.println("线程2:"+bean);
		//		}
		//	}
		//};
		//t1.start();
		//t2.start();

		for (int i = 0; i < 100; i++) {

			int finalI = i;
			new Thread(new Runnable() {
				@Override
				public void run() {
					while(true){
						int bean = table.getBean();
						//Thread.yield();
						System.out.println("线程"+ finalI +":"+bean);
					}
				}
			}).start();
		}
	}
}

class Table{
	//桌子上有20个豆子
	private int beans = 200;

	public int getBean(){
		if(beans==0){
			throw new RuntimeException("没有豆子了!");
		}
		//Thread.yield();
		return beans--;
	}
}











