package collection;

import org.junit.Test;


import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;


public class _7_LinkedListDemo {

    @Test
    //队列入出乱搞，不可取
    public void test() {
        Deque list = new LinkedList<Integer>(Arrays.asList(1, 4, 6, 2, 7, 8, 13, 35, 34, 62, 42, 31));

        list.offer(12);//从队尾进去 1, 4, 6, 2, 7, 8, 13, 35, 34, 62, 42, 31，12
        list.pop();//从队首出来 4, 6, 2, 7, 8, 13, 35, 34, 62, 42, 31，12

        list.poll();//从队首弹出 6, 2, 7, 8, 13, 35, 34, 62, 42, 31，12
        list.push(15);//从队首压入 15，6, 2, 7, 8, 13, 35, 34, 62, 42, 31，12
        list.stream().forEach(System.out::println);

        //单向链表，无法得知其个数，无法从后向前遍历
        //int k = 4;
        //System.out.println(list.get(list.size()-k));
//
//        for (int i = 0; i < k; i++) {
//            list.pop();
//            if(i==3) System.out.println(list.pop());
//        }
    }

    public static class ListNode {
        int value;
        ListNode next;
    }

    public ListNode findKthToTail(ListNode head, int k) {
        // 输入的链表不能为空，并且k大于0
        if (k < 1 || head == null) {
            return null;
        }
        // 指向头结点
        ListNode pointer = head;
        // 倒数第k个结点与倒数第一个结点相隔k-1个位置

        // pointer先走k-1个位置, 若 已经没有节点了，但是i还没有到达k-1说明k太大，链表中没有那么多的元素
        for (int i = 1; i < k; i++) {
            if (pointer.next != null) {
                pointer = pointer.next;
            }
            else {
                return null;
            }
        }
        // pointer还没有走到链表的末尾，那么pointer和head一起走，
        // 当pointer走到最后一个结点即，pointer.next=null时，head就是倒数第k个结点
        while (pointer.next != null) {
            head = head.next;
            pointer = pointer.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        head.value = 1;
        head.next = new ListNode();
        head.next.value = 2;
        head.next.next = new ListNode();
        head.next.next.value = 3;
        head.next.next.next = new ListNode();
        head.next.next.next.value = 4;
        head.next.next.next.next = new ListNode();
        head.next.next.next.next.value = 5;
        head.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.value = 6;
        head.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.value = 7;
        head.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.value = 8;
        head.next.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.next.value = 9;
        _7_LinkedListDemo demo = new _7_LinkedListDemo();
        System.out.println(demo.findKthToTail(head, 1).value); // 倒数第一个
        System.out.println(demo.findKthToTail(head, 5).value); // 中间的一个
        System.out.println(demo.findKthToTail(head, 9).value); // 倒数最后一个就是顺数第一个
        System.out.println(demo.findKthToTail(head, 10));
    }

}
/**
 *  * 栈：存储一组元素，存取必须遵循先进后出原则
 *  * 通常用来完成具有后退功能操作的地方。
 */
class StackDemo1 {
    public static void main(String[] args) {
        Deque<String> stack = new LinkedList<String>();
        /*
         * void push(E e)
         * 入栈操作
         * 向栈中添加一个元素
         */
        stack.push("one");
        stack.push("two");
        stack.push("three");
        stack.push("four");

        System.out.println(stack);
        /*
         * 将栈顶元素获取
         * 出栈操作
         * E pop()
         */
        String str = stack.pop();
        System.out.println(str);
        System.out.println(stack);

        /*
         * E peek()
         * 仅引用栈顶元素，不做出栈操作
         */
        str = stack.peek();
        System.out.println(str);
        System.out.println(stack);

        /*
         * 遍历栈也是一次性的。
         */
        while (stack.size() > 0) {
            str = stack.pop();
            System.out.println(str);
        }
        System.out.println(stack);

    }
}
