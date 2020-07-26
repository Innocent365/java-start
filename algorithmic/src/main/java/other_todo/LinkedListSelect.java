package other_todo;


import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

public class LinkedListSelect {

    @Test
    public void test() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.addAll(Arrays.asList(1, 4, 6, 2, 7, 8, 13, 35, 34, 62, 42, 31));

        int k = 4;

        //单向链表，无法得知其个数，无法从后向前遍历
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

    @Test
    public static ListNode findKthToTail(ListNode head, int k) {
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
        System.out.println(findKthToTail(head, 1).value); // 倒数第一个
        System.out.println(findKthToTail(head, 5).value); // 中间的一个
        System.out.println(findKthToTail(head, 9).value); // 倒数最后一个就是顺数第一个
        System.out.println(findKthToTail(head, 10));
    }

}
