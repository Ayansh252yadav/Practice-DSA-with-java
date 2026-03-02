package OnlinePlatform;

public class SpecialPosition1582 {
    public static int numSpecial(int[][] mat){
        int count=0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int [][]arr={{1,0,0},{0,0,1},{1,0,0}};
        System.out.println(numSpecial(arr));
    }
}
