package Dp47part2.DP;

import java.util.Arrays;

public class InterLeavingStringTabulation97{
    public static void main(String[] args) {
        String s1="aabcc";
        String s2="dbbca";
        String s3="aadbbcbcac";
        int n=s1.length();
        int m=s2.length();
        boolean [][]dp=new boolean[n+1][m+1];
        dp[0][0]=true; //base case
        //when s2 is empty
        for(int i=1;i<n+1;i++){
            if( s1.charAt(i-1) == s3.charAt(i-1)){
                dp[i][0]= dp[i-1][0];
            }
        }
//        when s1 is empty
       for(int i=1;i<m+1;i++){
        if( s2.charAt(i-1) == s3.charAt(i-1)){
            dp[0][i]= dp[0][i-1];
        }
       }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
              boolean froms1=s1.charAt(i-1)==s3.charAt(i+j-1) && dp[i-1][j];
              boolean froms2=s2.charAt(j-1)==s3.charAt(i+j-1) && dp[i][j-1];
              dp[i][j]=froms1 || froms2;
            }

        }
        System.out.println(dp[n][m]);
    }
}
