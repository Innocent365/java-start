package javaSE.threadDemo;
/**
 * wait与notify方法
 * wait方法允许当前线程在监视对象上等待。直到监视对象的notify方法被调用，当前线程就接触阻塞继续向下执行。
 * 
 * wait与notify是在Object上定义的方法，换句话说当前线程可以在任意对象上调用wait方法进行阻塞。
 * 只要该对象的notify被调用，当前线程就可以解除阻塞。
 *
 */
public class ThreadWaitAndNotifyDemo {
	private static Object obj = new Object();
	//表示图片是否下载完毕
	private static boolean isFinish;
	public static void main(String[] args) {
		/*
		 * 模拟下载与显示线程的协同工作
		 */
		final Thread download = new Thread(){
			public void run(){
				System.out.println("download:开始下载图片");
				for(int i=1;i<=100;i++){
					if(i%12==0) System.out.println("已下载:"+i+"%");
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
					}
				}
				System.out.println("download:图片下载完毕!");
				isFinish = true;
				//就可以通知show线程继续工作了
				synchronized (obj) {
					obj.notify();
				}			

				//下载附件
				System.out.println("download:开始下载附件...");
				for(int i=1;i<=100;i++){
					if(i%10==0) System.out.println("已下载:"+i+"%");
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
					}
				}
				System.out.println("download:附件下载完毕!");
				
			}
		};
		//显示图片的线程
		Thread show = new Thread(() -> {
			System.out.println("show:开始显示图片");
			//在这里，应当等待download将图片下载完毕。
			try {
					//download.join();
				synchronized (obj) {
					obj.wait();
				}
			} catch (InterruptedException e) {
			}

			if(!isFinish){
				throw new RuntimeException("图片没有下载完毕!");
			}
			System.out.println("show:显示图片完毕!");
		});
		show.start();
		download.start();
	}
}











