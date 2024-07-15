# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class KthSmallestElementBST:
    def __init__(self):
        self.lst = []

    def dfs(self, curr):
        if curr is None: return
        self.dfs(curr.left)
        self.lst.append(curr.val)
        self.dfs(curr.right)

    def kthSmallest(self, root: TreeNode, k: int) -> int:
        self.dfs(root)
        return self.lst[k - 1]

