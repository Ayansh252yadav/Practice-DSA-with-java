package Dp47part2.DP;

public class StringCOnversion {
    public static void main(String[] args) {
        String str1="abcdef";
        String str2="aceg";
        int n=str1.length();
        int m=str2.length();
        int [][]dp=new int[n+1][m+1];
        //transform str1 ----------->  str2

//        string conversion first find lcs then n-dp[n][m]
//        are delete operation + m-dp[n][m] add operation
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    //insert
                    int ans1=dp[i][j-1];
                    int ans2=dp[i-1][j];
                    dp[i][j]=Math.max(ans1,ans2);
                }
            }
        }
        System.out.println((n-dp[n][m])+(m-dp[n][m]));
    }
}
