package OnlinePlatform;

import java.util.ArrayList;
import java.util.Collections;

public class MaximumProductOfTwoDigit3536 {
    public static void digit(int num, ArrayList<Integer> digits) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
       while (num > 0) {
           int digit = num % 10;
           digits.add(digit);
           num = num / 10;
       }
    }
    public int maxProduct(int n) {
       ArrayList<Integer> digits = new ArrayList<>();
       digit(n, digits);
       Collections.sort(digits);
       int size=digits.size();
       return digits.get(size-1)*digits.get(size-2);
    }
}
