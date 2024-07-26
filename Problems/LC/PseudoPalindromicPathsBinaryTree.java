class PseudoPalindromicPathsBinaryTree {
    int res = 0;

    void dfs(TreeNode curr, int[] cnt, int tot) {
        if (curr == null) return;
        cnt[curr.val]++;
        
        if (curr.left == null && curr.right == null) {
            int odds = 0;
            for (int i = 1; i <= 9; i++) {
                if (cnt[i] % 2 == 1) odds++;
            }
            if ((tot + 1) % 2 == 1 && odds == 1) res++;
            else if ((tot + 1) % 2 == 0 && odds == 0) res++;
        } else {
            dfs(curr.left, cnt, tot + 1);
            dfs(curr.right, cnt, tot + 1);
        }
        
        cnt[curr.val]--;
    }

    public int pseudoPalindromicPaths (TreeNode root) {
        int[] cnt = new int[10];
        dfs(root, cnt, 0);
        return res;
    }
}
