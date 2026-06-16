package OnlinePlatform;

public class ThreeDivisors1952 {
    private static boolean isPrime(int n){
        if(n<2){
            return false;
        }
        for(int i=2;i<n/2;i++){
         if(n%i==0){
             return false;
         }
        }
        return true;
    }
    public static boolean isThree(int n) {
        int root=(int)Math.sqrt(n);
        if(root*root!=n){
            return false;
        }
        return isPrime(n);
    }

    public static void main(String[] args) {
        System.out.println(isThree(4));
    }
}
