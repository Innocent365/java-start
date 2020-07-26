package javaSE.exceptionDemo;


import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 简而言之，重写父类的方法时不可以抛出比父类“大”的（检查型）异常，或者干脆不抛。
 * 对于运行时异常（非检查型异常）则不限制
 *
 */
class Super {

	public void dosome() throws IOException, AWTException {

	}
}
public class ExtendsSuperException extends Super{
	/**
	 * 在重写时可以不再throws声明任何异常的抛出
	 */
	//public void dosome(){
	//
	//}
	/**
	 * 在重写时可以只抛出父类该方法throws声明抛出的部分异常。
	 */
	//public void dosome() throws IOException {
	//
	//}
	/**
	 * 在重写时可以抛出父类该方法抛出的异常的子类异常。
	 */
	//public void dosome() throws FileNotFoundException {
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






