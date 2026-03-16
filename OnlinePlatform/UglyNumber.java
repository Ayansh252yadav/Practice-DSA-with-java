package OnlinePlatform;

import java.util.ArrayList;
import java.util.Arrays;

public class UglyNumber {
    public static boolean isUgly(int n) {
        ArrayList<Integer>arr =new ArrayList<>();
        for(int i = 2; i <= n; i++) {
            while(n % i == 0) {
                arr.add(i);
                n = n / i;
            }
            }
        boolean flag=false;
        for(int i=0;i<arr.size();i++){
            int num=arr.get(i);
            if(num==2||num==3|| num==5){
                flag=true;
            }else {
                flag=false;
                break;
            }
        }
        if(flag){
            return true;
        }

      return false;
    }
    public static boolean isUgly1(int n) {

        if(n <= 0){
            return false;
        }

        int[] primes = {2,3,5};

        for(int p : primes){
            while(n % p == 0){
                n = n / p;
            }
        }

        return n == 1;
    }
    public static void main(String[] args) {
//        System.out.println(isUgly(14));
        System.out.println(isUgly1(14));
    }
}
