package Backtracking24;

public class DetectcycleInGrid1559 {
    public static boolean dfs(char[][] grid, boolean [][]vis,int i,int j,int pi,int pj){
        vis[i][j] = true;

        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};

        for(int[] d : dir){
            int ni = i + d[0];
            int nj = j + d[1];
            if(ni >= 0 && nj >= 0 && ni < grid.length && nj < grid[0].length
                    && grid[ni][nj] == grid[i][j]){
                if(!vis[ni][nj]){
                    if(dfs(grid, vis, ni, nj, i, j)) return true;
                }
                else if(ni != pi || nj != pj){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean containsCycle(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] vis = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j]){
                    if(dfs(grid, vis, i, j, -1, -1)){
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
