package OnlinePlatform;

public class SpecialPosition1582 {
    public static int numSpecial(int[][] mat) {
        int []rowCount=new int[mat.length];
        int []colCount=new int[mat[0].length];
        int n=mat.length;
        int m=mat[0].length;
        // Step 1: Count 1s in each row and column
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1 && rowCount[i] == 1 && colCount[j] == 1) {
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
