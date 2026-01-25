package OnlinePlatform;

import java.util.Arrays;

public class Minimumdifferencebetweenhighestandlowestofkscores1984 {
    public static int minimumDifference(int nums[],int k){
        if(nums==null || nums.length==0 || k<=0){
            return -1;
        }
        if(k==1){
            return 0;
        }
        Arrays.sort(nums);
        int minDiff=Integer.MAX_VALUE;
       for(int i=0;i<=nums.length-k;i++){
        int diff=nums[i+k-1]-nums[i];
        minDiff=Math.min(diff,minDiff);
       }
        return minDiff;
    }

    public static void main(String[] args) {
        int []nums={9,4,1,7};
        int k=2;
        System.out.println(minimumDifference(nums,k));
    }
}
