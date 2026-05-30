package Dp47part2.DP;

public class CoinChange {
    public static void main(String[] args) {
        int []coin={1,2,3};
        int change=4;
        int [][]dp=new int[coin.length+1][change+1];
        for(int i=0;i< coin.length;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<coin.length+1;i++){
            for(int j=1;j<change+1;j++){
                //include
                if(coin[i-1]<=j){
                   dp[i][j]=dp[i][j-coin[i-1]]+dp[i-1][j];

                }else{//exclude
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        System.out.println(dp[coin.length][change]);
    }
}
