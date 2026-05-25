package Dp47part2.DP;

public class UnboundedKnapsack_2 {
    public static void main(String[] args) {
        int []val={15,14,10,45,30};
        int []wt={2,5,1,3,4};
        int capacity=7;
        int dp[][]=new  int[val.length+1][capacity+1];
        for(int i=1;i<val.length+1;i++){
            for(int j=1;j<capacity+1;j++){
                int v=val[i-1];
                int w=wt[i-1];
                if(w<=j){
                    //include
                    int ans1=val[i-1]+dp[i][j-w];
                    //exclude
                    int ans2=dp[i-1][j];
                    dp[i][j]=Math.max(ans1,ans2);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        System.out.println(dp[val.length][capacity]);
    }
}
