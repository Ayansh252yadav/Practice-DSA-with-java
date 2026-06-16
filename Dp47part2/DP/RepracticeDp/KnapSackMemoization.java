package Dp47part2.DP.RepracticeDp;

import java.util.Arrays;

public class KnapSackMemoization {
    public static int knapSackMemoization(int []val,int []wt,int n,int w,int [][]dp){
        if(w==0 || n==0){
            return 0;
        }
        if(dp[n][w]!=-1){
            return dp[n][w];
        }
        if(wt[n-1]<=w){
            //include
            int ans1=val[n-1]+knapSackMemoization(val,wt,n-1,w-wt[n-1],dp);
            //exclude
            int ans2=knapSackMemoization(val,wt,n-1,w,dp);
            dp[n][w]=Math.max(ans1,ans2);
            return dp[n][w];
        }else{
            //exclude
            dp[n][w]=knapSackMemoization(val,wt,n-1,w, dp);
            return dp[n][w];
        }
    }
    public static void main(String[] args) {
        int []val={15,14,10,45,30};
        int []wt={2,5,1,3,4};
        int w=7;
        int [][]dp=new int[wt.length+1][w+1];
        for(int []row:dp){
            Arrays.fill(row,-1);
        }
       for(int i=0;i<dp.length;i++){
          dp[i][0]=0;
       }
        Arrays.fill(dp[0], 0);
        System.out.println(knapSackMemoization(val,wt,wt.length,w,dp));
    }
}
