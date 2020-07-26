package javaSE.exceptionDemo;


/**
 *
 * getCause()
 * String getMessage()
 *
 * throw与throws的区别
 *
 * throw 抛出一个异常，抛出的时候是抛出的是一个异常类的实例化对象
 *		用在方法体内，跟的是异常对象名
 *
 *
 * throws 用在方法声明后面，跟的是异常类名
 * 		可以跟多个异常类名，用逗号隔开
 * 		表示抛出异常，由该方法的调用者来处理
 * 		throws表示出现异常的一种可能性，并不一定会发生这些异常
 *
 */
public class ExceptionDemo {
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

/**
 * Exception与RuntimeException区别:
 * 	1.继承自Runtime Exception或 Error 的是非检查型异常，
 * 		而继承自 Exception 的则是检查型异常（当然，Runtime Exception 本身也是 Exception 的子类）。
 *  2.对非检查型类异常可以不用捕获，而检查型异常则必须用try语句块进行处理或者把异常交给上级方法处理总之就是必须写代码处理它。
 *
 */



