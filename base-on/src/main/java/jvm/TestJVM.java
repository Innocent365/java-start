package jvm;



import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TestJVM {

    static int stackIndex = 0;

    public static void main(String[] args) {
        System.setProperties(new Properties());
        //JAVA堆内存溢出，堆里面存放的是对象的实例！！！ 这两种情况都会抛出OutOfMemoryError:java heap space异常：
        List<Object> list = new ArrayList<>();
        List<Object> list2 = new ArrayList<>();
        int count = 0;
        //while (true){ //1.内存泄漏是指对象实例在新建和使用完毕后，仍然被引用，没能被垃圾回收释放，一直积累，直到没有剩余内存可用。
        //    list.add(new FuncParameterReferDemo());
        //    list2.add(new ArrayDemo());
        //    System.out.println(count++);
        //}

        while (true) {  //2.内存溢出: 指当我们新建一个实力对象时，实例对象所需占用的内存空间大于堆的可用空间
            List<byte[]> byteList = new ArrayList<byte[]>();
            byteList.add(new byte[1000 * 1024 * 1024* 1024]);
        }
    }

    @Test//栈内存溢出，栈是线程执行时分配的内存空间
    public void testStackOverflow() {
        try {
            //1.StackOverflowError(方法调用层次太深，内存不够新建栈帧)虚拟机在扩展栈深度时无法申请到足够的内存空间，将抛出
            incre();
            //2.OutOfMemoryError（线程太多，内存不够新建线程）虚拟机在扩展栈深度时无法申请到足够的内存空间，将抛出
        }catch (Exception ex){
            System.out.println(ex.getStackTrace());
        }
    }

    public void incre() {
        stackIndex ++ ;
        incre();
    }

}
