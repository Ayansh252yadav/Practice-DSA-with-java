package Dp47part2.DP;

import java.util.Arrays;

public class LongestCommonSubsequenceMemoization {
    public static int lcsMemoization(String str1,String str2,int m,int n,int [][]dp){
        if(n==0 || m==0){
            return 0;
        }
        if(dp[m][n]!=-1){
            return dp[n][m];
        }
       else if(str1.charAt(m-1)==str2.charAt(n-1)){
            dp[m][n]=lcsMemoization(str1,str2,m-1,n-1,dp)+1;
            return dp[m][n];
        }else{
            int ans1=lcsMemoization(str1,str2,m-1,n,dp);
            int ans2=lcsMemoization(str1,str2,m,n-1,dp);
            dp[m][n]=Math.max(ans1,ans2);
            return dp[m][n];
        }
    }

    public static void main(String[] args) {
        String str1="abcdge";
        String str2="abedg";
        int [][]dp=new int[str1.length()+1][str2.length()+1];
        for(int []row:dp){
            Arrays.fill(row,-1);
        }

        System.out.println(lcsMemoization(str1,str2,str1.length(),str2.length(),dp));
    }
}
