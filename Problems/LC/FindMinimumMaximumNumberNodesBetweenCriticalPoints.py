# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class FindMinimumMaximumNumberNodesBetweenCriticalPoints:
    def nodesBetweenCriticalPoints(self, head: Optional[ListNode]) -> List[int]:
        crit_pts = []

        curr = head
        prev = None
        ctr = 0
        while (curr is not None):
            if (prev is not None and curr.next is not None):
                if (prev.val > curr.val and curr.next.val > curr.val):
                    crit_pts.append(ctr)
                elif (prev.val < curr.val and curr.next.val < curr.val):
                    crit_pts.append(ctr)
            ctr += 1
            prev = curr
            curr = curr.next

        if (len(crit_pts) < 2):
            return [-1, -1]
        
        max_dist = crit_pts[len(crit_pts) - 1] - crit_pts[0]
        min_dist = float("inf")
        for i in range(0, len(crit_pts) - 1, 1):
            min_dist = min(min_dist, crit_pts[i + 1] - crit_pts[i])
        
        return [min_dist, max_dist]
