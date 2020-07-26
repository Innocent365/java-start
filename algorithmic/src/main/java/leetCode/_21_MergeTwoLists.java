package leetCode;

import leetCode.assist.ListNode;

import java.util.List;

/**
 * @author hw
 * @version on 2020/3/13
 */
public class _21_MergeTwoLists {
    /**
     * 将（单个元素）链表插入另一个列表
     * @return
     */
    public static ListNode insertEle(ListNode node, ListNode single){
        ListNode dummy = new ListNode(-1);
        dummy.next = node;

        if(single.val < node.val){
            single.next = node;
            dummy.next = single;
            return dummy.next;
        }
        while (true){
            //if(single.val < node.val){
            //    break;
            //}
            if(node.next == null){
                break;
            }
            if(single.val < node.next.val){
                break;
            }
            node = node.next;
        }
        ListNode tmp = node.next;
        node.next = single;
        single.next = tmp;
        return dummy.next;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(-1);
        ListNode tmp = node;
        while (true){
            int val = l2.val;
            ListNode node1 = getJoinNode(val, l1);
            l1.next = node1;

            l2 = l2.next;
            if(l2 == null){
                break;
            }
        }
        return node.next;
    }

    public static ListNode getJoinNode(int num, ListNode node){
        ListNode dummy = new ListNode(-1);
        dummy.next = node;
        ListNode last = null;
        while (node.next != null && num > node.val){
            last = node;
            node = node.next;
        }
        last.next = null;
        return last;
    }

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(-1);
        ListNode tmp = node;
        boolean b;
        while (l1 != null && l2 != null){
            b = (l1.val < l2.val);
            if(b){
                tmp.next = new ListNode(l1.val);
                l1 = l1.next;
            }else{
                tmp.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            tmp = tmp.next;
        }
        if(l1 == null){
            tmp.next = l2;
        }else{
            tmp.next = l1;
        }

        return node.next;
    }

    public static void main(String[] args) {
        ListNode nodes1 = new ListNode(1);
        nodes1.next = new ListNode(5);
        nodes1.next.next = new ListNode(7);
        nodes1.next.next.next = new ListNode(9);

        ListNode nodes2 = new ListNode(2);
        nodes2.next = new ListNode(4);
        nodes2.next.next = new ListNode(8);

        //ListNode node = mergeTwoLists2(nodes1, nodes2);
        //node.print();

        //ListNode loc = getJoinNode(3, nodes2);
        //loc.print();
        ListNode listNode = insertEle(nodes1, new ListNode(10));
        listNode.print();

    }
}
