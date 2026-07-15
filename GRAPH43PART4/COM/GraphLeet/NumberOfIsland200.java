package GRAPH43PART4.COM.GraphLeet;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIsland200 {
    public static void bfs(char [][]grid,int i,int j,boolean [][] vis){
        Queue<int[]> queue=new LinkedList<int[]>();
        queue.add(new int[] {i,j});
        int []dr={1,-1,0,0};
        int []dc={0,0,-1,1};
        while(!queue.isEmpty()){
            int[] curr=queue.poll();
            int row=curr[0];
            int col=curr[1];
            for(int k=0;k<4;k++){
                int nr=row+dr[k];
                int nc=col+dc[k];
                if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && !vis[nr][nc]){
                    vis[nr][nc]=true;
                    if(grid[nr][nc]=='1'){
                        queue.add(new int[] {nr,nc});
                    }
                }
            }
        }
    }
    public static void dfs(char [][]grid,int i,int j,boolean[][] visited){
       if(i<0 || i>grid.length-1 || j<0 || j>grid[0].length-1){
           return ;
       }
       if(visited[i][j]){
           return;
       }
       visited[i][j]=true;
       if(grid[i][j]=='1'){
           dfs(grid,i+1,j,visited);
           dfs(grid,i,j+1,visited);
           dfs(grid,i-1,j,visited);
           dfs(grid,i,j-1,visited);
       }
    }
    public static int numIslands(char[][] grid) {
    boolean[][] visited=new boolean[grid.length][grid[0].length];
         int counter=0;
    for(int i=0;i<grid.length;i++){
        for(int j=0;j<grid[0].length;j++){
            if(!visited[i][j] && grid[i][j]=='1'){
                dfs(grid,i,j,visited);
                counter++;
            }
        }
    }
    return counter;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(numIslands(grid));
    }
}
