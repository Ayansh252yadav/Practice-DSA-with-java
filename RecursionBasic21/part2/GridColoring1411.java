package RecursionBasic21.part2;

public class GridColoring1411 {

    static final int MOD = 1_000_000_007;
    public static int numOfWays(int n,long A,long B){

       if(n==1){
           return (int)((A+B)%(MOD));
       }
       long newA=(2*A+2*B)%MOD;
       long newB=(2*A+3*B)%MOD;
       A=newA;
       B=newB;
       return numOfWays(n-1,A,B);
    }

    public static void main(String[] args) {
        System.out.println(numOfWays(5000,6,6));
    }
}
