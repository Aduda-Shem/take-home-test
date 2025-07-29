public class Question7_RotateLinkedList {

    // Singly-linked list node
    public static class ListNode {
        String value;
        ListNode next;

        public ListNode(String value) {
            this.value = value;
        }
    }

    /**
     * Rotates the linked list to the right by `positions` steps.
     */
    public static ListNode rotateRight(ListNode head, int positions) {
        if (head == null || positions == 0) return head;

        // Find length and tail
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        positions %= length;
        if (positions == 0) return head;

        // Find new tail
        ListNode newTail = head;
        for (int i = 0; i < length - positions - 1; i++) {
            newTail = newTail.next;
        }

        // Rewire pointers
        ListNode newHead = newTail.next;
        newTail.next = null;
        tail.next = head;

        return newHead;
    }

    // Builds a linked list from array
    public static ListNode fromArray(String[] values) {
        if (values.length == 0) return null;
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

    // Converts linked list to readable format
    public static String toString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.value);
            if (head.next != null) sb.append(" -> ");
            head = head.next;
        }
        return sb.append(" -> null").toString();
    }

    public static void main(String[] args) {
        // Rotate by 2
        System.out.println(toString(rotateRight(fromArray(new String[]{
            "ID_A01", "ID_A02", "ID_A03", "ID_A04", "ID_A05", "ID_A06"
        }), 2)));

        // Rotate by 3 on 3 elements
        System.out.println(toString(rotateRight(fromArray(new String[]{"X", "Y", "Z"}), 3)));

        // Rotate by 1 on 1 element (should remain same)
        System.out.println(toString(rotateRight(fromArray(new String[]{"ONE"}), 1)));
    }
}
