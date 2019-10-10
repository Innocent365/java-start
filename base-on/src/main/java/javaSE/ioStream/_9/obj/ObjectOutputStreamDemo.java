package javaSE.ioStream._9.obj;


import model.Person;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 对象流，是一组高级流。特点:可以方便的读写java中的任何对象。
 * OOS:对象输出流，可以将给定的对象转换为一组字节然后写出。
 * OIS:对象输入流，可以将读取回来的一组字节转换为对应的对象。前提是，读取的字节必须是由OOS将对象转换的那一组字节才可以。
 *
 */
public class ObjectOutputStreamDemo {
	public static void main(String[] args) throws IOException {
		Person p = new Person();
		p.setName("苍老师");
		p.setAge(30);
		p.setGender("女");
		List<String> otherInfo = new ArrayList<String>();
		otherInfo.add("写大字");
		otherInfo.add("唱歌");
		otherInfo.add("拍电影");
		p.setOtherInfo(otherInfo);
		
		System.out.println(p);
		/*
		 * 将Person对象写入文件
		 * 若想将对象写入文件，需要先将对象转换为一组对应的字节才能写出。这时我们就可以使用高级流ObjectOutputStream了
		 * 
		 * 分工:
		 * 使用FileOutputStream将字节写入文件。使用ObjectOutputStream将Person对象转换为字节。
		 * 若使用OOS处理FOS。就可以叠加效果为:将Person对象通过OOS转换为对应的字节，然后再通过FOS将这些字节写入到文件中。
		 * 
		 */

		//创建用于向文件中写入字节的FOS
		/*
		 * 数据通过FOS写入文件(硬盘上)做长久保存的过程称为:持久化
		 */
		FileOutputStream fos = new FileOutputStream("person.obj");
		
		//创建OOS用于将给定对象转换为字节写出
		/*
		 * 将一个数据结果转换为一组字节的过程称为: 序列化
		 * 将一个对象转换为一组字节的过程称为: 对象序列化。
		 */
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		/*
		 * OOS提供了一个独有的方法 writeObject(Object obj) 该方法可以将给定的对象转换为一组字节然后写出。
		 * 
		 */
		oos.writeObject(p);
		
		oos.close();
	}
}








