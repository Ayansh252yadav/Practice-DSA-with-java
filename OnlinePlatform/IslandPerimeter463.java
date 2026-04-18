package OnlinePlatform;

public class IslandPerimeter463 {
    public static int perimeter(int [][]grid,int row,int col){
        int count=0;
        //left check
        if(col-1>=0){
            if(grid[row][col-1]==0){
                count+=1;
            }
        }else{
            count++;
        }
        //right check
        if(col+1<grid[0].length){
            if(grid[row][col+1]==0){
                count+=1;
            }
        }else{
            count++;
        }
        //top check
        if(row-1>=0){
            if(grid[row-1][col]==0){
                count++;
            }
        }else{
            count++;
        }
        //bottom check
        if(row+1<grid.length) {
            if (grid[row + 1][col] == 0) {
                count++;
            }
        }else{
            count++;
        }
        return count;
    }
    public static  int islandPerimeter(int[][] grid) {
        int sum=0;
     for(int i=0;i<grid.length;i++){
         for(int j=0;j<grid[0].length;j++){
             if(grid[i][j]==1){
                sum+=  perimeter(grid,i,j);
             }
         }
     }
     return sum;
    }

    public static void main(String[] args) {
        int [][]grid={{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        System.out.println(islandPerimeter(grid));
    }
}
