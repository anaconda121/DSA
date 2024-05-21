# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    def dfs(self, root, target):
        global del_count

        if root is None:
            return None
        
        if root.val == target and root.left is None and root.right is None: 
            del_count += 1
            return None
        
        root.left = self.dfs(root.left, target)
        root.right = self.dfs(root.right, target)
        return root

    def removeLeafNodes(self, root: Optional[TreeNode], target: int) -> Optional[TreeNode]:
        global del_count
        del_count = 0
        curr_root = self.dfs(root, target)

        while del_count > 0:
            del_count = 0
            curr_root = self.dfs(curr_root, target)
        
        return curr_root
