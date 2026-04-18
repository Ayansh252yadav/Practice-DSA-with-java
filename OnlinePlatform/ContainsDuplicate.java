package OnlinePlatform;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
     Set<Integer> set=new HashSet<>();
        for(int el:nums){
            if(set.contains(el)){
                return true;
            }
            set.add(el);
        }
        return false;
    }
}
