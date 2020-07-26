package leetCode;

import leetCode.assist.ListNode;

import java.util.List;

/**
 * 强打强上
 * @author hw
 * @version on 2020/3/15
 */
public class _86_Partition {
    public ListNode partition(ListNode head, int x) {
        if(head==null || head.next == null){
            return head;
        }

        ListNode fake = new ListNode(-1);
        fake.next = head;

        ListNode left = fake;
        ListNode right = fake;
        while (true){
            while (right.next.val < x){
                left = left.next;
                right = right.next;
                if(right.next == null){
                    return fake.next;
                }
            }
            while (right.next.val >= x){
                right = right.next;
                if(right.next == null){
                    return fake.next;
                }
            }
            while (right.next.val < x){
                ListNode before = left.next;
                ListNode after = right.next;

                right.next = after.next;
                after.next = before;
                left.next = after;

                left = left.next;
                if(right.next == null){
                    return fake.next;
                }
            }
        }
    }

    public static void main(String[] args) {
        //ListNode nodes1 = ListNode.convert2(1,2,3,4,3,2,5,3);
        //ListNode node = new _86_Partition().partition(nodes1,3);
        //node.print();

        //ListNode nodes2 = ListNode.convert2(1,2,3,4,3,2,1);
        //ListNode node = new _86_Partition().partition(nodes2,3);
        //node.print();

        //ListNode nodes3 = ListNode.convert2(3,1,3,4,3,2,1);
        //ListNode node = new _86_Partition().partition(nodes3,3);
        //node.print();

        ListNode nodes4 = new ListNode(2);
        ListNode node = new _86_Partition().partition(null,3);
        node.print();
    }
}
