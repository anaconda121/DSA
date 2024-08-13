class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ArrayList<Integer> valsToReverse = new ArrayList<>();
        int ptr = 1;
        ListNode curr = head;
        while (curr != null) {
            if (ptr >= left && ptr <= right) {
                valsToReverse.add(curr.val);
            }
            curr = curr.next;
            ptr++;
        }

        int cnt = 1;
        ptr = 1;
        curr = head;
        while (curr != null) {
            if (ptr >= left && ptr <= right) {
                curr.val = valsToReverse.get(valsToReverse.size() - cnt);
                cnt++;
            }
            curr = curr.next;
            ptr++;
        }

        return head;
    }
}
