package OnlinePlatform;

import java.util.PriorityQueue;

public class KthLargestElement215 {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        for(int e:nums){
           pq.add(e);
        }
        for(int i=0;i<nums.length-k;i++){
            pq.remove();
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int  []nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(findKthLargest(nums,k));
    }
}
