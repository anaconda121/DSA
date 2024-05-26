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
class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        List<Integer> lst = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            lst.add(curr.val);
            curr = curr.next;
        }

        int l = 0;
        int r = lst.size() - 1;
        while (l <= r) {
            if (lst.get(l) != lst.get(r)) return false;
            l++;
            r--;
        }
        
        return true;
    }
}
