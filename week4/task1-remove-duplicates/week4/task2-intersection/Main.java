class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode a = headA, b = headB;

        while (a != null) { lenA++; a = a.next; }
        while (b != null) { lenB++; b = b.next; }

        a = headA;
        b = headB;

        while (lenA > lenB) { a = a.next; lenA--; }
        while (lenB > lenA) { b = b.next; lenB--; }

        while (a != b) {
            a = a.next;
            b = b.next;
        }
        return a;
    }
}

public class Main {
    public static void main(String[] args) {
        // общая часть: 8 -4 -5
        ListNode common = new ListNode(8);
        common.next = new ListNode(4);
        common.next.next = new ListNode(5);

        // A: 4 - 1 - 8 -4 - 5
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = common;

        // B: 5 - 6 - 1 - 8 - 4 - 5
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = common;

        Solution s = new Solution();
        ListNode result = s.getIntersectionNode(headA, headB);

        if (result != null) {
            System.out.println("Intersection at: " + result.val);
        } else {
            System.out.println("No intersection");
        }
    }
}