package RecursionBasic21.part2;

import java.util.ArrayList;
import java.util.HashSet;

public class RemoveDuplicatesfromSortedArrayII80 {


    public static void main(String[] args) {
       int  nums[] = {1,1,1,2,2,3};
        HashSet<Integer>set=new HashSet<>();
       for(int i=0;i<nums.length;i++){
           set.add(nums[i]);
       }
        System.out.println(set);
    }
}
