package OnlinePlatform;

public class NumberofValidParentesisGFG {
    public static long fact(int n){
        if(n==0 || n==1){
            return 1;
        }
        long fact=1;
        for(int i=1;i<=n;i++){
            fact*=i;
        }
        return fact;
    }
    //using catalan
    public static int findWays(int n){
        if(n%2==1){
            return 0;
        }
        int k=n/2;
        long numerator=fact(2*k);
        long denominator=fact(k+1)*fact(k);
        return (int)(numerator/denominator);
    }

    public static void main(String[] args) {
        System.out.println(findWays(6));
    }
}
