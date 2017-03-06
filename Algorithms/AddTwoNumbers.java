/**
 * Created by huqiu on 17-3-6.
 * Not simplest and elegant, but faster than Editorial Solution.
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(-1);
        ListNode p = ans;
        int carry = 0;
        while(l1 != null && l2 != null) {
            int dig = l1.val + l2.val + carry;
            if (dig >= 10) {
                carry = 1;
                dig = dig % 10;
            }
            else carry = 0;
            ListNode fresh = new ListNode(dig);
            fresh.next = null;
            p.next = fresh;
            p = fresh;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int dig = l1.val + carry;
            if (dig >= 10) {
                carry = 1;
                dig = dig % 10;
            }
            else carry = 0;
            ListNode fresh = new ListNode(dig);
            fresh.next = null;
            p.next = fresh;
            p = fresh;
            l1 = l1.next;
        }
        while (l2 != null) {
            int dig = l2.val + carry;
            if (dig >= 10) {
                carry = 1;
                dig = dig % 10;
            }
            else carry = 0;
            ListNode fresh = new ListNode(dig);
            fresh.next = null;
            p.next = fresh;
            p = fresh;
            l2 = l2.next;
        }
        if (carry > 0) {
            ListNode fresh = new ListNode(1);
            fresh.next = null;
            p.next = fresh;
        }
        ans = ans.next;
//        while(ans.next != null) {
//            System.out.print(ans.val + " ");
//            ans = ans.next;
//        }
//        System.out.print(ans.val + " ");
        return ans;
    }
    public static void main(String[] args) {
        ListNode b = new ListNode(9);
        b.next = new ListNode(9);
        ListNode p = b.next;
        for (int i=0;i<40;i++) {
            p.next = new ListNode(9);
            p = p.next;
        }
        ListNode a = new ListNode(1);
//        b.next = new ListNode(6);
//        b.next.next = new ListNode(4);
//        b.next.next.next = new ListNode(9);
        AddTwoNumbers atn = new AddTwoNumbers();
        atn.addTwoNumbers(a, b);
    }
}




