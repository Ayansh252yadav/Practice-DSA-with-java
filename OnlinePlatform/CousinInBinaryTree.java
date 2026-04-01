class Solution {
    TreeNode px = null, py = null;
    int dx = -1, dy = -1;

    public void dfs(TreeNode root, TreeNode parent, int depth, int x, int y) {
        if (root == null) return;

        if (root.val == x) {
            dx = depth;
            px = parent;
        }

        if (root.val == y) {
            dy = depth;
            py = parent;
        }

        dfs(root.left, root, depth + 1, x, y);
        dfs(root.right, root, depth + 1, x, y);
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, null, 0, x, y);
        return (dx == dy) && (px != py);
    }
}
