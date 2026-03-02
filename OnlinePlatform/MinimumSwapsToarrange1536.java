package OnlinePlatform;


import java.util.Arrays;

public class MinimumSwapsToarrange1536 {
    public static int minSwaps(int[][] grid) {
      int n=grid.length;
      int []zeros=new int[n];

      for(int i=0;i<n;i++){
          int count=0;
          for(int j=n-1;j>=0;j--){
              if(grid[i][j]==0){
                  count++;
              }
              else{
                  break;
              }
          }
          zeros[i]=count;
      }
        System.out.println(Arrays.toString(zeros));
   int swaps=0;
      for(int i=0;i<n;i++){
          int required=n-i-1;
          int j=i;
          while (j<n && zeros[j]<required){
              j++;
          }
          if(j==n) return -1;

          while (j>i){
              int temp = zeros[j];
              zeros[j] = zeros[j - 1];
              zeros[j - 1] = temp;
              swaps++;
              j--;
          }
      }
        System.out.println(Arrays.toString(zeros));
      return swaps;
    }
public static void main(String[] args) {
    int [][]grid = {{0,0,1},{1,1,0},{1,0,0}};
    System.out.println(minSwaps(grid));
}
}
