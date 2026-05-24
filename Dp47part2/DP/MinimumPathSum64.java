package Dp47part2.DP;

public class MinimumPathSum64 {
    public static int minPathSumTabulation(int[][] grid) {
      int [][]dp=new int[grid.length][grid[0].length];
      dp[0][0]=grid[0][0];
      for(int i=0;i<grid.length;i++){
          for(int j=0;j<grid[0].length;j++){
              if(i==0 && j!=0){
                  dp[i][j]=grid[i][j]+dp[i][j-1];
              }else if(i!=0 && j==0){
                  dp[i][j]=grid[i][j]+dp[i-1][j];
              }else if(i==0 && j==0){
                  continue;
              }
              else{
                  dp[i][j]=grid[i][j]+Math.min(dp[i][j-1],dp[i-1][j]);
              }
          }
        }
      return dp[grid.length-1][grid[0].length-1];
    }
 public static int minPathSumMemoization(int [][]grid,int [][]dp,int i,int j){
        if(i== grid.length || j==grid[0].length){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        dp[i][j]=grid[i][j]+minPathSumMemoization(grid,dp,i+1,j+1);
        return dp[i][j];
 }
    public static void main(String[] args) {
        int [][] grid = {{1, 3, 1},{1, 5, 1},{4, 2, 1}};
        System.out.println(minPathSumTabulation(grid));
    }
}
