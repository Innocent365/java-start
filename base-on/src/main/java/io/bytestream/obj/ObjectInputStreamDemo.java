package io.bytestream.obj;


import model.Person;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * java.io.ObjectInputStream
 * 用于读取一组字节，然后转换为对应的对象。
 * 将字节转换为数据结构的过程称为:反序列化
 * 这里就是进行对象的反序列化
 * 
 * 读写对象的目的一般有两个:
 * 1:保存对象
 * 2:传输对象
 *
 */
public class ObjectInputStreamDemo {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//创建读取文件的字节输入流
		FileInputStream fis = new FileInputStream("person.obj");
		
		//创建用于反序列化对象的对象输入流
		ObjectInputStream ois = new ObjectInputStream(fis);
		/*
		 * Object readObject() 读取若干字节并转换为对应的对象
		 */
		Person p = (Person)ois.readObject();
		System.out.println(p);
		
		ois.close();
	}
}






