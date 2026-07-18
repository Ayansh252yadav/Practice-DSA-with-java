package OnlinePlatform;

import java.util.ArrayList;
import java.util.List;

public class SafestPAth2812 {
    public static void calculateSafeFactor(List<List<Integer>> grid,
                                           ArrayList<int []>thief){
        int minFact=Integer.MAX_VALUE;
        for(int i=0;i<grid.size();i++){
            for(int j=0;j<grid.get(i).size();j++){
                minFact=Integer.MAX_VALUE;
                for(int k=0;k<thief.size();k++){
                    minFact=Math.min(minFact,
                            Math.abs(thief.get(k)[0] - i)
                                    + Math.abs(thief.get(k)[1] - j));
                }
               grid.get(i).set(j,minFact);
            }
        }
        System.out.println(grid);
    }
    static int max=Integer.MIN_VALUE;
    public static void safePath(List<List<Integer>> grid,int i,int j,boolean [][] vis,
                                int currMin){
        int n = grid.size();
        if(i<0 || i>=grid.size()-1 || j<0 || j>=grid.get(0).size()-1){
            return ;
        }
        if(grid.get(i).get(j)==0){
            return;
        }
        if(vis[i][j]){
            return;
        }
        vis[i][j]=true;
        currMin=Math.min(currMin,grid.get(i).get(j));
        if(i==n-1 && j==n-1){
            max=Math.max(max,currMin);
            vis[i][j]=false;
            return;
        }
        safePath(grid,i,j+1,vis,currMin);
        safePath(grid,i+1,j,vis,currMin);
        safePath(grid,i,j-1,vis,currMin);
        safePath(grid,i-1,j,vis,currMin);
        vis[i][j]=false;
    }
    public static int maximumSafenessFactor(List<List<Integer>> grid) {
        ArrayList<int []>thief=new ArrayList<>();
     for(int i=0;i<grid.size();i++){
         for(int j=0;j<grid.get(i).size();j++){
             if(grid.get(i).get(j)==1){
                 thief.add(new int[]{i,j});
             }
         }
     }
     calculateSafeFactor(grid,thief);
     boolean [][]vis=new boolean[grid.size()][grid.get(0).size()];
     safePath(grid,0,0,vis,Integer.MAX_VALUE);
     return max==Integer.MAX_VALUE?0:max;
    }

    public static void main(String[] args) {
//        int [][]grid={{0 ,0, 0},
//                {0 ,1, 0},
//                {0 ,0, 0}};
        List<List<Integer>> grid=new ArrayList<>();
        grid.add(new ArrayList<>(List.of(1)));
//        grid.add(new ArrayList<>(List.of(0,0,0)));
//        grid.add(new ArrayList<>(List.of(0,0,1)));
        System.out.println(maximumSafenessFactor(grid));
    }
}
