package Dp47part2.DP;

import java.util.Arrays;

public class CountingTrees {
    public static int memoizationCountingTreesusingCatalan(int n,int []dp){
        if(n==0 ||n==1){
            return 1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=memoizationCountingTreesusingCatalan(i,dp)*
                    memoizationCountingTreesusingCatalan(n-1-i,dp);
        }
        return dp[n]=ans;
    }
    public static void main(String[] args) {
        int []bst={10,20,30,40};
        int []dp=new int[bst.length+1];
        Arrays.fill(dp,-1);
        System.out.println(memoizationCountingTreesusingCatalan(bst.length,dp));
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<bst.length+1;i++){
            int ans=0;
            for(int j=0;j<i;j++){
                ans+=dp[j]*dp[i-j-1];
            }
            dp[i]=ans;
        }
        System.out.println(dp[bst.length]);
    }
}
