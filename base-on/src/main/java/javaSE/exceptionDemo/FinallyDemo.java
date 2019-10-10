package javaSE.exceptionDemo;
/**
 * finally面试题
 * @author Administrator
 *
 */
public class FinallyDemo {
	public static void main(String[] args) {
		System.out.println(
			test("0")  + "," +
			test(null) + "," +
			test("")
		);
		
	}
	
	public static int test(String str){
		try {
			return '0'-str.charAt(0);
		} catch (NullPointerException e) {
			return 1;
		} catch (Exception e){
			return 2;
		} finally{
			return 3;
		}
	}
}




