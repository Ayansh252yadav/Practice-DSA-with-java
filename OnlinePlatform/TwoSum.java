package OnlinePlatform;
import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
//    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//    You may assume that each input would have exactly one solution, and you may not use the same element twice.
//    You can return the answer in any order
    public static int [] twoSumIndex(int arr[],int n, int target ){

       for(int i=0;i<n;i++){
           for(int j=i+1;j<n;j++){
               if( arr[i]+arr[j]==target){
                  return new int[]{i,j};
               }
           }
       }
       return new int[]{-1,-1};
    }

    public static int [] Twosum(int nums[],int target){
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        int needed=0;
        for(int i=0;i<nums.length;i++){
            needed=target-nums[i];
            if(map.containsKey(needed)&& map.get(needed) != i){
                int index=map.get(needed);
                return new int []{i,index};
            }
        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
        int arr[]={3,4,2};
//        System.out.println(Arrays.toString(twoSumIndex(arr,arr.length,26)));
        System.out.println(Arrays.toString(Twosum(arr,6)));
    }
}
