package Dp47part2.DP.RepracticeDp;

import java.util.Arrays;

public class TargetSum {
    public static void main(String[] args) {
        int []number={4,2,7,1,3};
        int targetSum=5;
        boolean [][]dp=new boolean[number.length+1][targetSum+1];
        for(int i=0;i<dp.length;i++){
          dp[i][0]=true;
        }
        for(int i=1;i<number.length+1;i++){
            for(int j=1;j<targetSum+1;j++){
                //include number
                if(number[i-1]<=j && dp[i - 1][j - number[i - 1]]){
                    dp[i][j]=true;
                }else if(dp[i-1][j]){//exclude number
                    dp[i][j]=true;
                }else{
//                    totally exclude
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        System.out.println(dp[number.length][targetSum]);
    }
}
