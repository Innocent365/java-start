package leetCode;

import leetCode.assist.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hw
 * @version on 2020/3/14
 */
@SuppressWarnings("ALL")
public class _25_ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }

        ListNode fake = new ListNode(-1);
        fake.next = head;

        ListNode left = fake.next;
        ListNode right = fake;

        List<ListNode> list = new ArrayList<ListNode>();

        ListNode newStart = null;
        ListNode remain = null;
        while (true){
            for (int i = 0; i < k; i++) {
                right = right.next;
                if(right == null){
                    remain = left;
                    break;
                }
            }
            if(left == null){
                break;
            }
            if(remain == null){
                if(right != null){
                    newStart = new ListNode(-1);
                    newStart.next = right.next;
                    right.next = null;

                    ListNode swapPart = reverse(left);
                    list.add(swapPart);

                    right = newStart;
                    left = newStart.next;
                }else{
                    ListNode swapPart = reverse(left);
                    list.add(swapPart);
                    break;
                }
            }else{
                list.add(remain);
                break;
            }
        }
        //{{5,1},{9,8},{7}}
        ListNode node = null;
        for (int i = 0; i < list.size(); i++) {
            node = list.get(i);
            while (node.next != null){
                node = node.next;
            }
            if(i+1 < list.size()){
                node.next = list.get(i+1);
            }
        }

        return list.get(0);
    }


    /**
     * 翻转一个单向列表
     *
     * @param head
     * @return
     */
    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fakeList = new ListNode(-1);
        ListNode it = new ListNode(-1);
        fakeList.next = it;

        ListNode node = head;
        while (true) {
            ListNode tmp = node;
            if (tmp == null || tmp.next == null) {
                it.next = tmp;
                break;
            }

            while (tmp.next.next != null) {
                tmp = tmp.next;
            }
            it.next = tmp.next;
            tmp.next = null;
            it = it.next;
        }
        return fakeList.next.next;
    }

    /**
     * 翻转一个单向列表(返回首尾节点)
     *
     * @param head
     * @return
     */
    //public static ListNode[] reverse(ListNode head) {
    //    if (head == null || head.next == null) {
    //        return head;
    //    }
    //
    //    ListNode fakeList = new ListNode(-1);
    //    ListNode it = new ListNode(-1);
    //    fakeList.next = it;
    //
    //    ListNode node = head;
    //    while (true) {
    //        ListNode tmp = node;
    //        if (tmp == null || tmp.next == null) {
    //            it.next = tmp;
    //            break;
    //        }
    //
    //        while (tmp.next.next != null) {
    //            tmp = tmp.next;
    //        }
    //        it.next = tmp.next;
    //        tmp.next = null;
    //        it = it.next;
    //    }
    //    return fakeList.next.next;
    //}

    public static void main(String[] args) {
        ListNode nodes1 = new ListNode(1);
        nodes1.next = new ListNode(5);
        nodes1.next.next = new ListNode(7);
        nodes1.next.next.next = new ListNode(9);
        nodes1.next.next.next.next = new ListNode(8);
        nodes1.next.next.next.next.next = new ListNode(10);
        //ListNode node = reverse(nodes1);
        ListNode node = new _25_ReverseKGroup().reverseKGroup(nodes1, 2);
        node.print();
    }
}
