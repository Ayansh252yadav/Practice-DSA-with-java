package Dp47part2.DP.RepracticeDp;

public class CatalansTabulation {
    public static int catalansRecursion(int n){
        if(n==0 || n==1){
            return 1;
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=catalansRecursion(i)*catalansRecursion(n-i-1);
        }
        return ans;
    }
    public static void main(String[] args) {
        int n=3;
        System.out.println(catalansRecursion(3));
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
        System.out.println(dp[n]);
    }
}
