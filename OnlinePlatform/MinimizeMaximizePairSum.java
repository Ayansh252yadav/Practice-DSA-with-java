package OnlinePlatform;

import java.util.ArrayList;
import java.util.Arrays;

public class MinimizeMaximizePairSum {
    public static int minPairSum(int nums[]){
       int n=nums.length-1;
       int m=0;
       if(n==0 || nums==null){
           return -1;
       }
        Arrays.sort(nums);
       int temp[]=new int[nums.length/2];
       int k=0;
       while(m<n){
           temp[k]=nums[m]+nums[n];
           k++;
           m++;
           n--;
       }
        System.out.println(Arrays.toString(temp));
        int max= Integer.MIN_VALUE;
        for(int i=0;i<temp.length;i++){
            max=Math.max(max,temp[i]);
        }
        return max;
    }

    public static int minPairSum2(int nums[]){
        if(nums.length==0 || nums==null){
            return -1;
        }
        Arrays.sort(nums);
        int left=0;
        int right=nums.length-1;
        int maxPairSum=Integer.MIN_VALUE;
        while(left<right){
            int pairSum=nums[left]+nums[right];
            maxPairSum=Math.max(pairSum,maxPairSum);
            left++;
            right--;
        }

        return maxPairSum;
    }

    public static void main(String[] args) {
        int []nums={4,1,5,1,2,5,1,5,5,4};
//        System.out.println(minPairSum(nums));
        System.out.println(minPairSum2(nums));
    }
}
