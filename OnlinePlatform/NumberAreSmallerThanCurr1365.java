package OnlinePlatform;

import java.util.Arrays;

public class NumberAreSmallerThanCurr1365 {
    public static int[] smallerNumbersThanCurrent(int[] nums) {
    int []track=new int[nums.length];
       for(int i=0;i<nums.length;i++){
           int count=0;
           for(int j=0;j<nums.length;j++){
               if(nums[i]>nums[j]){
                   count++;
               }
           }
           track[i]=count;
       }
       return   track;
    }

    public static void main(String[] args) {
        int []arr={8,1,2,2,3};
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(arr)));
    }
}
