class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class YY03 {

    public static ListNode sortGroup(ListNode head, int n) {
        if (head == null || n <= 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroupEnd = dummy;

        while (head != null) {
            ListNode groupStart = head;

            ListNode groupEnd = head;
            for (int i = 1; i < n && groupEnd.next != null; i++) {
                groupEnd = groupEnd.next;
            }

            head = groupEnd.next;

            groupEnd.next = null;

            ListNode sortedGroup = sortList(groupStart);

            prevGroupEnd.next = sortedGroup;

            while (prevGroupEnd.next != null) {
                prevGroupEnd = prevGroupEnd.next;
            }

            prevGroupEnd.next = head;
        }

        return dummy.next;
    }

    private static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            ListNode prev = dummy;

            while (prev.next != null && prev.next.val > curr.val) {
                prev = prev.next;
            }

            curr.next = prev.next;
            prev.next = curr;

            curr = next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // Example usage
        ListNode head = new ListNode(0);
        head.next = new ListNode(0);
        head.next.next = new ListNode(8);
        head.next.next.next = new ListNode(4);

        int n = 3;
        ListNode result = sortGroup(head, n);

        // Print the sorted list
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
