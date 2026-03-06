package OnlinePlatform;

import java.util.Stack;

public class BinaryStringHasAtmostOne1784 {
    public static boolean checkOnesSegment(String s) {
        boolean seenOneSegment = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                if (i == 0 || s.charAt(i-1) == '0') {
                    if (seenOneSegment) {
                        return false;
                    }
                    seenOneSegment = true;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkOnesSegment("1001"));
    }
}
