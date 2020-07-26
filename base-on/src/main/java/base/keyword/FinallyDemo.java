package base.keyword;
/**
 * * 笔试题：
 *  * 请分别写出final,finally,finalize的作用?
 *  	java提供finalize()方法，垃圾回收器准备释放内存的时候，会先调用fJava.
 *
 *
 *
 * finally块
 * 定义在try-catch的最后。
 * finally可以直接跟在try语句块之后，但通常
 * 是跟在最后一个catch块之后。
 * finally的特点:无论程序出错与否，finally中的
 *              代码都是无条件执行的
 *
 *
 * finally面试题
 * finally的语句是不是一定会被执行？
 * 	至少有两种情况下finally语句是不会被执行的：
 *
 * （1）try语句没有被执行到，如在try语句之前就返回了，这样finally语句就不会执行，!!!
 * 		这也说明了finally语句被执行的必要而非充分条件是：相应的try语句一定被执行到。
 *			Jedis jedis = getJedis();
 *			try{
 *             String requireToken = UUID.randomUUID().toString();
 *             String result = jedis.set(key, requireToken, "NX", “PX”, 60);
 *				……
 *			}catch(Exception ex){
 *				...
 *			}finally(){
 *			 	closeJedis(jedis);
 *			}
 *		改成：
 *			Jedis jedis = null;
 *			try{
 *  *           jedis = getJedis();
 *  *			……
 *  *		}catch(Exception ex){
 *  *			...
 *  *		}finally(){
 *  *		 	closeJedis(jedis);
 *  *		}
 *
 * （2）在try块中有System.exit(0);这样的语句，System.exit(0);是终止Java虚拟机JVM的。
 *
 *
 * https://www.cnblogs.com/lanxuezaipiao/p/3440471.html
 *
 * finally块的语句在try或catch中的return语句执行之后返回之前执行
 * 且finally里的修改语句 可能影响也可能不影响(参考ReferDemo)
 * 				try或catch中 return已经确定的返回值，
 * 若finally里也有return语句则覆盖try或catch中的return语句直接返回。
 */
public class FinallyDemo {
	public static void main(String[] args) {
		System.out.println(test("0"));//3执行try代码块，没有异常，尝试返回0；遇到finally,返回3
		System.out.println(test(null));//3执行try代码块，遇到异常e1执行，尝试返回1；遇到finally,返回3
		System.out.println(test(""));//3执行try代码块，遇到异常e2执行，尝试返回2；遇到finally,返回3
	}
	
	public static int test(String str){
		try {
			return '0'-str.charAt(0);
		} catch (NullPointerException e1) {
			return 1;
		} catch (Exception e2){
			return 2;
		} finally{
			return 3;
		}
	}
}
/**
 * 1.return语句并不是函数的最终出口，如果有finally语句，这在return之后还会执行finally
 * 	（return的值会暂存在栈里面，等待finally执行后再返回
 * 2.finally里面不建议放return语句
 */



