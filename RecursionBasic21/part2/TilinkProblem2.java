package RecursionBasic21.part2;

public class TilinkProblem2 {
    public static int findWays(int n){
        if(n==1 || n==0){
            return 1;
        }
        int vertical=findWays(n-1);
        int horizontal=findWays(n-2);
        return (vertical+horizontal);
    }

    public static void main(String[] args) {
        System.out.println(findWays(3));
    }
}
