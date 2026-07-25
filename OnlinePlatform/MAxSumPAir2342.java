package OnlinePlatform;

import java.util.HashMap;
import java.util.Iterator;

public class MAxSumPAir2342 {
    public boolean check(int a,int b){
        int sum1=0;
        while (a!=0){
            sum1 += a % 10;
            a /= 10;
        }
        int sum2=0;
        while (b!=0){
            sum2 += b % 10;
            b /= 10;
        }
        return sum2 == sum1;
    }
    public int maximumSum(int[] nums) {
        int max=-1;
     for(int i=0;i<nums.length;i++){
         for(int j=i+1;j<nums.length;j++){
             if(check(nums[i],nums[j])){
               max=Math.max(max,nums[i]+nums[j]);
             }
         }
     }
     return max;
    }
    public int digitSum(int n){
        int sum=0;
        while(n!=0){
            sum+=n%10;
            n/=10;
        }
        return sum;
    }
public int maximumSum2(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        int ans=-1;
       for(int i=0;i<nums.length;i++){
           int key=digitSum(nums[i]);
           int value=nums[i];
          if(map.containsKey(key)){
              ans=Math.max(ans,map.get(key)+value);
          }
           map.put(key,Math.max(map.getOrDefault(key,0),value));
       }
       return ans;
}
    public static void main(String[] args) {
        int []nums={18,43,36,13,7};
        MAxSumPAir2342 s=new MAxSumPAir2342();
        System.out.println(s.maximumSum(nums));
    }
}
