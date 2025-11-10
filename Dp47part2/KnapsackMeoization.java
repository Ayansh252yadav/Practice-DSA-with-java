package Dp47part2;

public class KnapsackMeoization {
    public  static int memoization(int val[],int wt[],int W,int dp[][],int n){
  if(n==0 || W==0){
        return 0;
    }

  if(dp[n][W]!=-1){
      return dp[n][W];
  }
        if(wt[n-1]<=W){
        //include
        int ans1=val[n-1]+memoization(val,wt,W-wt[n-1],dp,n-1);
        //exclude
        int ans2=memoization(val,wt,W,dp,n-1);
        dp[n][W]=Math.max(ans1,ans2);
        return dp[n][W];
    }else{
        dp[n][W]= memoization(val,wt,W,dp,n-1);
        return dp[n][W];
    }
}
public static void main(String[] args) {
    int val[]={15,14,10,45,30};
    int wt[]={2,5,1,3,4};
    int W=7;
   int n= val.length;
    int dp[][]=new int[n+1][W+1];

    for(int i=0;i< dp.length;i++){
       for(int j=0;j<dp[0].length;j++){
           dp[i][j]=-1;
       }
    }
    System.out.println(memoization(val,wt,W,dp,val.length));
}
}
