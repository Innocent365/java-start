package jvm.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xms20m -Xmx20m
 * 限制java堆的大小为20M，不可扩展（最小和最大）
 *
 * -XX:+HeapDumpOnOutOfMemoryError
 * 让虚拟机在出现内存溢出异常的时候Dump出当前的内存转储快照以便事后分析
 *
 * @author hw
 * @version on 2020/4/19
 */
public class HeapOOM {
    static class OOMObject{}

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();

        while (true){
            list.add(new OOMObject());
        }
    }
}
