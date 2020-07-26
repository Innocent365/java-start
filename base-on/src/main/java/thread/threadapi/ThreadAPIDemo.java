package thread.threadapi;


import org.junit.Test;

/**
 * static Thread currentThread()
 * 线程提供了一个静态方法，用来获取运行该方法的线程
 * @author Administrator
 *
 */
public class ThreadAPIDemo {
	/**
	 * main方法也是靠一个线程运行的。当我们执行java程序时，系统会启动一个进程来运行我们的程序。
	 * 当进程启动后jvm也会创建线程来运行我们的main方法。*
	 */
	public static void main(String[] args) {
		/*
		 * 返回运行当前方法的线程。
		 * 这里的t就是运行main方法的线程了。
		 */
		Thread t = Thread.currentThread();
		System.out.println("运行main方法的线程是:"+t);
		dosome();
		
		//创建一个线程	
		Thread myThread = new Thread(){
			public void run(){
				Thread t = Thread.currentThread();
				System.out.println("运行run方法的线程是:"+t);
				dosome();
			}
		};
		System.out.println("自定义的线程是:"+myThread);
		myThread.start();
	}
	
	public static void dosome(){
		//用于获取运行dosome方法的线程
		Thread t = Thread.currentThread();

		//获取线程id
		long id = t.getId();
		System.out.println("id:"+id);

		System.out.println("name:"+t.getName());

		//优先级
		System.out.println("priority:"+t.getPriority());

		System.out.println("isAlive:"+t.isAlive());

		System.out.println("isDaemon:"+t.isDaemon());

		System.out.println("isInterrupted:"+t.isInterrupted());
	}

	@Test//线程优先级 ：优先级越高的线程理论上被分配CPU时间片的次数就多
	// * 线程优先级有10个等级		* 1最低，10最高，5是默认值
	public void testPriority(String[] args) {
		Thread min = new Thread(){
			public void run(){
				for(int i=0;i<10000;i++){
					System.out.println("min");
				}
			}
		};
		Thread max = new Thread(){
			public void run(){
				for(int i=0;i<10000;i++){
					System.out.println("max");
				}
			}
		};
		Thread norm = new Thread(){
			public void run(){
				for(int i=0;i<10000;i++){
					System.out.println("norm");
				}
			}
		};
		min.setPriority(Thread.MIN_PRIORITY);
		max.setPriority(Thread.MAX_PRIORITY);

		min.start();
		norm.start();
		max.start();
	}

	@Test//守护
	// 守护线程，也叫后台线程，使用上与前台线程没有差别。
	// 但是当一个进程中的所有前台线程都结束时，无论后台线程是否还在运行都要强制中断使得进程结束
	public void testDaemon() {
		 //rose:扮演者前台线程
		Thread rose= new Thread(){
			public void run(){
				for(int i=0;i<10;i++){
					System.out.println(
							"rose:let me go!");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
				}
				System.out.println(
						"rose:啊啊啊啊啊AAAAAAaaaa....");
				System.out.println("特效:噗通!");
			}
		};

		//jack:扮演者后台线程
		Thread jack = new Thread(){
			public void run(){
				while(true){
					System.out.println(
							"jack:you jump!i jump!");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
				}
			}
		};
		//设置为后台线程，要在start前设置
		jack.setDaemon(true);

		rose.start();
		jack.start();
		//当我们让main线程不会结束，jack就不会结束
		while(true){

		}
	}

	boolean isFinish = false;//表示图片是否下载完毕
	@Test//join方法可以使当前线程进入阻塞状态，直到监视的线程结束为止
	public void test(String[] args) {

		/*
		 * 模拟下载与显示线程的协同工作
		 */
		final Thread download = new Thread(){
			public void run(){
				System.out.println("download:开始下载图片");
				for(int i=1;i<=100;i++){
					System.out.println("已下载:"+i+"%");
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
					}
				}
				System.out.println("download:图片下载完毕!");
				isFinish = true;
			}
		};
		//显示图片的线程
		Thread show = new Thread(){
			public void run(){
				System.out.println(
						"show:开始显示图片");
				/*
				 * 在这里，应当等待download将图片
				 * 下载完毕。
				 */
				try {
					download.join();
				} catch (InterruptedException e) {
				}

				if(!isFinish){
					throw new RuntimeException(
							"图片没有下载完毕!");
				}
				System.out.println(
						"show:显示图片完毕!");
			}
		};
		show.start();
		download.start();
	}
}

