package base.keyword;

import java.util.HashMap;

/**
 * super关键字:
 *     指代当前对象的父类对象
 *      super.成员变量
 *      super.方法名()
 *      super()
 */
public class SuperDemo extends HashMap {

    //问:构造方法可以继承吗?
    //不是被继承的，而是被调用的(super)
/**
 * 有人会说：“super.代表的就是一个父类对象，因为他指向父类” ：
 * 　　其实super.不是“东西”，说道super.自然会想到this.，有人把他们归为同类，其实他们大大不。
 * 		this：是一个真真实实对象，代表的就是当前对象，可以用 return this; 去返回一个对象。
 * 		super：不能一个对象，不是指向父类对象的意思，
 * 		super只是修饰了他后边的内容，告诉JVM，后面这部分内容不是当前对象所属类的内容而已，若用return super，JVM是不允许的，是一种错误的语法。
 */

}
