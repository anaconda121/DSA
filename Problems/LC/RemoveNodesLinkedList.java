class RemoveNodesLinkedList {
    public ListNode removeNodes(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }

        ListNode newHead = prev;
        int runningMax = prev.val;
        Stack<Integer> keep = new Stack<>();
        while (newHead != null) {
            runningMax = Math.max(runningMax, newHead.val);
            if (runningMax == newHead.val) {
                keep.push(newHead.val);
            }
            newHead = newHead.next;
        }

        ListNode ret = new ListNode();
        ListNode ptr = ret;
        while (keep.size() > 0) {
            ptr.val = keep.pop();
            if (keep.size() > 0) {
                ptr.next = new ListNode(keep.peek());
            }
            ptr = ptr.next;
        }

        return ret;
    }
}
