package OnlinePlatform;


public class search2D240 {
    public static boolean searchMatrix(int[][] matrix, int target) {
      for(int i=0;i<matrix.length;i++) {
          int start = 0;
          int end = matrix[0].length;
          while (start <= end) {
              int mid = start + (end - start) / 2;
              if (matrix[i][mid] == target) {
                   return true;
              }else if(target<matrix[i][mid]){
                  end=mid-1;
              }else{
                  start=mid+1;
              }
          }
      }
      return false;
    }

    public static void main(String[] args) {
        int [][]matrix = {{1,4,7,11,15},{2,5,8,12,19},
        {3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target = 5;
        System.out.println(searchMatrix(matrix,target));
    }
}
