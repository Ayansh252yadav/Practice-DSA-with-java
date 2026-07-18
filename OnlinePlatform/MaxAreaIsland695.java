package OnlinePlatform;

public class MaxAreaIsland695 {
    public int  maxArea(int [][]grid,int i,int j, boolean[][]visited){
        if(i<0 || i>grid.length-1 || j<0 || j>grid[0].length-1){
            return 0;
        }
        if(grid[i][j]==0){
          return 0;
        }
        if(visited[i][j]){
          return 0;
        }
        visited[i][j]=true;
        int area=1;
        area+=maxArea(grid,i+1,j,visited);
        area+=maxArea(grid,i,j+1,visited);
        area+=maxArea(grid,i-1,j,visited);
        area+=maxArea(grid,i,j-1,visited);
        return area;
    }
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][]visited=new boolean[grid.length][grid[0].length];
        int maxIs=Integer.MIN_VALUE;
      for(int i=0;i<grid.length;i++){
          for(int j=0;j<grid[0].length;j++){
              if(grid[i][j]==1 && !visited[i][j]){
                  int area=maxArea(grid,i,j,visited);
                  maxIs=Math.max(area,maxIs);
              }
          }
      }
      return maxIs;
    }

    public static void main(String[] args) {
        MaxAreaIsland695 ma=new MaxAreaIsland695();
        int[][] grid = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        System.out.println(ma.maxAreaOfIsland(grid));
    }
}
