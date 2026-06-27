package Dp47part2.DP;

import java.util.Arrays;

public class Tribonacci {
    public static int recursionTribonacci(int n){
        if(n==0 || n==1){
            return 0;
        }
        if(n==2){
            return 1;
        }
        return recursionTribonacci(n-1)+recursionTribonacci(n-2)+recursionTribonacci(n-3);
    }
    public static int memoizationTribonacci(int n,int []dp){
        if(n==0 || n==1 ){
            return 0;
        }
        if(n==2){
            return 1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
       dp[n] =memoizationTribonacci(n-1,dp)+
               memoizationTribonacci(n-2,dp)+memoizationTribonacci(n-3,dp);
        return dp[n];
    }
    public  static int tabulationTribonacci(int n,int []dp){
        dp[0]=0;
        dp[1]=0;
        dp[2]=1;
        for(int i=3;i<n;i++){
          dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
    public static void main(String[] args) {
        int n=5;
        int []dp=new int[n+1];
        Arrays.fill(dp,-1);
            System.out.println(recursionTribonacci(n));

        System.out.println(memoizationTribonacci(n,dp));

        System.out.println(tabulationTribonacci(n,dp));
    }
}
