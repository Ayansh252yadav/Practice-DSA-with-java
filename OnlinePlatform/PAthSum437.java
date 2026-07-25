package OnlinePlatform;

import java.util.HashMap;
import java.util.Map;

public class PAthSum437 {
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
    int countPath=0;
    public void pathUtil(TreeNode root, Map<Integer,Integer> map,
                         int targetSum,int preSum){
        if(root == null){
            return;
        }
        preSum+=root.val;
        countPath += map.getOrDefault(preSum - targetSum, 0);
        map.put(preSum,map.getOrDefault(preSum,0)+1);
        pathUtil(root.left,map,targetSum,preSum);
        pathUtil(root.right,map,targetSum,preSum);
        map.put(preSum,map.getOrDefault(preSum,0)-1);
       if(map.get(preSum)==0){
           map.remove(preSum);
       }
    }
    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
      pathUtil(root,map,targetSum,0);
      return countPath;
    }
}
