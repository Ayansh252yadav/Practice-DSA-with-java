package OnlinePlatform;

import java.util.Arrays;

public class ArrayCanBeSorted3011 {
   public void swap(int []nums){
       for(int j=0;j<nums.length-1;j++){
           int bitCount1=Integer.bitCount(nums[j]);
           int bitCount2=Integer.bitCount(nums[j+1]);
           if(bitCount1==bitCount2 && nums[j]>nums[j+1]){
               int temp=nums[j];
               nums[j]=nums[j+1];
               nums[j+1]=temp;
           }
       }
   }
    public  boolean canSortArray(int[] nums) {
        for(int i=0;i<nums.length-1;i++){
         swap(nums);
        }
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                return false;
            }
        }
       return true;
    }

    public static void main(String[] args) {
    int []arr={8,4,2,30,15};
//        System.out.println(canSortArray(arr));
    }
}
