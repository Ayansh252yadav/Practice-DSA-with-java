package Dp47part2.DP;

import java.util.Arrays;

public class MCMTabulation {
    public static void main(String[] args) {
        int []arr={1,2,3,4,3};
        int n=arr.length;
        int [][]dp=new int[n+1][n+1];
        for(int len=2;len<n;len++){
            for(int i=1;i<=n-len;i++){
                int j=i+len-1;
                dp[i][j]=Integer.MAX_VALUE;
                for(int k=i;k<j;k++){
                    int cost1=dp[i][k];
                    int cost2=dp[k+1][j];
                    int cost3=arr[i-1]*arr[k]*arr[j];
                    dp[i][j]= Math.min(dp[i][j],cost3+cost2+cost1);
                }
            }
        }
        System.out.println(dp[1][n-1]);
    }
}
