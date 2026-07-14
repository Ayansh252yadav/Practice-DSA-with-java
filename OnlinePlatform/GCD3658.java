package OnlinePlatform;

public class GCD3658 {
    public int gcd(int a,int b){
        while (b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
    public int gcdOfOddEvenSums(int n) {
     int oddSum=(int)Math.pow(n,2);
     int evenSum=n*(n+1);
     return gcd(oddSum,evenSum);
    }
}
