class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null) return null;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        ListNode curr = head;
        while (curr != null) {
            pq.add(curr.val);
            curr = curr.next;
        }

        ListNode newHead = new ListNode();
        curr = newHead;
        while (pq.size() > 0 && curr != null) {
            curr.val = pq.poll();
            if (pq.size() >= 1) {
                curr.next = new ListNode();
            } else if (pq.size() == 0) {
                curr.next = null;
            }
            curr = curr.next;
        }

        return newHead;  
    }
}
