package Dp47part2.DP;

import java.util.Arrays;

public class MinCostClimbingStairs746 {
    public static int memoization(int[] cost, int n, int[] dp) {
        if (n == 0) return cost[0];
        if (n == 1) return cost[1];

        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = cost[n] +
                Math.min(
                        memoization(cost, n - 1, dp),
                        memoization(cost, n - 2, dp)
                );

        return dp[n];
    }

    public static int minCostClimbingStairs1(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return Math.min(
                memoization(cost, n - 1, dp),
                memoization(cost, n - 2, dp)
        );
    }
    public static int minCostClimbingStairs(int[] cost) {
     int res[]=new int[cost.length];
     res[0]=cost[0];
     res[1]=cost[1];
     for(int i=2;i<cost.length;i++){
         res[i]=cost[i]+Math.min(res[i-1],res[i-2]);
     }
     return res[cost.length-1];
    }
    public static void main(String[] args) {
        int []cost={1,100,1,1,1,100,1,1,100,1};
        System.out.println(minCostClimbingStairs(cost));

        System.out.println(minCostClimbingStairs1(cost));
    }
}
