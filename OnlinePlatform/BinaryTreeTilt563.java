package OnlinePlatform;

import com.sun.source.tree.Tree;

public class BinaryTreeTilt563 {
   public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
            this.left=null;
            this.right=null;
        }
    }
    static int idx=-1;
    public static TreeNode buildTree(int []tree){
        idx++;
        if(tree[idx]==-1){
            return null;
        }
        TreeNode newNode=new TreeNode(tree[idx]);
       newNode.left=buildTree(tree);
       newNode.right=buildTree(tree);
       return newNode;
    }
    public static void preOrder(TreeNode root){
        if(root==null){
            return;
        }
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
    public static int treeSum(TreeNode root){
        if(root==null){
            return 0;
        }
        return root.val + treeSum(root.left) + treeSum(root.right);
    }

    public static void assignVal(TreeNode root){
        if(root==null){
            return;
        }
        root.val=Math.abs(treeSum(root.left)-treeSum(root.right));
        assignVal(root.left);
        assignVal(root.right);
    }
    public static int sum(TreeNode root){
        if(root==null){
            return 0;
        }
        return root.val + sum(root.left) + sum(root.right);
    }
    public static int findTilt(TreeNode root) {
    assignVal(root);
    return sum(root);
    }
public static void main(String[] args) {
    int []tree={21,7,1,3,-1,-1,3,-1,-1,1,-1,-1,14,2,-1,-1,2,-1,-1,};
    TreeNode root=buildTree(tree);
//    preOrder(root);
    System.out.println(findTilt(root));
}
}
