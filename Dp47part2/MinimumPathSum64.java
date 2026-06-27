package Dp47part2;

import java.util.Arrays;

public class MinimumPathSum64 {
    public static int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
       int []dp=new int[m+1];
       dp[0]=grid[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    dp[j] = grid[0][0];
                }
                else if (i == 0)  {
                    dp[j] = dp[j-1] + grid[i][j];
                }
                else if (j == 0) {
                    dp[j] = dp[j]   + grid[i][j];
                }
                else   {
                    dp[j] = Math.min(dp[j], dp[j-1]) + grid[i][j];
                }
            }
        }
        return dp[m - 1];
    }

    public static void main(String[] args) {
   int [][]grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));
    }
}
