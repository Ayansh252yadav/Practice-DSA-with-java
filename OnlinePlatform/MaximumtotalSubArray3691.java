package OnlinePlatform;

import java.util.ArrayList;
import java.util.Collections;

public class MaximumtotalSubArray3691 {
    public static long helperSubArray(int []nums, ArrayList<Integer>val,int li){
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                int min=Integer.MAX_VALUE;
                int max=Integer.MIN_VALUE;
                for(int k = i; k<= j; k++){
                   min=Math.min(nums[k],min);
                   max=Math.max(nums[k],max);
               }
                val.add(Math.abs(max-min));
            }
        }
        long sum=0;
        val.sort((a, b) -> (a - b));
        int idx = val.size() - 1;

        while(li > 0){
            sum += val.get(idx);
            idx--;
            li--;
        }
        return sum;
    }
    public static long maxTotalValue(int[] nums, int k) {
     return (helperSubArray(nums,new ArrayList<>(),k));
    }
    public static void main(String[] args) {
        int []nums={291905233,135780161,529813409,620409897,
                452676860};
        System.out.println(maxTotalValue(nums,2));
    }
}
