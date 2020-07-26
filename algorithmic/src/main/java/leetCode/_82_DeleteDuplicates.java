package leetCode;

import leetCode.assist.ListNode;

/**
 * @author hw
 * @version on 2020/3/15
 */
public class _82_DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next == null){
            return head;
        }

        ListNode fake = new ListNode(-1);
        fake.next = head;

        ListNode left = fake;
        ListNode right = fake.next;
        while (right.next != null){
            right = right.next;
            if(left.next.val == right.val){
                while (left.next.val == right.val){
                    right = right.next;
                    if(right == null) {
                        left.next = null;
                        return fake.next;
                    }
                }
                left.next = right;
            }else{
                left = left.next;
            }
        }
        return fake.next;
    }

    public static void main(String[] args) {
        //ListNode nodes1 = new ListNode(1);
        //nodes1.next = new ListNode(2);
        //nodes1.next.next = new ListNode(3);
        //nodes1.next.next.next = new ListNode(4);
        //nodes1.next.next.next.next = new ListNode(4);
        //nodes1.next.next.next.next.next = new ListNode(10);
        //ListNode node = new _82_DeleteDuplicates().deleteDuplicates(nodes1);
        //node.print();

        //ListNode nodes2 = new ListNode(1);
        //nodes2.next = new ListNode(1);
        //nodes2.next.next = new ListNode(1);
        //nodes2.next.next.next = new ListNode(2);
        //nodes2.next.next.next.next = new ListNode(3);
        //nodes2.next.next.next.next.next = new ListNode(3);
        //ListNode node = new _82_DeleteDuplicates().deleteDuplicates(nodes2);
        //node.print();

        //ListNode nodes3 = new ListNode(1);
        ////nodes3.next = new ListNode(1);
        ////nodes3.next.next = new ListNode(1);
        //ListNode node = new _82_DeleteDuplicates().deleteDuplicates(nodes3);
        //node.print();

        ListNode node = new _82_DeleteDuplicates().deleteDuplicates(null);
        node.print();
    }
}
