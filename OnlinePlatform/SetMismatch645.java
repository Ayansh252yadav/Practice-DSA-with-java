package OnlinePlatform;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMismatch645 {
    public static int[] findErrorNums(int[] nums) {
        Set<Integer> set=new HashSet<>();
        ArrayList<Integer>arr=new ArrayList<>();
        for(int i=1;i<=nums.length;i++){
             set.add(i);
        }
        for (int num : nums) {
            if(set.contains(num)) {
                set.remove(num);
            }else{
                arr.add(num);
            }
        }
        arr.addAll(set);
        int []res=new int[arr.size()];
        int k=0;
        for(int e:arr){
            res[k++]=e;
        }
       set=null;
        arr=null;
        return res;
    }

    public static void main(String[] args) {
        int arr[]={1,2,2,4};
        System.out.println(Arrays.toString(findErrorNums(arr)));
    }
}
