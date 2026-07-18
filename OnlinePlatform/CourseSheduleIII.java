package OnlinePlatform;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CourseSheduleIII {
    public static int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>((a, b) -> b - a);
        int time = 0;
        for (int[] course : courses) {
            time += course[0];
            maxHeap.offer(course[0]);
            if (time > course[1]) {
                time -= maxHeap.poll();
            }
        }
        return maxHeap.size();
    }

    public static void main(String[] args) {
//     int [][]   courses ={{100,200},{200,1300},{1000,1250},
//             {2000,3200}};
        int [][]courses={{5,5},{4,6},{2,6}};
        System.out.println(scheduleCourse(courses));
        int n=Integer.parseInt("10",6);
        System.out.println(n);
    }
}
