package OnlinePlatform;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum39 {
    public static void createUtil(int nums[],int target,int i,List<List<Integer>>res,List<Integer>temp){
     if(target<0 || i==nums.length){
         return;
     }
      if(target==0){
          res.add(new ArrayList<>(temp));
          return;
      }
      temp.add(nums[i]);
      createUtil(nums,target-nums[i],i,res,temp);
      temp.remove(temp.size()-1);
      createUtil(nums,target,i+1,res,temp);
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
     List<List<Integer>>res=new ArrayList<>();
     createUtil(candidates,target,0,res,new ArrayList<>());
        System.out.println(res);
     return res;
    }

    public static void main(String[] args) {
        int []nums={2,3,6,7};
        int target=7;
        combinationSum(nums,target);
    }
}
