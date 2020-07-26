package leetCode;

import leetCode.assist.ListNode;

import java.util.List;

/**
 * @author hw
 * @version on 2020/3/13
 */
public class _23_MergeKLists {

    /**
     * 最简单的，重复n-1次
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length<1){
            return null;
        }
        ListNode node = lists[0];
        for (int i = 1; i < lists.length; i++) {
            node = _21_MergeTwoLists.mergeTwoLists2(node, lists[i]);
        }
        return node;
    }

    /**
     * 最简单的，重复n-1次 !!!还没写完
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode node = lists[0];
        dummy.next = node;

        for (int i = 1; i < lists.length; i++) {

            ListNode head = new ListNode(-1);
            ListNode tmp = head;

            boolean b;
            while (lists[i] != null){
                b = (node.val < lists[i].val);
                if(b){
                    tmp.next = new ListNode(node.val);
                    node = node.next;
                }else{
                    tmp.next = new ListNode(lists[i].val);
                    lists[i] = lists[i].next;
                }
                tmp = tmp.next;
            }
            if(node == null){
                tmp.next = lists[i];
            }else{
                tmp.next = node;
            }

            node = head.next;
        }
        return node;
    }

    public ListNode mergeKLists3(ListNode[] lists) {
        ListNode initNode = lists[0];
        ListNode node;
        for (int i = 1; i < lists.length; i++) {
            node = lists[i];
            while (node != null){
                ListNode copy = node;
                initNode = _21_MergeTwoLists.insertEle(initNode, copy);
                node = node.next;
            }
        }
        return initNode;
    }

    public static void main(String[] args) {
        ListNode nodes1 = new ListNode(1);
        nodes1.next = new ListNode(5);
        nodes1.next.next = new ListNode(7);
        nodes1.next.next.next = new ListNode(9);

        ListNode nodes2 = new ListNode(2);
        nodes2.next = new ListNode(4);
        nodes2.next.next = new ListNode(8);

        ListNode nodes3 = new ListNode(2);
        nodes3.next = new ListNode(3);
        nodes3.next.next = new ListNode(11);

        ListNode node = new _23_MergeKLists().mergeKLists3(
                new ListNode[]{nodes1, nodes2, nodes3});
        node.print();


    }
}
