package OnlinePlatform;

public class PathMinEffort1631 {
    int minPath=Integer.MAX_VALUE;
    public void minPAthUtil(int [][]heights,int i,int j,boolean[][]vis,int currPath){
        if(i<0 || i>heights.length-1 || j<0 || j>heights[0].length-1){
            return ;
        }

        if (vis[i][j]){
            return ;
        }
        vis[i][j]=true;
        if(i==heights.length-1 && j==heights[0].length-1){
            minPath=Math.min(minPath,currPath);
            vis[i][j]=false;
            return;
        }
        minPAthUtil(heights,i-1,j,vis,currPath);
        minPAthUtil(heights,i+1,j,vis,currPath);
        minPAthUtil(heights,i,j-1,vis,currPath);
        minPAthUtil(heights,i,j+1,vis,currPath);
        vis[i][j]=false;
    }
    public int minimumEffortPath(int[][] heights) {
       minPath=Integer.MAX_VALUE;
       boolean[][] vis=new boolean[heights.length][heights[0].length];
       minPAthUtil(heights,0,0,vis,0);
       return minPath;
    }
}
