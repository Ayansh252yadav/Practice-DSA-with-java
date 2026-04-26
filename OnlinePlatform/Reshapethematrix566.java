package OnlinePlatform;

import java.util.Arrays;

public class Reshapethematrix566 {
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int [][]res=new int[r][c];
        if(mat.length * mat[0].length!=r*c){
            return mat;
        }
        int row=0;
        int col=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                    res[i][j]=mat[row][col];
                    col++;
                if(col==mat[0].length){
                    col=0;
                    row++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int [][]nums={{1,2},{3,4}};
        int [][]temp=matrixReshape(nums,4,1);
        for(int i=0;i<temp.length;i++){
            for(int j=0;j<temp[0].length;j++){
                System.out.print(temp[i][j]+" ");
            }
            System.out.println();
        }
    }

}
