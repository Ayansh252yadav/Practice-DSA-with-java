package OnlinePlatform;

import java.util.ArrayDeque;
import java.util.Arrays;

public class NextGreater503 {
    public static int[] nextGreaterElements(int[] nums) {
        ArrayDeque<Integer>st=new ArrayDeque<>();
        int []ans=new int[nums.length];
        int n=nums.length;
        for(int i=2*n-1;i>=0;i--){
            int currEl=nums[i%n];
            int temp;
            while (!st.isEmpty() && st.peek()<=currEl){
                st.pop();
            }
            if(st.isEmpty()){
                temp=-1;
            }else{
                temp=st.peek();
            }
            if(i<n){
                ans[i]=temp;
            }
            st.push(currEl);
        }
        return ans;
    }

    public static void main(String[] args) {
        int []nums={1,2,3,4,3};
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }
}
