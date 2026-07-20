package OnlinePlatform;

import java.util.ArrayList;
import java.util.List;

public class Shift2DGrid1260 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int m=grid.length;
        int n=grid[0].length;
        while (k!=0){
            for (int i = 0; i < grid.length-1; i++) {
                for (int j = 0; j < grid[0].length-1; j++) {
                  res.get(i).set(j,grid[i][j + 1]);
                  res.get(i).set(n-1,grid[i + 1][0]);
                  res.get(m-1).set(n-1,grid[0][0]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
