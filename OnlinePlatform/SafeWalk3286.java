package OnlinePlatform;

import java.util.List;

public class SafeWalk3286 {
    int ans=Integer.MIN_VALUE;
    int[]dr={1,-1,0,0};
    int []dc={0,0,1,-1};
    public void dfs(int row,int col,List<List<Integer>>grid
            ,boolean [][]visited,int health){
        int n=grid.size();
        int m=grid.get(0).size();
        if(health<=0){
            return;
        }
        if(row==n-1 && col==m-1){
            ans = Math.max(ans, health);
            return;
        }
        visited[row][col]=true;
        for(int k=0;k<4;k++){
            int nr=row+dr[k];
            int nc=col+dc[k];
            if(nr>=0&& nr<n && nc>=0 && nc<=m && !visited[nr][nc]){
                int newHealth = health - grid.get(nr).get(nc);
            dfs(nr,nc,grid,visited,newHealth);
            }
        }
        visited[row][col]=false;
    }
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n=grid.size();
        int m=grid.get(0).size();
        boolean visited[][]=new boolean[n][m];
        int startHealth = health - grid.get(0).get(0);
        dfs(0, 0, grid, visited, startHealth);
        return ans>0;
    }
}
