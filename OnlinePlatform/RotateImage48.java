package OnlinePlatform;

public class RotateImage48 {
    public static void swap(int[][]mat,int i,int j,int k,int l){
        int temp=mat[i][j];
        mat[i][j]=mat[k][l];
        mat[k][l]=temp;
    }
    public static void rotate(int[][] matrix) {
    for(int i=0;i<matrix.length;i++){
        for(int j=i;j<matrix[0].length;j++){
            swap(matrix,i,j,j,i);
        }
    }
        for (int i = 0; i < matrix[0].length / 2; i++) {
            for (int j = 0; j < matrix.length; j++) {
                swap(matrix, j, i, j, matrix[0].length - i - 1);
            }
        }
    for(int i=0;i<matrix.length;i++){
        for(int j=0;j<matrix[0].length;j++){
            System.out.print(matrix[i][j]+" ");
        }
        System.out.println();
    }
    }

    public static void main(String[] args) {
        int [][]matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
    }
}
