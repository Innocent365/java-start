package leetCode;

import leetCode.assist.ListNode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 所有情况：
 * 1.两个数最高位（链最深层）相加超出10，没进位
 * 2.一个表比另一个表短：
 *
 *      短链的最高位n相加时有进位:
 *          长链处于n+1位置刚好是9
 *              长链处于n+2位置也刚好是9
 *
 * @author hw
 * @version on 2020/3/6
 */
@SuppressWarnings("ALL")
public class _2_AddTwoNumbers {

    /**
     * 不考虑l1和l2长度
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode temp = l3;
        do{
            temp.val += l1.val + l2.val;
            temp.next = new ListNode(0);
            if(temp.val >= 10){
                temp.val %= 10;
                temp.next.val ++;
            }
            l1 = l1.next;
            l2 = l2.next;
            temp = temp.next;
        }while(l1 != null || l2 != null);
        return l3;
    }

    /**
     * 考虑长度，但是链表最后一个始终是多余的0
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode temp = l3;
        do{
            temp.val += (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);
            temp.next = new ListNode(0);
            if(temp.val >= 10){
                temp.val %= 10;
                temp.next.val ++;
            }
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
            temp = temp.next;
        }while(l1 != null || l2 != null);
        return l3.next;
    }

    /**
     * 完整的一个
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode temp = l3;
        ListNode last = null;
        while (true){
            if(l1 != null || l2 != null) {
                temp.val += (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);
                temp.next = new ListNode(0);
                if (temp.val >= 10) {
                    temp.val %= 10;
                    temp.next.val++;
                }
                l1 = l1 != null ? l1.next : null;
                l2 = l2 != null ? l2.next : null;
                last = temp;
                temp = temp.next;
            }else {
                if(temp.val == 0) {
                    last.next = null;
                }
                break;
            }
        }
        return l3;
    }

    /**
     * 长链单独进位的问题搞复杂了
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers4(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        l3.next = new ListNode(0);
        ListNode temp = l3;
        boolean carry = false;

        while (l1 != null && l2 != null) {
            temp.next = new ListNode(0);
            temp = temp.next;
            temp.val = l1.val + l2.val + (carry ? 1 : 0);

            if (temp.val >= 10) {
                temp.val %= 10;
                carry = true;
            }else {
                carry = false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        if(l1 == null && l2 == null){
            temp.next = null;
        }else if (l1 == null) {
            temp.next = l2;
        }else {
            temp.next = l1;
        }
        if(temp.next != null){
            while (carry){
                if(temp.next == null){
                    temp.next = new ListNode(1);
                    break;
                }
                temp.next.val ++;
                if(temp.next.val >= 10){
                    temp.next.val %= 10;
                    carry = true;
                    temp = temp.next;
                }else{
                    break;
                }
            }
        }else if (carry) {
            temp.next = new ListNode(1);
        }
        return l3.next;
    }

    /**
     * 修改得到我的最佳答案
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers5(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        boolean carry = false;
        while (l1 != null || l2 != null || carry){
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + (carry?1:0);
            temp.next = new ListNode(sum % 10);
            if(sum/10>0){
                carry = true;
            }else{
                carry = false;
            }
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
            temp = temp.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(7);
        l2.next.next = new ListNode(2);
        //l2.next.next.next = new ListNode(9);
        //l2.next.next.next.next = new ListNode(9);
        //l2.next.next.next.next.next = new ListNode(9);
        //l2.next.next.next.next = new ListNode(2);

        ListNode result = new _2_AddTwoNumbers().addTwoNumbers5(l1, l2);
        result.print();
    }
}
