package OnlinePlatform;

import java.util.HashMap;
import java.util.HashSet;

public class BinaryTree2196 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
            this.left=null;
            this.right=null;
        }
    }
    public static TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer,TreeNode>map=new HashMap<>();
        HashSet<Integer>children=new HashSet<>();
        for(int []arr:descriptions){
           int parent = arr[0];
           int child  = arr[1];
           int isLeft=arr[2];
         if(!map.containsKey(parent)){
             map.put(parent,new TreeNode(parent));
         }
         if(!map.containsKey(child)){
             map.put(child,new TreeNode(child));
         }
         TreeNode parentNode=map.get(parent);
         TreeNode childNode=map.get(child);
         if(isLeft==1){
             parentNode.left=childNode;
         }else{
             parentNode.right=childNode;
         }
        }
        for(int []arr:descriptions) {
            children.add(arr[1]);
        }
      for(int []arr:descriptions){
          if(!children.contains(arr[0])){
              return map.get(arr[0]);
          }
      }
  return null;
    }
    public static void preOrder(TreeNode root){
        if(root==null){
            return;
        }
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void main(String []args){
        int [][]descriptions = {{85,82,1},{74,85,1},{39,70,0},{82,38,1},{74,39,0},{39,13,1}};
       TreeNode root=createBinaryTree(descriptions);
       preOrder(root);
    }
}
