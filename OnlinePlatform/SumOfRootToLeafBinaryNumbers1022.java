package OnlinePlatform;

import com.sun.source.tree.Tree;

public class SumOfRootToLeafBinaryNumbers1022 {
   static class TreeNode{
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
    public static TreeNode buildTree(int arr[]){
        idx++;

        if(arr[idx]==-1){
            return null;
        }
        TreeNode newNode=new TreeNode(arr[idx]);
        newNode.left=buildTree(arr);
        newNode.right=buildTree(arr);
        return newNode;
    }
  public static void preOrder(TreeNode root)
  {
      if(root==null){
          return;
      }
      System.out.println(root.val);
      preOrder(root.left);
      preOrder(root.right);
  }
  static int totalSum;
    public static void DFS(TreeNode  root,int current){
        if(root==null){
            return;
        }
        current=current*2 + root.val;
        if(root.left==null && root.right==null){
            totalSum+=current;
        }
        DFS(root.left,current);
        DFS(root.right,current);
    }
  public static int sumRootToLeaf(TreeNode root){
     DFS(root,0);
     return totalSum;
  }
  public static void main(String[] args) {
//      int arr[]={1,0,0,-1,-1,1,-1,-1,1,0,-1,-1,1,-1,-1};
      int arr[]={0,-1,-1};
      TreeNode root=buildTree(arr);
//      preOrder(root);
      System.out.println( sumRootToLeaf(root));
    }
}
