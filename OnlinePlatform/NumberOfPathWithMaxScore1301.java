package OnlinePlatform;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfPathWithMaxScore1301 {
    static int sum=Integer.MIN_VALUE;
    static int path;
    static final int MOD = 1000000007;
    public static void helper(List<String>board,
                              int n,int m,int temp){
        if(n<0 || m<0){
            return;
        }
        if(board.get(n).charAt(m)=='X'){
            return;
        }
        if (n == 0 && m == 0) {
            if (temp > sum) {
                sum = temp;
                path = 1;
            } else if (temp == sum) {
                path++;
            }
            return;
        }
        if(Character.isDigit(board.get(n).charAt(m))){
           temp+=board.get(n).charAt(m)-'0';
        }
        helper(board,n-1,m,temp);
        helper(board,n,m-1,temp);
        helper(board,n-1,m-1,temp);
    }
    public static int[] pathsWithMaxScore(List<String> board) {
        int n=board.size();
        int m=board.getFirst().length();
        sum = Integer.MIN_VALUE;
        path = 0;
        helper(board,n-1,m-1,0);
        if (sum == Integer.MIN_VALUE){
            return new int[]{0, 0};
        }
        return new int[]{sum, path};
    }
    public static void main(String[] args) {
     List<String> board=new ArrayList<String>
             (List.of("E23","2X2","12S"));
        System.out.println(Arrays.toString(pathsWithMaxScore(board)));
    }
}
