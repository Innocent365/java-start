package javaSE.annotate;



import javax.swing.JFrame;

//定义在java.lang.SuppressWarnings中，用来抑制编译时的警告信息

@SuppressWarnings("all")

public class SystemAnnotation {

	public static void main(String[] args) {

		int age =18 ;

		

		JFrame f = new JFrame();

		f.setVisible(true);

		f.show();

	}

	//定义在java.lang.Deprecated中，此注释可用于修辞方法，属性，类

	//表示不建议使用，存在危险或者有更好的选择

	@Deprecated
	public void method(){

	}

}

