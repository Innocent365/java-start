package javaSE.exceptionDemo;

/**
 * 该异常表示年龄不合法
 * @author Administrator
 *	
 >>>Generate>>>Constructor
 */
public class IllegalAgeException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public IllegalAgeException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IllegalAgeException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public IllegalAgeException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public IllegalAgeException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}

class Person {
    private int age;

    public int getAge() {
        return age;
    }
    /**
     * 通常，方法中使用throw抛出什么异常，方法声明的时候就要使用throws定义该异常的抛出。
     * 方法上若使用throws声明了某些异常的抛出时，那么外界在调用该方法的时候就有一个强制要求，必须处理这些异常。
     * 处理的手段有两种:
     * 		try-catch捕获该异常。
     * 		接着向外抛出。
     * 需要注意，当我们使用throw抛出的不是 RuntimeException及其子类异常时，就必须处理这个异常。
     *
     * @param age
     * @throws IllegalAgeException
     */
    public void setAge(int age) throws IllegalAgeException{
        if(age<0||age>100){
            throw new IllegalAgeException(
                    "不符合人类年龄"
            );
        }
        this.age = age;
    }


    public static void main(String[] args) {
        Person p = new Person();
        try {
            p.setAge(1000);
        } catch (IllegalAgeException e) {
            e.printStackTrace();
        }//这里会抛出异常。
        System.out.println(
                "他的年龄是:"+p.getAge());
    }
}








