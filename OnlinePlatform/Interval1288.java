package OnlinePlatform;

import java.util.Arrays;
import java.util.Collections;

public class Interval1288 {
    public static int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0]==b[0] ? b[1]-a[1] : a[0]-b[0]);
               int count = 0;
               int end = 0;
               for (int[] e : intervals) {
                   if (e[1] > end) {
                       count++;
                       end = e[1];
                   }
               }
           return count;
        }

    public static void main(String[] args) {
        int [][]intervals = {{1,4},{3,6},{2,8}};
        System.out.println(removeCoveredIntervals(intervals));
    }
}
