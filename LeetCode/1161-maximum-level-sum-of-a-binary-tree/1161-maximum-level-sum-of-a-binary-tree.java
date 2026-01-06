import java.util.*;

class Solution {
    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }        

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int level = 1, maxLevel = 1, maxSum = Integer.MIN_VALUE;

        while (!q.isEmpty()) {
            int size = q.size();
            int levelSum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                levelSum += node.val;

                if (node.left != null) {
                    q.offer(node.left);
                }

                if (node.right != null) {
                    q.offer(node.right);
                }
            }

            if (levelSum > maxSum) {
                maxSum = levelSum;
                maxLevel = level;
            }

            level++;
        }

        return maxLevel;
    }
}