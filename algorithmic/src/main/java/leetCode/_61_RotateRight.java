package leetCode;

import leetCode.assist.ListNode;

/**
 * @author hw
 * @version on 2020/3/14
 */
@SuppressWarnings("ALL")
public class _61_RotateRight {
    public ListNode rotateLeft(ListNode head, int k) {
        if(head==null || head.next == null){
            return head;
        }

        ListNode fakeList = new ListNode(-1);
        ListNode it = new ListNode(-1);
        fakeList.next = it;

        ListNode node = head;
        while (true){
            ListNode tmp = node;
            if(tmp == null || tmp.next==null || k-- ==0) {
                it.next = node;
                break;
            }
            while (tmp.next.next != null){
                tmp = tmp.next;
            }
            it.next = tmp.next;
            it = it.next;


            tmp.next = null;
        }
        return fakeList.next.next;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next == null || k==0){
            return head;
        }

        ListNode fake = new ListNode(-1);
        fake.next = head;

        ListNode left = fake;
        ListNode right = fake;

        for (int i = 0; i < k; i++) {
            right = right.next;
            if(right.next == null){
                if(i==k-1){
                    return head;
                }else{
                    right = fake;
                }
            }
        }

        while (right.next != null){
            left = left.next;
            right = right.next;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = left.next;
        right.next = head;
        left.next = null;

        return dummy.next;
    }

    /**
     * 大k优化
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight2(ListNode head, int k) {
        if(head==null || head.next == null || k==0){
            return head;
        }

        ListNode fake = new ListNode(-1);
        fake.next = head;

        ListNode left = fake;
        ListNode right = fake;
        int length = 0;

        for (int i = 0; i < k; i++) {
            right = right.next;
            if(right.next == null) {
                length = i + 1;
                break;
            }
        }

        if(length > 0){
            if(k%length == 0){
                return head;
            }
            right = fake;
            for (int i = 0; i < k % length; i++) {
                right = right.next;
            }
        }

        while (right.next != null){
            left = left.next;
            right = right.next;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = left.next;
        right.next = head;
        left.next = null;

        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode nodes1 = new ListNode(1);
        nodes1.next = new ListNode(5);
        nodes1.next.next = new ListNode(7);
        nodes1.next.next.next = new ListNode(9);
        nodes1.next.next.next.next = new ListNode(8);
        //ListNode node = reverse(nodes1);
        //ListNode node = new _61_ReverseKGroup().rotateLeft(nodes1, 3);
        ListNode node = new _61_RotateRight().rotateRight2(nodes1, 7);
        node.print();

        //ListNode nodes2 = new ListNode(1);
        //nodes2.next = new ListNode(5);
        //ListNode node = new _24_SwapPairs().swapPairs(nodes2);
        //node.print();

        //ListNode nodes3 = new ListNode(1);
        //ListNode node = reverse(nodes3);
        //ListNode node = new _61_ReverseKGroup().rotateRight(nodes3, 2);
        //node.print();



    }

}
