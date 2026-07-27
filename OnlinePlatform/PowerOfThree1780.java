package OnlinePlatform;

import java.util.Arrays;

public class PowerOfThree1780 {
    public static boolean checkPowersOfThree(int n) {
     int []arr=new int[15];
     for(int i=0;i<15;i++){
         arr[i]=(int)Math.pow(3,i);
     }
        for (int i = 14; i >= 0; i--) {
            if (arr[i] <= n) {
                n -= arr[i];
            }
        }
        return n==0;
    }
    public static boolean checkPowersOfThree1(int n) {
        while (n > 0) {
            if (n % 3 == 2) {
                return false;
            }
            n /= 3;
        }
        return true;
    }
    public static void main(String[] args) {
        checkPowersOfThree(3);
    }
}
