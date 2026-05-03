package OnlinePlatform;

import java.util.Arrays;

public class ArrayPartition561 {
    public static int pairSum(int i,int j ){
        return Math.min(i,j);
    }
    public static int arrayPairSum(int[] nums) {
        int sum=0;
        Arrays.sort(nums);
  for(int i=0;i<nums.length;i+=2){
   sum+=pairSum(nums[i],nums[i+1]);
  }
  return sum;
    }

    public static void main(String[] args) {
        int []arr={6,2,6,5,1,2};
        System.out.println(arrayPairSum(arr));
    }
}
