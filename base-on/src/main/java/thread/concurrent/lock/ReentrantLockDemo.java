package thread.concurrent.lock;

/**
 * 和synchronized关键字一样可以用来实现线程之间的同步互斥，
 *  但是在功能是比synchronized关键字更强大而且更灵活。
 *      synchronized关键字与wait()和notify/notifyAll()方法相结合可以实现等待/通知机制，
 *      ReentrantLock借助于Condition接口与newCondition() 方法
 *
 *
 *
 * Condition接口的常见方法：
 *      方法名称                                        描述
 *      void await()                                相当于Object类的wait方法
 *      boolean await(long time, TimeUnit unit)     相当于Object类的wait(long timeout)方法
 *      signal()                                    相当于Object类的notify方法
 *      signalAll()                                 相当于Object类的notifyAll方法
 *
 *
 *
 *
 * @author hw
 * @version on 2020/5/24
 */
public class ReentrantLockDemo {

}
