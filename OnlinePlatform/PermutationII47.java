package OnlinePlatform;

import java.util.*;

public class PermutationII47 {

    public static void helper(int[] nums, List<List<Integer>>res,
                              ArrayList<Integer>temp){
        if(nums.length==0){
            res.add(new ArrayList<>(temp));

            return;
        }
        for(int i=0;i<nums.length;i++){
            int curr=nums[i];
            int[] left = Arrays.copyOfRange(nums, 0, i);
            int[] right = Arrays.copyOfRange(nums, i + 1, nums.length);
            int[] interNum = Arrays.copyOf(left, left.length + right.length);
            System.arraycopy(right, 0, interNum, left.length, right.length);
            temp.add(curr);
            helper(interNum,res,temp);
            temp.remove(temp.size()-1);
        }
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
  List<List<Integer>>res=new ArrayList<>();
   helper(nums,res,new ArrayList<>());
   Set<List<Integer>> set=new HashSet<>();
   set.addAll(res);
   res=new ArrayList<>();
   Iterator<List<Integer>>it=set.iterator();
   while (it.hasNext()){
       res.add(it.next());
   }
   return res;
    }

    public static void main(String[] args) {
int []num={1,1,2};
        System.out.println(permuteUnique(num));
    }
}
