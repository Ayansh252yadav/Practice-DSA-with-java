package Dp47part2.DP;

import java.util.Arrays;

public class EditDistance {
    public static void main(String[] args) {
        String word1="intention";
        String word2="execution";
        int n=word1.length();
        int m=word2.length();
        int [][]dp=new int [n+1][m+1];
        //word1 ------> word2
        //for when word1 is empty here we perform completely  add ope
        dp[0][0]=0;
        for(int i=1;i<=n;i++){
            dp[0][i]=dp[0][i-1]+1;
        }
        // for when word2 is empty here we perform  delete op
        for(int i=1;i<=m;i++){
            dp[i][0]=dp[i-1][0]+1;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                //for same character
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    //perform add replace and insert and take min
                    int add=dp[i][j-1]+1;
                    int replace=dp[i-1][j-1]+1;
                    int delete=dp[i-1][j]+1;
                    dp[i][j]=Math.min(add,Math.min(replace,delete));
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}
