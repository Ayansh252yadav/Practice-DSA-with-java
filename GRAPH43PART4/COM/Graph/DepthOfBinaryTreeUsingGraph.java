package GRAPH43PART4.COM.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DepthOfBinaryTreeUsingGraph {

    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        public TreeNode(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
  static class Qitem{
        TreeNode node;
        int depth;
        Qitem(TreeNode node,int depth){
            this.node = node;
            this.depth = depth;
        }
  }
  public static int minDepth(TreeNode root){
        if(root==null){
            return 0;
        }
      Queue<Qitem>q=new LinkedList<Qitem>();
        Qitem qi=new Qitem(root,1);
        q.add(qi);
        while(!q.isEmpty()){
            qi=q.poll();
            TreeNode node=qi.node;
            int depth=qi.depth;
            if(node.left==null && node.right==null){
                return depth;
            }
            if(node.left!=null){
                qi.node=node.left;
                qi.depth=depth+1;
                q.add(qi);
            }
            if(node.right!=null){
                qi.node=node.right;
                qi.depth=depth+1;
                q.add(qi);
            }
        }
        return 0;
  }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
         root.left=new TreeNode(2);
         root.right=new TreeNode(3);
         root.left.left=new TreeNode(4);
         root.left.right=new TreeNode(5);
        System.out.println( minDepth(root));
    }
}
