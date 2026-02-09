class Solution {
    private void inorder(TreeNode node, List<TreeNode> nodes) {
        if (node == null) {
            return;
        }

        inorder(node.left, nodes);
        nodes.add(node);
        inorder(node.right, nodes);
    }

    private TreeNode build(List<TreeNode> nodes, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode root = nodes.get(mid);
        root.left = build(nodes, left, mid - 1);
        root.right = build(nodes, mid + 1, right);
        return root;
    }

    public TreeNode balanceBST(TreeNode root) {
        if (root == null) {
            return null;
        }

        List<TreeNode> nodes = new ArrayList<>();
        inorder(root, nodes);

        return build(nodes, 0, nodes.size() - 1);
    }
}