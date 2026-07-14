package OnlinePlatform;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class SortEvenAndOddIndices2164 {
    public static int[] sortEvenOdd(int[] nums) {
        ArrayList<Integer> odd=new ArrayList<>();
        ArrayList<Integer> even=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                even.add(nums[i]);
            }else {
                odd.add(nums[i]);
            }
        }
        Collections.sort(odd,Collections.reverseOrder());
        Collections.sort(even);
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                nums[i]=even.getFirst();
                even.removeFirst();
            }else{
                nums[i]=odd.getFirst();
                odd.removeFirst();
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int []nums={4,1,2,3};
        System.out.println(Arrays.toString(sortEvenOdd(nums)));
    }
}
