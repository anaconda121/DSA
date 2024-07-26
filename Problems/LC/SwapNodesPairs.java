class SwapNodesPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        List<Integer> vals = new ArrayList<>();

        ListNode curr = head;
        while (curr != null) {
            vals.add(curr.val);
            curr = curr.next;
        }

        curr = head;
        int pairs = 0;
        while (curr != null) {
            if (pairs + 1 < vals.size()) {
            curr.val = vals.get(pairs + 1);
            curr = curr.next;
            if (curr != null) { curr.val = vals.get(pairs); }
            pairs += 2;
            curr = curr.next;
            } else { break; }
        }

        return head;
    }
}
