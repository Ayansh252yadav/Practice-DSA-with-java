package OnlinePlatform;

import java.util.ArrayList;
import java.util.List;

public class PathSum113 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    public static void pathUtil(TreeNode root,List<List<Integer>>res,
                                List<Integer>temp,int sum,
                                int targetSum){
        if(root==null){
         return;
        }
      if(  root.left == null && root.right == null){
          if(sum==targetSum){
              res.add(new ArrayList<>(temp));
          }
      }
            temp.add(root.val);
            sum+=root.val;
        pathUtil(root.left,res,temp,sum,targetSum);
        pathUtil(root.right,res,temp,sum,targetSum);
        temp.remove(temp.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer>temp=new ArrayList<>();
        pathUtil(root,res,temp,0,targetSum);
        return res;
    }
}
