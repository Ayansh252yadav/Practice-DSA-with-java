package OnlinePlatform;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges994 {
    static class Info{
        int row;
        int col;
        int time;
        Info(int row,int col,int time){
            this.row=row;
            this.col=col;
            this.time=time;
        }
    }
    public static int orangesRotting(int[][] grid) {
     int m=grid.length;
     int n=grid[0].length;
     int cntFresh=0;
     int[][] visited=new int[m][n];
        Queue<Info>q=new LinkedList<>();
     for(int i=0;i<m;i++){
         for(int j=0;j<n;j++){
             if(grid[i][j]==1){
                 cntFresh++;
             }
             if(grid[i][j]==2){
                 q.add(new Info(i,j,0));
                 visited[i][j]=2;
             }else{
                 visited[i][j]=0;
             }
         }
     }
     int tm=0;
     int []dr={1,-1,0,0};
     int []dc={0,0,1,-1};
     int cnt=0;
     while (!q.isEmpty()){
         Info rot = q.remove();
         int row=rot.row;
         int col=rot.col;
         int time=rot.time;
         tm=Math.max(tm,time);
         for(int i=0;i<4;i++){
             int nr=row+dr[i];
             int nc=col+dc[i];
             if(nr>=0&&nr<m&&nc>=0&&nc<n && visited[nr][nc]!=2 && grid[nr][nc]==1){
                 visited[nr][nc]=2;
                 q.add(new Info(nr,nc,time+1));
                 cnt++;
             }
         }
     }
        if(cnt!=cntFresh){
            return -1;
        }
        return tm;
    }
    public static void main(String[] args) {
        int [][]grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(grid));
    }
}
