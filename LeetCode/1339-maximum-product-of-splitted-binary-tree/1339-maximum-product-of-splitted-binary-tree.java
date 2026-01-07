import java.util.*;

class Solution {
    static long MOD = 1000000007;

    private long dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        node.val += dfs(node.left) + dfs(node.right);
        return node.val;
    }

    public int maxProduct(TreeNode root) {
        long total = dfs(root);
        long max = Long.MIN_VALUE;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                continue;
            }

            long cur = (total - node.val) * node.val;
            max = Math.max(max, cur);

            if (node.left != null) {
                q.offer(node.left);
            }
            if (node.right != null) {
                q.offer(node.right);
            }
        }

        return (int) (max % MOD);
    }
}