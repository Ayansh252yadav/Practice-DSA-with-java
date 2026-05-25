package Dp47part2.DP;

public class TargetSumsubset {
    public static  boolean sumSubset(int []arr,int targetSum,boolean [][]dp){
        for(int i=0;i<arr.length;i++){
            dp[i][0]=true;
        }
        for(int i=1;i<arr.length+1;i++){
            for(int j=1;j<targetSum+1;j++){
                int v=arr[i-1];
                //include
                if(v<=j && dp[i - 1][j - v]){
                    dp[i][j]=true;
                }else if(dp[i - 1][j]){
                    dp[i][j]=true;
                }
                //exclude
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[arr.length][targetSum];
    }

    public static void main(String[] args) {
        int []arr={4,2,7,1,3};
        int targetSum=10;
        boolean [][]dp=new boolean[arr.length+1][targetSum+1];
        System.out.println(sumSubset(arr,targetSum,dp));
    }
}
