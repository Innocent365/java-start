package leetCode;

import leetCode.assist.ListNode;

/**
 * @author hw
 * @version on 2020/3/14
 */
public class _24_SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode node = dummy;
        while (node != null){
            ListNode before = node.next;
            ListNode after = before.next;

            before.next = after.next;
            after.next = before;
            node.next = after;

            if(before.next != null && before.next.next!=null){
                node = node.next.next;
            }else {
                break;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode nodes1 = new ListNode(1);
        nodes1.next = new ListNode(5);
        nodes1.next.next = new ListNode(7);
        nodes1.next.next.next = new ListNode(9);
        nodes1.next.next.next.next = new ListNode(8);

        //ListNode node = new _24_SwapPairs().swapPairs(nodes1);
        //node.print();

        ListNode nodes2 = new ListNode(1);
        nodes2.next = new ListNode(5);
        //ListNode node = new _24_SwapPairs().swapPairs(nodes2);
        //node.print();

        //ListNode nodes3 = new ListNode(1);
        //ListNode node = new _24_SwapPairs().swapPairs(nodes3);
        //node.print();

        ListNode node = new _24_SwapPairs().swapPairs(null);
        node.print();
    }
}
