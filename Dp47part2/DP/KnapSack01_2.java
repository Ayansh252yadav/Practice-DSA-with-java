package Dp47part2.DP;

import java.util.Arrays;
class KnapSackRecursion{
    public static int recursionKnapSack(int []val,int []wt,int capacity,int n){
        if(capacity==0 || n==0) {
            return 0;
        }
        if(wt[n-1]<=capacity){
            //include
            int ans1=val[n-1]+recursionKnapSack(val,wt,capacity-wt[n-1],n-1);
            //exclude
            int  ans2=recursionKnapSack(val,wt,capacity,n-1);
            return Math.max(ans1,ans2);
        }else{
            return recursionKnapSack(val,wt,capacity,n-1);
        }
    }
}
public class KnapSack01_2 {
    public static int KnapSackMemoization(int []val,int[]wt,int capacity,int n,int [][]dp){
        if(capacity==0 || n==0){
            return 0;
        }
        if(dp[n][capacity]!=-1){
            return dp[n][capacity];
        }
        if(capacity>=wt[n-1]){
            //include
            int ans1=val[n-1]+KnapSackMemoization(val,wt,capacity-wt[n-1],n-1,dp);
            //exclude
            int ans2=KnapSackMemoization(val,wt,capacity,n-1,dp);
            dp[n][capacity]=Math.max(ans1,ans2);
            return dp[n][capacity];
        }else{
            dp[n][capacity]=KnapSackMemoization(val,wt,capacity,n-1,dp);
            return dp[n][capacity];
        }
    }
    public static int KapSackTabulation(int []val,int []wt,int capacity){
        int [][]dp=new int[val.length+1][capacity+1];
        for(int i=1;i<val.length+1;i++){
            for(int j=1;j<capacity+1;j++){
                if(wt[i-1]<=j){
                    //include
                    int ans1=val[i-1]+dp[i-1][j-wt[i-1]];
                    //exclude
                    int ans2=dp[i-1][j];
                    dp[i][j]=Math.max(ans1,ans2);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[val.length][capacity];
    }
    public static void main(String[] args) {
       int N = 4;
       int[] Values = {1, 4, 5, 7};
       int [] Weights = {1, 3, 4, 5};
        int W = 7;
        int [][]dp=new int[Values.length+1][W+1];
        for(int i=0;i<dp.length;i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(KnapSackMemoization(Values,Weights,W,N,dp));
        System.out.println(Arrays.deepToString(dp));
        KapSackTabulation(Values,Weights,W);
    }
}
