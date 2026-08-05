package OnlinePlatform;

import java.util.ArrayList;
import java.util.HashMap;

public class SubArrays974 {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0, 1);
        int ans = 0;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int remainder=sum%k;
            if(remainder<0){
                remainder=remainder+k;
                ans+=map.getOrDefault(remainder,0);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
    }
    public int minimumOperations(int[] nums, int start, int goal) {
    HashMap<Integer,Integer> map = new HashMap<>();
    map.put(0, 1);
    int ans = 0;
    int sum=start;
    for(int i=0;i<nums.length;i++){
        sum+=nums[i];
        if(map.containsKey(sum-goal)){
            ans+=map.get(sum-goal);
        }
        map.put(sum,map.getOrDefault(sum,0)+1);
    }
    return ans;
    }
}
