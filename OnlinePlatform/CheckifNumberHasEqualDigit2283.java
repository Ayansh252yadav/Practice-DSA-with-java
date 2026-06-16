package OnlinePlatform;

import java.lang.reflect.Array;
import java.util.*;

public class CheckifNumberHasEqualDigit2283 {
    public static boolean digitCount(String num) {
        int[] freq = new int[10];
        for (int i = 0; i < num.length(); i++) {
            freq[num.charAt(i) - '0']++;
        }
        System.out.println(Arrays.toString(freq));
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i)-48!= freq[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String num = "030";
        System.out.println(digitCount(num));
    }
}
