package OnlinePlatform;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SnekyNumbert3289 {
    public static int[] getSneakyNumbers(int[] nums) {
     Set<Integer>hs=new HashSet<>() ;
        int []res=new int[2];
        int k=0;
     for(int i=0;i<nums.length;i++){
         if(hs.contains(nums[i])){
             res[k]=nums[i];
             k++;
         }
         hs.add(nums[i]);
     }
    return res;
    }

    public static void main(String[] args) {
        int []arr={7,1,5,4,3,4,6,0,9,5,8,2};
        System.out.println(Arrays.toString(getSneakyNumbers(arr)));
        System.out.println(1^3);
    }
}
