package Dp47part2.DP.RepracticeDp;

import java.lang.reflect.Array;
import java.util.Arrays;

public class RodCutting {
    public static void main(String[] args) {
        int []length={1,2,3,4,5,6,7,8};
        int []price={1,5,8,9,10,17,17,20};
        int rodLength=8;
        int [][]dp=new int[length.length+1][rodLength+1];
        for(int i=1;i<length.length+1;i++){
            for(int j=1;j<rodLength+1;j++) {
                //include
                if (length[i - 1] <= j) {
                    //include
                    int ans1 = price[i - 1] + dp[i][j - length[i - 1]];
                    //exclude
                    int ans2 = dp[i - 1][j];
                    dp[i][j]=Math.max(ans1,ans2);
                }//exclude
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[length.length][rodLength]);
        System.out.println(Arrays.deepToString(dp));
    }
}
