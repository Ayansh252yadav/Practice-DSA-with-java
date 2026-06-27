package Dp47part2;

import java.util.Arrays;

public class CatalnsMemoization {
    public static int catalns(int n,int []dp){
        if(n==0 || n==1){
            return 1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int ans=0;
        for (int i=0;i<n;i++){
            ans+=catalns(i,dp)*catalns(n-i-1,dp);

        }
        return dp[n]=ans;
    }

    public static void main(String[] args) {
        int n=7;
        int []dp=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(catalns(n,dp));
    }

    public static class DecodeWays91 {

    }
}
