package Dp47part2.DP;

public class ClimbingStairs70 {
    public static int climbStairs(int n) {
   if(n==0){
       return 1;
   }
   if(n<0){
       return 0;
   }
   return climbStairs(n-1)+climbStairs(n-2);
    }
public static int waysMemoization(int n,int []dp){
    if(n==0){
        return 1;
    }
    if(n<0){
        return 0;
    }
    if(dp[n]!=0){
        return dp[n];
    }
    dp[n]=waysMemoization(n-1,dp)+waysMemoization(n-2,dp);
    return dp[n];
}
    public static void main(String[] args) {
        System.out.println(waysMemoization(5,new int[5+1]));
    }
}
