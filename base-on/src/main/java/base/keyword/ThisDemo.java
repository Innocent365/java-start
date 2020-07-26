package base.keyword;

/**
 *  this关键字:
 * 		1)指代当前对象，哪个对象调指的就是哪个对象
 * 		2)用法：
 * 			this.成员变量名	-------访问成员变量
 * 			this.方法名()	-------调用方法
 * 			this()			-------调用构造方法
 */
public class ThisDemo {
    int age;
    String name;

    public ThisDemo() {
        this(18);
    }

    public ThisDemo(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ThisDemo thisDemo = (ThisDemo) o;

        if (age != thisDemo.age) return false;
        return name != null ? name.equals(thisDemo.name) : thisDemo.name == null;

    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
