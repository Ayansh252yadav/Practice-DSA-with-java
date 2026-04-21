package BinaryTree32;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FindBinaryTreeMode501 {
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
   static List<Integer>list=new ArrayList<>();
    public static  void findModeUtil(TreeNode root){
        if(root==null){
            return;
        }
        findModeUtil(root.left);
        list.add(root.val);
        findModeUtil(root.right);
    }
    public static int[] findMode(TreeNode root) {
        list.clear();
      findModeUtil(root);
        ArrayList<Integer>res=new ArrayList<>();
     int prevVal=list.get(0);
     int count=1;
     int maxCount=1;
     res.add(prevVal);
     for(int i=1;i<list.size();i++){
         if(prevVal== list.get(i)){
             count++;
         }else{
             prevVal=list.get(i);
             count=1;
         }
         if(count>maxCount){
             maxCount=count;
             res.clear();
             res.add(list.get(i));
         }
         else if(count==maxCount){
             res.add(list.get(i));
         }
     }
     int []ans=new int[res.size()];
     int k=0;
     for(Integer re:res){
         ans[k]=re;
         k++;
     }
     res.clear();
     return ans;
    }
}
