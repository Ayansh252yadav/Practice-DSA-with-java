package Dp47part2;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String str1="abcde";
        String str2="abgce";
        int [][]dp=new int[str1.length()+1][str2.length()+1];
        int ans=Integer.MIN_VALUE;
        for(int i=1;i<str1.length()+1;i++){
            for(int j=1;j<str2.length()+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=0;
                }
                ans=Math.max(ans,dp[i][j]);
            }
        }
        System.out.println(ans);
    }
}
