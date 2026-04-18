package OnlinePlatform;

import java.util.*;

public class ContainsDuplicateII {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>>mp=new TreeMap<>();
        for(int i=0;i<nums.length;i++){
        mp.computeIfAbsent(nums[i],a->new ArrayList<>()).add(i);
        }
        for(Integer key:mp.keySet()){
            if(mp.get(key).size()>=2){
                for(int i=0;i<mp.get(key).size();i++){
                    for(int j=i+1;j<mp.get(key).size();j++){
                        if(Math.abs(mp.get(key).get(i)- mp.get(key).get(j))<=k){
                            return true;
                        }
                    }
                }
            }
        }
        System.out.println(mp);
        return false;
    }

    public static void main(String[] args) {
        int []nums={1,2,3,1};
        int k=3;
        System.out.println(containsNearbyDuplicate(nums,k));
    }
}
