package OnlinePlatform;

public class DivideAnArray3010 {
    public int minimumCost(int[] nums) {
      int []suffixMin=new int[nums.length];
      int n=nums.length;
      suffixMin[n-1]=nums[n-1];
      for(int i=n-2;i>=0;i--){
          suffixMin[i]=Math.min(suffixMin[i+1],nums[i]);
      }
      int ans=Integer.MAX_VALUE;
      for(int i=1;i<n-1;i++){
          ans=Math.max(ans,nums[0]+nums[i]+suffixMin[i+1]);
      }
      return ans;
    }
}
