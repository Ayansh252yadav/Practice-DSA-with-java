package OnlinePlatform;

import java.util.ArrayDeque;

public class Pattern132_456 {
    public boolean find132pattern(int[] nums) {
   for(int i=0;i<nums.length;i++){
       for(int j=i+1;j<nums.length;j++){
           for(int k=j+1;k<nums.length;k++){
               if(i<j && j<k && nums[i]<nums[k] && nums[k]<nums[j]){
                     return true;
               }
           }
       }
   }
   return false;
    }
    public static boolean find132patternOptimized(int[] nums) {
       int second=Integer.MIN_VALUE;
      ArrayDeque<Integer> stack = new ArrayDeque<>();
      for(int i= nums.length-1;i>=0;i--){
          if(!stack.isEmpty() && nums[i]<second &&second<stack.peek()){
              return true;
          }
          while(!stack.isEmpty()&& stack.peek()<nums[i]){
            second= stack.pop();
          }
          stack.push(nums[i]);
      }
      while(!stack.isEmpty()){
          System.out.println(stack.pop());
      }
      return false;
    }

    public static void main(String[] args) {
        int []nums={3,1,4,2};
        System.out.println(find132patternOptimized(nums));
    }
}
