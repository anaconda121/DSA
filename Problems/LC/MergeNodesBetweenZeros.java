/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class MergeNodesBetweenZeros {
    public ListNode mergeNodes(ListNode head) {
        int currSum = 0;
        List<Integer> newNodes = new ArrayList<Integer>();

        ListNode curr = head;
        while (curr != null) {
            if (curr.val == 0 && curr != head) {
                newNodes.add(currSum);
                currSum = 0;
            } else { currSum += curr.val; }
            curr = curr.next;
        }

        ListNode newHead = new ListNode();
        curr = newHead;
        for (int i = 0; i < newNodes.size(); i++) {
            curr.val = newNodes.get(i);
            if (i + 1 < newNodes.size()) { curr.next = new ListNode(); }
            curr = curr.next;
        }
        
        return newHead;
    }
}
