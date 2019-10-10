package javaSE.exceptionDemo;


/**
 *
 * getCause()
 * String getMessage()
 *
 * finally块
 * 定义在try-catch的最后。
 * finally可以直接跟在try语句块之后，但通常
 * 是跟在最后一个catch块之后。
 * finally的特点:无论程序出错与否，finally中的
 *              代码都是无条件执行的
 *              
 *              
 * 笔试题：
 * 请分别写出final,finally,finalize的作用?             
 * @author Administrator
 *
 */
public class ExceptionDemo2 {
	public static void main(String[] args) {
		System.out.println("程序开始了");
		
		try {
			String str = "a";
			System.out.println(str.charAt(0));
		} catch (Exception e) {
			System.out.println(e.getMessage());	//获取错误的消息该信息一般用于描述当前错误是由于什么原因引起
			System.out.println(e.getCause());	//方法用来获取当前异常出现的原因。
		} finally{
			System.out.println("finally中的代码！");
		}
		
		System.out.println("程序结束了");
	}
}





