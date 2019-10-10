package javaSE.ioStream._9.obj;

import java.io.Serializable;
import java.util.List;

/**
 * 用来测试对象流读写对象使用
 * @author Administrator
 *
 */
public class PersonSerializable implements Serializable{
	/**
	 * 版本号的作用: 版本号影响着反序列化的结果。
	 * 当我们需要反序列一个之前序列化的对象时:
	 * 		若该对象的类内容发生了修改,在反序列化时，OIS会检查之前的对象版本与现在类的版本是否一致:
	 * 	1:一致，那么启用兼容模式。现在类中的属性在之前对象上有的，就使用，没有的就忽略。
	 *  	现在类新的属性，原来对象中没有的，就使用默认值。
	 * 	2:不一致，readObject方法会直接抛出异常。反序列化失败。
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private String gender;
	private transient List<String> otherInfo;
	public PersonSerializable(){
		
	}

	public PersonSerializable(String name, int age, String gender, List<String> otherInfo) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.otherInfo = otherInfo;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<String> getOtherInfo() {
		return otherInfo;
	}


	public void setOtherInfo(List<String> otherInfo) {
		this.otherInfo = otherInfo;
	}


	public String toString(){
		return name+","+age+","+
		       gender+","+otherInfo;
	}
}



