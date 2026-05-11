package OnlinePlatform;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class SummOFNumberWithUnitDigitK2310 {
    public static int minimumNumbers(int num, int k) {
        if(num == 0){
            return 0;
        }
    for(int i=1;i<=num;i++){
        if((i * k) % 10 == num % 10 && i * k <= num){
            return i;
        }
    }
    return -1;
    }

    public static void main(String[] args) {
        System.out.println(minimumNumbers(58,9));
    }
}
