package OnlinePlatform;

import java.util.*;

public class NextGreaterElement1_496 {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

      int result[]=new int[nums1.length];
      for(int i=0;i<nums1.length;i++){
          for(int j=0;j<nums2.length;j++){
              int temp=j;
              if(nums1[i]==nums2[j]){
                  while(j<nums2.length){
                      if(nums2[j]>nums1[i]){
                          result[i]=nums2[j];
                          break;
                      }else{
                          result[i]=-1;
                          j++;
                      }
                  }
                  j=temp;
              }
          }
      }
      return result;
    }
//optimize approach
    public static int [] nextGreaterElemennt1(int nums1[],int nums2[]){
        Map<Integer,Integer>map=new HashMap<>();
        Stack<Integer>stack=new Stack<>();
         for(int num:nums2){
             while (!stack.isEmpty() && stack.peek()<num){
                 map.put(stack.pop(),num);
             }
             stack.push(num);
         }

         while (!stack.isEmpty()){
             map.put(stack.pop(),-1);
         }
         int result[]=new int[nums1.length];
         for(int i=0;i<nums1.length;i++){
             result[i]=map.get(nums1[i]);
         }
         return result;
    }
    public static void main(String[] args) {
        int arr[]={4,1,2};
        int nums2[]={1,3,4,2};
//        System.out.println(Arrays.toString(nextGreaterElement(arr,nums2)));
        System.out.println(Arrays.toString(nextGreaterElemennt1(arr,nums2)));
    }
}
