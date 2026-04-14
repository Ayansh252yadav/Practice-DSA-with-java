package OnlinePlatform;

public class SetMatrixZero73 {
    public static void transform(int [][]matrix,int row,int col){
        //make row up zero
        for(int i=row;i>=0;i--){
            matrix[i][col]=0;
        }
        //make row down zero
        for(int i=row;i<matrix.length;i++){
            matrix[i][col]=0;
        }
        //make col left zero
        for(int i=col;i>=0;i--){
            matrix[row][i]=0;
        }
        //make col right zero
        for(int i=col;i<matrix[0].length;i++){
            matrix[row][i]=0;
        }
    }
    public static void setZeroes(int[][] matrix) {
        int [][] ans=new int[matrix.length][matrix[0].length];
        for(int i=0;i<ans.length;i++){
            for(int j=0;j<ans[0].length;j++){
             ans[i][j]=matrix[i][j];
            }
        }
     for(int i=0;i<ans.length;i++){
         for(int j=0;j<ans[0].length;j++){
             if(ans[i][j]==0){
              transform(matrix,i,j);
             }
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
        int [][]matrix={{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(matrix);
    }
}
