package OnlinePlatform;

import java.util.Arrays;

public class RotateTheBox1861 {
    public static void swap(char[][]res,int i,int j){
        //down
        for(int k=i;k<res.length-1;k++){
            if(res[k+1][j]=='.' && res[k][j]=='#'){
                char temp=res[k][j];
                res[k][j]=res[k+1][j];
                res[k+1][j]=temp;
            }else{
                break;
            }
        }
    }
    public static char[][] rotateTheBox(char[][] boxGrid) {
     int n=boxGrid.length;
     int m=boxGrid[0].length;
     char[][]res=new char[m][n];
     for(int j=0;j<m;j++){
         for(int i=n-1;i>=0;i--){
            res[j][n-1-i]=boxGrid[i][j];
         }
     }
     for(int i= res.length-1;i>=0;i--){
         for(int j=0;j<res[0].length;j++){
             if(res[i][j]=='#'){
                 swap(res,i,j);
             }
         }
     }
     return res;
    }

    public static void main(String[] args) {
        char[][]boxGrid = {{'#','.','#'}};
        System.out.println(Arrays.deepToString(rotateTheBox(boxGrid)));
    }
}
