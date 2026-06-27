package Dp47part2.DP;

import java.util.Arrays;

public class MCMMemoization {
    public static int mcmMemoization(int []arr,int i,int j,int [][]dp){
        if(i==j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int cost1=mcmMemoization(arr,i,k,dp);
            int cost2=mcmMemoization(arr,k+1,j,dp);
            int resultantCost=arr[i-1]*arr[k]*arr[j];
            int finalCost=cost1+cost2+resultantCost;
             ans=Math.min(ans,finalCost);
        }
        return  dp[i][j]=ans;
    }
    public static void main(String[] args) {
  int []arr={1,2,3,4,3};
  int n=arr.length;
  int [][]dp=new int[n+1][n+1];
        for(int i=0;i<n+1;i++){
            Arrays.fill(dp[i],-1);
        }
        System.out.println(mcmMemoization(arr,1,n-1,dp));
    }
}
