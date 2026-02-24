class Solution {
    private int dfs(TreeNode node, int cur) {
        if (node == null) {
            return 0;
        }

        cur = cur * 2 + node.val;
        
        if (node.left == null && node.right == null) {
            return cur;
        }

        return dfs(node.left, cur) + dfs(node.right, cur);
    }

    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }
}