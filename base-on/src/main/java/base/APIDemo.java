package base;
/**
 * 文档注释可以定义在三个地方
 * 1:类的上面
 * 2:方法的上面
 * 3:常量的上面
 * 
 * 这里可以说明当前类的作用。
 * @author 张三丰
 * @version 1.0 
 * @see String
 * @since JDK1.0
 */
public class APIDemo {
	/**
	 * 在dosome方法中使用的问候短语
	 */
	private static final String INFO = "你好!";
	
	public static void main(String[] args) {
		System.out.println(dosome("张三丰"));
	}
	/**
	 * 将返回使用给定名字的问候语
	 * @param name 给定有名字
	 * @return 对应的问候语
	 */
	public static String dosome(String name){
		return INFO+name;
	}
}












