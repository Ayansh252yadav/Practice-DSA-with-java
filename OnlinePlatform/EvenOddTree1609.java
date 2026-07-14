package OnlinePlatform;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class EvenOddTree1609 {
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
    public static void levelOrder(TreeNode root,ArrayList<ArrayList<Integer>>res){
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        ArrayList<Integer> list=new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            if(curr==null){
                res.add(new ArrayList<>(list));
                list.clear();
                if(q.isEmpty()){
                break;
                }else{
                    q.add(null);
                }
            }else{
                list.add(curr.val);
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
        }
    }
    public static boolean isEvenOddTree(TreeNode root) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        levelOrder(root,res);
        System.out.println(res);
        for(int i=0;i<res.size();i++){
           if(i%2==0){
               for(int j=1;j<res.get(i).size();j++){
                  if(res.get(i).get(j-1)>res.get(i).get(j)){
                      return false;
                  }
                  if(res.get(i).get(j-1)%2==0 || res.get(i).get(j)%2==0){
                      return false;
                  }
               }
           }else{
               for(int j=1;j<res.get(i).size();j++){
                   if(res.get(i).get(j-1)<res.get(i).get(j)){
                       return false;
                   }
                   if(res.get(i).get(j-1)%2!=0 || res.get(i).get(j)%2!=0){
                       return false;
                   }
               }
           }
        }
        return true;
    }
    static int idx=-1;
  public static TreeNode createTree(int []treeNode){
      idx++;
      if(treeNode[idx]==-1){
          return null;
      }
      TreeNode newNode=new TreeNode(treeNode[idx]);
      newNode.left=createTree(treeNode);
      newNode.right=createTree(treeNode);
      return newNode;
  }
  public static void preOrder(TreeNode root){
      if(root==null){
          return;
      }
      System.out.print(root.val+" ");
      preOrder(root.left);
      preOrder(root.right);
  }
    public static void main(String[] args) {
//        [1,10,4,3,null,7,9,12,8,6,null,null,2]
        int []treeNode={1,10,3,12,-1,-1,8,-1,
                -1,-1,4,7,6,-1,-1,-1,9,-1,2,-1,-1,};
        TreeNode root = createTree(treeNode);
        preOrder(root);
        System.out.println(isEvenOddTree(root));
    }
}
