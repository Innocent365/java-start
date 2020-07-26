package leetCode;

import leetCode.assist.ListNode;

/**
 * @author hw
 * @version on 2020/3/13
 */
public class _19_RemoveNthFromEnd {
    public ListNode getNthFromStart(ListNode head, int n) {
        ListNode first = new ListNode(0);
        first.next = head;
        ListNode currentNode = first;
        while (n-->0){
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    public ListNode getNthFromEnd(ListNode head, int n) {
        ListNode point1 = head, point2 = head;
        for (int i = 1;; i++) {
            point2 = point2.next;
            if(i<n){
                continue;
            }
            if(point2.next == null){
                return point1.next;
            }
            point1 = point1.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null){
            return null;
        }
        ListNode left = head;
        ListNode right = head;
        int i = 1;
        while (true){
            right = right.next;
            if(i++<n){
                continue;
            }
            if(right == null){
                return head.next;
            }
            if(right.next == null){
                left.next = left.next.next;
                return head;
            }
            left = left.next;
        }
    }

    /**
     * copy
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n){
        if(head == null) return head;

        // 快慢指针
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        ListNode q = dummy;
        for (int i=0 ; i<n; i++) {
            p = p.next;
        }
        while (p.next != null) {
            p = p.next;
            q = q.next;
        }
        // 删除目标节点
        q.next = q.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode nodes = new ListNode(5);
        nodes.next = new ListNode(7);
        nodes.next.next = new ListNode(2);
        nodes.next.next.next = new ListNode(3);
        nodes.next.next.next.next = new ListNode(6);
        nodes.next.next.next.next.next = new ListNode(12);
        nodes.next.next.next.next.next.next = new ListNode(8);
        nodes.next.next.next.next.next.next.next = new ListNode(2);

        //ListNode aNode = new _19_RemoveNthFromEnd().getNthFromStart(nodes, 1);
        //System.out.println(aNode.val);

        //ListNode bNode = new _19_RemoveNthFromEnd().getNthFromEnd(nodes, 3);
        //System.out.println(bNode.val);

        //ListNode nodes2 = new ListNode(5);
        //nodes2.next = new ListNode(7);
        //nodes2.next.next = new ListNode(2);
        //ListNode cNode = new _19_RemoveNthFromEnd().removeNthFromEnd(nodes2, 3);
        //cNode.print();

        //ListNode c2Node = new _19_RemoveNthFromEnd().removeNthFromEnd(nodes, 8);
        //c2Node.print();
        //
        ListNode dNode = new _19_RemoveNthFromEnd().removeNthFromEnd(new ListNode(7), 1);
        dNode.print();
    }
}
