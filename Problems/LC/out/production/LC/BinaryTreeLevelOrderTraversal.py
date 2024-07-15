# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BinaryTreeLevelOrderTraversal:
    def __init__(self):
        self.depth = defaultdict(list)
        self.max_depth = -1

    def dfs(self, curr, d):
        if (curr is None): return
        self.depth[d].append(curr.val)
        if (d > self.max_depth): self.max_depth = d
        self.dfs(curr.left, d + 1)
        self.dfs(curr.right, d + 1)

    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        self.dfs(root, 0)
        ans = [0] * len(self.depth)

        for k, v in self.depth.items():
            ans[k] = (v)
        return ans
