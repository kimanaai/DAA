class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements(head.next, val);
        if (head.val == val) {
            return head.next;
        }
        return head;
    }
}

public class Main {
    public static void main(String[] args) {
        // 1 -> 2 -> 6 -> 3 -> 6
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(6);

        Solution s = new Solution();
        ListNode result = s.removeElements(head, 6);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}