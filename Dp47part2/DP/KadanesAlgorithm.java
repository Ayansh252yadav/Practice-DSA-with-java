package Dp47part2.DP;

public class KadanesAlgorithm {
    public   static int maxSubArraySum(int []nums){
        int maxSum=nums[0];
        int currSum=nums[0];
        for(int i=1;i< nums.length;i++){
           currSum= Math.max(nums[i],currSum+nums[i]);
           maxSum=Math.max(currSum,maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int []nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArraySum(nums));
    }
}
