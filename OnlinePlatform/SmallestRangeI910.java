package OnlinePlatform;

import java.util.Arrays;

public class SmallestRangeI910 {

    public static int  transform(int []nums,int i,int k){
      for(int j=i;j>=0;j--){
          nums[j]+=k;
      }
      for(int j=i;j<nums.length;j++){
          nums[j]-=k;
      }
      int min=Integer.MAX_VALUE;
      int max=Integer.MIN_VALUE;
      for(int t=0;t<nums.length;t++){
          min=Math.min(min,nums[t]);
          max=Math.max(max,nums[t]);
      }
      return max-min;
    }
    public int smallestRangeII(int[] nums, int k) {
     Arrays.sort(nums);
        int temp = Integer.MAX_VALUE;
     for(int i=0;i<nums.length;i++){
         int []t=nums.clone();
         temp=Math.min(temp, transform(t,i,k));
     }
     return temp;
    }
}
