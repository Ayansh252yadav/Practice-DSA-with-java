package OnlinePlatform;

import java.util.*;

public class SumOfDistance2615 {
    public static long[] distance(int []nums){
        Map<Integer, List<Integer>> mp=new HashMap<>();
        long[] res=new long[nums.length];
        for(int i=0;i<nums.length;i++){
            mp.computeIfAbsent(nums[i],k->new ArrayList<>()).add(i);
        }
        for(int i=0;i<nums.length;i++){
            int sum=0;
            List<Integer>temp=mp.get(nums[i]);
            for(int idx:temp){
                sum+=Math.abs(i-idx);
            }
            res[i]=sum;
        }
        return res;
    }
    public long[] distance1(int[] nums) {
        long[]res=new long[nums.length];
        int interSum=0;
         for(int i=0;i<nums.length;i++){
             interSum=0;
             for(int j=0;j<nums.length;j++){
               if(nums[i]==nums[j] && j!=i){
                  interSum+=Math.abs(i-j);
               }
             }
             res[i]=interSum;
         }

        return res;
    }

    public static void main(String[] args) {
        int []nums={1,3,1,1,2};
        System.out.println(Arrays.toString(distance(nums)));
    }
}
