class SumRootLeafNumbers {

    int ans = 0;

    void dfs(TreeNode curr, String digits) {
        if (curr == null) { return; }
        digits += String.valueOf(curr.val);
        if (curr.left == null && curr.right == null) ans += Integer.parseInt(digits); 
        dfs(curr.left, digits);
        dfs(curr.right, digits);
    }

    public int sumNumbers(TreeNode root) {
        dfs(root, "");
        return ans;
    }
}
