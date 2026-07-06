package OnlinePlatform;

import java.util.ArrayList;
import java.util.List;

public class SafestpathInGrid2812 {
    public void util(List<List<Integer>>grid,List<List<Integer>>safePoint,List<List<Integer>>thiefPoint){
        for(int i=0;i<grid.size();i++){
            for(int j=0;j<grid.size();j++){
                int ans=Integer.MAX_VALUE;
                for(int k=0;k<thiefPoint.size();k++){
                    int temp=Math.abs(thiefPoint.get(k).get(0)-i)
                            +Math.abs(thiefPoint.get(k).get(1)-j);
                    ans=Math.min(ans,temp);
                }
                safePoint.get(i).set(j, ans);
            }
        }
    }
    int answer = Integer.MIN_VALUE;

    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public void dfs(int row,
                    int col,
                    int currentSafeness,
                    List<List<Integer>> safePoint,
                    boolean[][] visited) {

        int n = safePoint.size();

        if (row == n - 1 && col == n - 1) {
            answer = Math.max(answer, currentSafeness);
            return;
        }

        visited[row][col] = true;

        for (int k = 0; k < 4; k++) {

            int nr = row + dr[k];
            int nc = col + dc[k];

            if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < n &&
                    !visited[nr][nc]) {

                int newSafeness =
                        Math.min(currentSafeness,
                                safePoint.get(nr).get(nc));

                dfs(nr, nc, newSafeness, safePoint, visited);
            }
        }

        visited[row][col] = false;
    }
    public int maximumSafenessFactor(List<List<Integer>> grid) {
   List<List<Integer>>thiefPoint=new ArrayList<>();
        ArrayList<Integer>temp;
   for(int i=0;i<grid.size();i++){
       for(int j=0;j<grid.size();j++){
           if(grid.get(i).get(j)==1){
               temp=new ArrayList<>();
               temp.add(i);
               temp.add(j);
               thiefPoint.add(temp);
           }
       }
   }
List<List<Integer>>safePoint=new ArrayList<>();
   int n=safePoint.size();
   util(grid,safePoint,thiefPoint);
        boolean[][] visited = new boolean[n][n];
        dfs(
                0,
                0,
                safePoint.get(0).get(0),
                safePoint,
                visited
        );
        return answer;
    }
}
