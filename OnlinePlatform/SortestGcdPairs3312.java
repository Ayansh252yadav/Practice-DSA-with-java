package OnlinePlatform;

import java.util.ArrayList;
import java.util.Collections;

public class SortestGcdPairs3312 {
    public int gcd(int a,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
    public int[] gcdValues(int[] nums, long[] queries) {
        ArrayList<Integer> gcdPairs=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                gcdPairs.add(gcd(nums[i],nums[j]));
            }
        }
        Collections.sort(gcdPairs,(a,b)->(a-b));
        int res[]=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            res[i]=gcdPairs.get((int)queries[i]);
        }
        return res;
    }
}
