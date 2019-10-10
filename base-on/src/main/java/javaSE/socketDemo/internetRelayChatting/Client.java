package _3.javaSE.socketDemo.internetRelayChatting;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * 聊天室客户端
 * @author Administrator
 *
 */
public class Client {
	/*
	 * java.net.Socket
	 * 套接字，封装了与服务端的会话。
	 * 通过它我们可以连接上服务端，并获取一对输入输出流与服务端进行通信。
	 */
	private Socket socket;
	/**
	 * 初始化客户端
	 * @throws Exception 
	 */
	public Client() throws Exception{
		try {
			/*
			 * 实例化Socket，需要传入两个参数
			 * 1:远端IP地址
			 * 2:远端开启的服务端口
			 * 
			 * IP:用于找到远程服务器的计算机
			 * 端口:通过端口可以连接到运行在服务器计算机上的服务端应用程序。
			 * 端口是一个数字:2字节之间。
			 * 通常前1000都绑定着系统程序，前10000之前松散绑定着一些应用程序
			 * 一般不使用10000以上的数字。
			 * 
			 * 实例化Socket的过程就是与服务端建立连接的过程。
			 */
			socket = new Socket("localhost",8088);
		} catch (Exception e) {
			System.out.println(
				"客户端初始化失败!");
			throw e;
		}
	}
	/**
	 * 客户端开始工作的方法
	 * @throws Exception 
	 */
	public void start() throws Exception{
		try {
			/*
			 * 首先启动用来接收服务端发送过来
			 * 信息的线程
			 */
			ServerHandler handler = new ServerHandler();
			Thread t = new Thread(handler);
			t.start();
			
			/*
			 * Socket提供了一个方法：
			 * OutputStream getOutputStream()
			 * 该方法会获取一个输出流，用来将消息发送给服务端
			 */
			OutputStream out = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(out,"UTF-8");
			PrintWriter pw = new PrintWriter(osw,true);
			
			Scanner scanner = new Scanner(System.in);
			
			while(true){
				pw.println(scanner.nextLine());
			}
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	public static void main(String[] args) {		
		try {
			Client client = new Client();
			client.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * 该线程用来循环读取服务端发送过来的消息
	 * 并输出到客户端的控制台上。
	 * @author Administrator
	 *
	 */
	private class ServerHandler implements Runnable{
		public void run(){
			try {
				/*
				 * 通过Socket获取输入流，读取服务端发送过来的信息
				 */
				InputStream in = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(in,"UTF-8");
				BufferedReader br = new BufferedReader(isr);
				
				String message = null;
				while((message=br.readLine())!=null){
					//将服务端发送过来的消息输出到控制台
					System.out.println(message);
				}
			} catch (Exception e) {
				
			}
		}
	}
}






