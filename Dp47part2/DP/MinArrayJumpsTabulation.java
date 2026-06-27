package Dp47part2.DP;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MinArrayJumpsTabulation {
    public static void main(String[] args) {
        int []arr={2,3,0,1,4};
        int n=arr.length;
        int []dp=new int[n];
        Arrays.fill(dp,-1);
      dp[n-1]=0;
      for(int i=n-2;i>=0;i--){
          int step=arr[i];
          int min=Integer.MAX_VALUE;
          for (int j=i+1;j<=i+step && j<n;j++){
              if(dp[j]!=-1){
             min=Math.min(min,dp[j]+1);
              }
          }
          if(min!=Integer.MAX_VALUE){
          dp[i]=min;
          }
      }
        System.out.println(Arrays.toString(dp));
        System.out.println(dp[0]);
    }
}
