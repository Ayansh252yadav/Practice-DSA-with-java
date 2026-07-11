package BinaryTree32;

import java.util.ArrayList;
import java.util.List;

public class IncreasingOrderSearchTree897 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            this.val = x;
            this.left = null;
            this.right = null;
        }
    }
    public static void getTreeVal(List<Integer> list,
                                  TreeNode root) {
        if(root==null){
            return;
        }
        getTreeVal(list,root.left);
        list.add(root.val);
        getTreeVal(list,root.right);
    }
    static int i=-1;
   public static TreeNode buildTree(List<Integer> list,
                                    TreeNode root){
        i++;
        if(i==list.size()){
            return root;
        }
        TreeNode newNode = new TreeNode(list.get(i));
       if(root==null){
           root=newNode;
           root.left = null;
           return root;
       }
       buildTree(list,root.right);
       return root;
   }

    public static TreeNode increasingBST(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    getTreeVal(list,root);
    TreeNode root1;
    buildTree(list,root);
    return buildTree(list,root);
    }
    public static TreeNode buildBst(TreeNode root,int val) {
       if(root==null){
           root=new TreeNode(val);
           return root;
       }
       if(root.val<val){
          root.right= buildBst(root.right,val);
       }
       if(root.val>val){
         root.left=  buildBst(root.left,val);
       }
       return root;
    }
    public static void inOrder(TreeNode root){
       if(root==null){
           return;
       }
       inOrder(root.left);
       System.out.println(root.val);
       inOrder(root.right);
    }

    public static void main(String[] args) {
//[5,3,6,2,4,null,8,1,null,null,null,7,9]
        int []treeVal={5,3,6,2,4,8,1,7,9};
        TreeNode root=null;
        for(int i=0;i<treeVal.length;i++){
            root=buildBst(root,treeVal[i]);
        }
        TreeNode root1=increasingBST(root);
        inOrder(root1);
    }
}
