package RecursionBasic21.part2;

public class TilingProblem {
    public static int countWays(int n){
        if(n==0 || n==1){
            return 1;
        }
        return countWays(n-1)+countWays(n-2);
    }
    public static void main(String[] args) {
        System.out.println(countWays(4));
    }
}
