package OnlinePlatform;

public class PrimeNumberOfSetBit762 {
    public static boolean checkPrime(int n){
        if(n==1 || n==0){
            return false;
        }
        for(int i=2;i<=n/2;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    public static int countPrimeBits(int left,int right){
        int primeBit=0;
        while (left<=right){
            String str=Integer.toBinaryString(left);
            int count=0;
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)=='1'){
                    count++;
                }
            }
            if(checkPrime(count)){
                primeBit++;
            }
            left++;
        }
        return primeBit;
    }
//optimize approach
public static boolean checkPrime1(int n){
    if(n < 2) return false;
    for(int i = 2; i * i <= n; i++){
        if(n % i == 0) return false;
    }
    return true;
}

    public static int countPrimeBits1(int left,int right){
        int primeBit = 0;

        while(left <= right){
            int count = Integer.bitCount(left);
            if(checkPrime1(count)){
                primeBit++;
            }
            left++;
        }
        return primeBit;
    }
    public static void main(String[] args) {
        System.out.println(countPrimeBits(6,10));
    }
}
