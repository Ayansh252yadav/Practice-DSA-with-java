package Dp47part2.DP.RepracticeDp;

import java.util.Arrays;

public class ClimbingStairsMemoization {
    public static int climbingStairs(int n,int []dp){
        if(n==0 ){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        dp[n]=climbingStairs(n-1,dp)+climbingStairs(n-2,dp);
        return dp[n];
    }

    public static void main(String[] args) {
        int n=8;
        int []dp=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(climbingStairs(n,dp));
    }
}
