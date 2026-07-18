package OnlinePlatform;

public class BSTtoGst {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val=val;
            this.left=null;
            this.right=null;
        }
    }
    int prev=0;
    public void convertBST(TreeNode root){
        if(root==null){
            return ;
        }
        convertBST(root.right);
        root.val+=prev;
        prev=root.val;
        convertBST(root.left);
    }
    public TreeNode bstToGst(TreeNode root) {
       convertBST(root);
       return root;
    }
}
