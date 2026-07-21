package OnlinePlatform;

public class PathWithMaximumGold1219 {
    public static int goldUtil(int [][]grid,int i,int j,boolean [][]vis,int colGold){
        if(i<0||j<0||i>grid.length-1||j>grid[0].length-1){
            return 0;
        }
        if(grid[i][j]==0) {
            return 0;
        }
        if(vis[i][j]){
            return 0;
        }
        vis[i][j]=true;
        int left=goldUtil(grid,i-1,j,vis,colGold);
        int right=goldUtil(grid,i+1,j,vis,colGold);
        int up=goldUtil(grid,i,j-1,vis,colGold);
        int down=goldUtil(grid,i,j+1,vis,colGold);
        vis[i][j] = false;
        return grid[i][j] + Math.max(Math.max(up, down), Math.max(left, right));
    }
    public int getMaximumGold(int[][] grid) {
        int maxGold=Integer.MIN_VALUE;

     for(int i=0;i<grid.length;i++){
         for(int j=0;j<grid[0].length;j++){
             boolean[][] vis=new boolean[grid.length][grid[0].length];
             if(grid[i][j]!=0){
                maxGold=Math.max(maxGold,goldUtil(grid,i,j,vis,0));
             }
         }
     }
     return maxGold;
    }
}
