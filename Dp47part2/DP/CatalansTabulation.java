package Dp47part2.DP;

public class CatalansTabulation {
    public static void main(String[] args) {
        int n=5;
        int []dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
    for(int i=2;i<n+1;i++){
        int ans=0;
        for(int j=0;j<i;j++){
            ans+=dp[j]*dp[i-j-1];
        }
        dp[i]=ans;
    }
        System.out.println(dp[4]);
    }
}
