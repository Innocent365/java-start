package thread.multhreadsafe.volatileKeyword;

/**
 *
 * volatile用在单例模式，保证不会对象不会被重复创建
 * 双重检查锁定
 *
 */
public class Singleton {
    private volatile static Singleton instance = null;

    private Singleton() {

    }

    //懒汉的单例模式，使用时才创建对象
    public static Singleton getInstance() {
        if (instance == null) {
            //双重检查，避免指令重排序
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
