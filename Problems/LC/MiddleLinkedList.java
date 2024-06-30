class MiddleLinkedList {
    public ListNode middleNode(ListNode head) {
        List<ListNode> l = new ArrayList<>();

        ListNode curr = head;
        while (curr != null) {
            l.add(curr);
            curr = curr.next;
        }

        return l.get(l.size() / 2);
    }
}
