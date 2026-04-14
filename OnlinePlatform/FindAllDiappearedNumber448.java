package OnlinePlatform;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllDiappearedNumber448 {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
   Set<Integer> st=new HashSet<>();
   for(int num:nums){
       st.add(num);
   }
   List<Integer>list=new ArrayList<>();
   for(int i=1;i<=nums.length;i++){
       if(!st.contains(i)){
           list.add(i);
       }
   }
   return list;
    }

    public static void main(String[] args) {
        int []nums={4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));
    }
}
