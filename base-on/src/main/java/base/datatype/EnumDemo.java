package base.datatype;

/**
 * 枚举类型
 * @author hw
 * @version on 2019/4/20
 *
 * 所有的枚举都继承自java.lang.Enum类,
 * 由于Java 不支持多继承，所以枚举对象不能再继承其他类, 但是可以实现接口
 */
public class EnumDemo {

	public static void main(String[] args) {
		SolarSystem1[] ss = SolarSystem1.values();
		for (int i = 0; i < ss.length; i++) {
			System.out.println(ss[i].getName());
		}
		SolarSystem1 earth = SolarSystem1.EARTH;
		earth.show();

		SolarSystem sun = SolarSystem.SUN;
		System.out.println(sun.getName());
		SolarSystem earth2 = SolarSystem.EARTH;
		System.out.println(earth2.getName());
		SolarSystem mercury = SolarSystem.MERCURY;
		System.out.println(mercury.getName());
	}
}

//枚举类--此类的对象是有限的，如果只有一个的话就是单例模式
class SolarSystem implements Info{
	private String name;

	private SolarSystem(String name) {
		this.name = name;
	}

	public final static SolarSystem SUN = new  SolarSystem("太阳");
	public final static SolarSystem EARTH = new SolarSystem("earth");
	public final static SolarSystem MERCURY = new  SolarSystem("水星");

	public String getName() {
		return name;
	}

	@Override
	public void show() {
		/**
		 * 枚举对象比较直接用 ==
		 */
		System.out.println(DayOfWeek.Monday == DayOfWeek.Monday);
	}

}


enum DayOfWeek{
	Monday, Tuesday, Saturday
}



// 枚举	实现接口
enum SolarSystem1 implements Info {
	SUN("sun"), EARTH("earth"), MERCURY("mercury");

	private String name;

	private SolarSystem1(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public void show() {
		//枚举和switch case 的匹配
		switch (this) {
		case SUN:
			System.out.println("太阳是太阳系唯一的恒星和会发光的天体");
			break;
		case EARTH:
			System.out.println("地球是唯一有人类的星球");
			break;
		case MERCURY:
			System.out.println("水星是太阳系中最小的行星");
			break;
		}
	}
}


interface Info {
	void show();
}