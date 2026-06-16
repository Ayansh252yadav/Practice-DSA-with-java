package Dp47part2;

public class WildCardMatching {
    public static void main(String[] args) {
        String text="baaabab";
        String pattern ="*****ba*****ab";
        int n=text.length();
        int m=pattern.length();
        boolean [][]dp=new boolean[n+1][m+1];
        dp[0][0]=true;
        for(int i=1;i<n+1;i++){
            dp[i][0]=false;
        }
        for(int i=1;i<m+1;i++){
           if(pattern.charAt(i-1)=='*'){
               dp[0][i]=dp[0][i-1];
           }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(text.charAt(i-1)==pattern.charAt(j-1) || pattern.charAt(j-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }else if(pattern.charAt(j-1)=='*'){
                    boolean ans1=dp[i-1][j];
                    boolean ans2=dp[i][j-1];
                    dp[i][j]=ans1||ans2;
                }else{
                    dp[i][j]=false;
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}
