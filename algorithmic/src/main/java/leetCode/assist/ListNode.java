package leetCode.assist;

/**
 * @author hw
 * @version on 2020/3/13
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    public void print() {
        ListNode next = this;
        while (true){
            System.out.println(next.val);
            if(next.next == null){
                break;
            }
            next = next.next;
        }
    }

    public static ListNode convert2(int ...args){
        ListNode fake = new ListNode(-1);
        ListNode node = fake;
        for (int i = 0; i < args.length; i++) {
            node.next = new ListNode(args[i]);
            node = node.next;
        }
        return fake.next;
    }

    public static void main(String[] args) {
        ListNode node = convert2(1,3,4,4);
        node.print();
    }
}
