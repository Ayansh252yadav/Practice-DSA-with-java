package OnlinePlatform;

import java.util.ArrayDeque;
import java.util.Queue;

public class MakeThreeString2937 {
    public int findMinimumOperations(String s1, String s2, String s3) {
        int minLen = Math.min(s1.length(), Math.min(s2.length(), s3.length()));

        int commonLen = 0;
        for (int i = 0; i < minLen; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            char c3 = s3.charAt(i);
            if (c1 == c2 && c2 == c3) {
                commonLen++;
            } else {
                break;
            }
        }
        if (commonLen == 0) {
            return -1;
        }

        int operations = (s1.length() - commonLen)
                + (s2.length() - commonLen)
                + (s3.length() - commonLen);

        return operations;
    }
}
