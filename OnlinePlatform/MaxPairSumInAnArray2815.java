package OnlinePlatform;

import java.util.Arrays;

public class MaxPairSumInAnArray2815 {
    public static boolean isSame(int n1,int n2){
        int n1Max=Integer.MIN_VALUE;
        int n2Max=Integer.MIN_VALUE;
        while(n1 > 0){
            n1Max = Math.max(n1Max, n1 % 10);
            n1 /= 10;
        }
        while(n2 > 0){
            n2Max = Math.max(n2Max, n2 % 10);
            n2 /= 10;
        }
   return n1Max==n2Max;
    }
    public static int maxSum(int[] nums) {
        int sum=-1;
     for(int i=0;i<nums.length;i++){
    for(int j=i+1;j<nums.length;j++){
        if(isSame(nums[i],nums[j])){
            if(sum<(nums[i]+nums[j])){
                sum=nums[i]+nums[j];
            }
        }
    }
     }
        return sum;
    }

    public static void main(String[] args) {
        int []nums={112,131,411};
        System.out.println(maxSum(nums));
    }
}
