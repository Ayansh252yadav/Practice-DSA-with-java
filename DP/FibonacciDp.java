package DP;

public class FibonacciDp {
    public static int fibonacci(int []dp,int n){
        if(n==0 ||n==1){
            return n;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        dp[n]= fibonacci(dp,n-1)+fibonacci(dp,n-2);
        return dp[n];
    }

    public static void main(String[] args) {
        int n=5;
        int []dp=new int[n+1];
        System.out.println(fibonacci(dp,n));
    }
}
