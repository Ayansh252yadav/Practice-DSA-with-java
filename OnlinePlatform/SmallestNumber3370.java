package OnlinePlatform;

import java.util.ArrayList;
import java.util.List;

public class SmallestNumber3370 {
    public int smallestNumber(int n) {
        ArrayList<Integer> arr=new ArrayList<>(List.of(1, 3, 7, 15, 31, 63, 127, 255, 511));
        for (Integer e : arr) {
            if (e>=n) {
                return e;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
     SmallestNumber3370 sc=new SmallestNumber3370();
        System.out.println(sc.smallestNumber(5));
    }
}
