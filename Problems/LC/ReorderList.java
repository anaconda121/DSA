class ReorderList {
    public void reorderList(ListNode head) {
        List<Integer> vals = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            vals.add(curr.val);
            curr = curr.next;
        }

        int ptr = 0;
        int cnt = 0;
        curr = head;
        while (curr != null) {
            if (cnt % 2 == 0) { 
                curr.val = vals.get(ptr);
            }
            else { 
                curr.val = vals.get(vals.size() - 1 - ptr);
                ptr++;
            }
            curr = curr.next;
            cnt++;
        }

    }
}
