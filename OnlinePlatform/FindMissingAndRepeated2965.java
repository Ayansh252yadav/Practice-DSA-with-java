package OnlinePlatform;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindMissingAndRepeated2965 {
    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        Set<Integer> arr=new HashSet<>();
        int n=grid.length;
        int dul=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!arr.contains(grid[i][j])){
                    arr.add(grid[i][j]);
                }else{
                    dul=grid[i][j];
                }
            }
        }
        int []res=new int[2];
        for(int i=1;i<=n*n;i++){
            if(!arr.contains(i)){
                res[1]=i;
            }
        }
        res[0]=dul;
        return res;
    }

    public static void main(String[] args) {
        int [][]grid={{1,3},{2,2}};
        System.out.println(Arrays.toString(findMissingAndRepeatedValues(grid)));
    }
}
