package OnlinePlatform;

public class RecoveryTree99 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    TreeNode prev = null;
    TreeNode first = null;
    TreeNode second = null;
     public  void inorder(TreeNode root) {
            if (root == null) {
                return ;
            }

            inorder(root.left);
         if (prev != null && prev.val > root.val) {
             if (first == null) {
                 first = prev;
             }
             second = root;
         }
         prev=root;
            inorder(root.right);
    }
}
