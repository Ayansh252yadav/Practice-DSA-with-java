package Dp47part2.DP;

import java.util.ArrayList;
import java.util.List;

public class CamelCaseMatching1023 {
    public static boolean helper(String queries ,String pattern){
       int n=pattern.length();
       int m=queries.length();
       boolean [][]dp=new boolean[n+1][m+1];
       dp[0][0]=true;
       for(int i=1;i<m+1;i++){
           if (Character.isLowerCase(queries.charAt(i - 1))) {
               dp[0][i] = dp[0][i - 1];
           }
       }
       for(int i=1;i<n+1;i++){
           dp[i][0]=false;
       }
       for(int i=1;i<n+1;i++){
           for(int j=1;j<m+1;j++){
               char p = pattern.charAt(i - 1);
               char q = queries.charAt(j - 1);
               if (p == q) {
                   dp[i][j] = dp[i - 1][j - 1];
               }
               else if (Character.isLowerCase(q)) {
                   dp[i][j] = dp[i][j - 1];
               }
               else {
                   dp[i][j] = false;
               }
           }
       }
       return dp[n][m];
    }
    public static List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean>res=new ArrayList<>();
      for(int i=0;i<queries.length;i++){
          res.add(helper(queries[i],pattern));
      }
      return res;
    }

    public static void main(String[] args) {
       String [] queries = {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
       String pattern = "FoBa";
        System.out.println(camelMatch(queries,pattern));
    }
}
