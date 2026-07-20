package OnlinePlatform;

import java.util.*;

public class MinimumObStacles2290 {
    static int minStep=Integer.MAX_VALUE;
    public static void obstaclesUtil(int [][]grid,int i,int j,
                                     boolean [][] visited,int currObs){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length){
            return;
        }
        if(currObs >= minStep){
            return;
        }
        if(visited[i][j]){
            return;
        }
        visited[i][j]=true;
        if(grid[i][j]==1){
         currObs++;
        }
        if(i==grid.length-1 && j==grid[0].length-1){
            minStep=Math.min(minStep,currObs);
            currObs=0;
            visited[i][j]=false;
            return;
        }
        obstaclesUtil(grid,i-1,j,visited,currObs);
        obstaclesUtil(grid,i+1,j,visited,currObs);
        obstaclesUtil(grid,i,j-1,visited,currObs);
        obstaclesUtil(grid,i,j+1,visited,currObs);
        visited[i][j]=false;
    }
    static class Pair implements Comparable<Pair>{
        int row;
        int col;
        int cost;
        public Pair(int row,int col,int cost){
            this.row=row;
            this.col=col;
            this.cost=cost;
        }
        @Override
        public int compareTo(Pair o) {
            return cost-o.cost;
        }
    }
    public static int obstUtil(int [][]grid){
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int [][]dist = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0]=0;
       PriorityQueue<Pair> dq = new PriorityQueue<Pair>();
       dq.add(new Pair(0,0,0));
       while(!dq.isEmpty()){
           Pair curr = dq.poll();
           int row=curr.row;
           int col=curr.col;
           for (int k = 0; k < 4; k++) {
               int nr = row + dr[k];
               int nc = col + dc[k];
               if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length){
                  if(curr.cost+grid[nr][nc]<dist[nr][nc]){
                      dist[nr][nc]=curr.cost+grid[nr][nc];
                    dq.offer(new Pair(nr,nc,dist[nr][nc]));
                  }
               }
           }
       }
       return dist[grid.length-1][grid[0].length-1];
    }
    public static int minimumObstacles(int[][] grid) {
        boolean[][] visited=new boolean[grid.length][grid[0].length];
     obstaclesUtil(grid,0,0,visited,0);
     return minStep;
    }

    public static void main(String[] args) {
        int [][]grid={{0,1,1},
                {1,1,0},
                {1,1,0}};
        System.out.println(minimumObstacles(grid));
    }
}
