package javaSE.exceptionDemo.overrideDemo;


/**
 * 继承Father类，重写其dosome方法测试throws的
 * 重写要求
 * @author Administrator
 *
 */
public class Son extends Father{
	/**
	 * 在重写时可以不再throws声明任何异常的抛出
	 */
//	public void dosome(){
//		
//	}
	/**
	 * 在重写时可以只抛出父类该方法throws声明抛出的部分异常。
	 */
	//public void dosome() throws IOException {
    //
	//}
	/**
	 * 在重写时可以抛出父类该方法抛出的异常的子类异常。
	 */
	//public void dosome() throws FileNotFoundException{
    //
	//}
	/**
	 * 在重写时不允许抛出额外异常
	 */
	//public void dosome() throws SQLException {
    //
	//}
	/**
	 * 在重写时不允许抛出基类抛出的母异常
	 */
	//public void dosome() throws Exception{
    //
	//}
	
}





