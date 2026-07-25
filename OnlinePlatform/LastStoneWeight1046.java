package OnlinePlatform;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight1046 {
    public static int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer>pq=
                new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            pq.offer(stone);
        }
        while(pq.size()>1){
            int firstLargest=pq.poll();
            int secondLargest=pq.poll();
            if(firstLargest==secondLargest){
                continue;
            }
            if(firstLargest>secondLargest){
                pq.offer(firstLargest-secondLargest);
            }
        }
        return pq.isEmpty()?0:pq.peek();
    }

    public static void main(String[] args) {
        int [] arr={2,7,4,1,8,1};
        System.out.println(lastStoneWeight(arr));
    }
}
