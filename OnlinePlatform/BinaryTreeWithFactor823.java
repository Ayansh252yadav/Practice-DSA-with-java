package OnlinePlatform;

import java.util.Arrays;
import java.util.HashMap;

public class BinaryTreeWithFactor823 {
    long mod=1000_000_000+7;
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
    HashMap<Integer,Integer> map=new HashMap<>();
    for(int i=0;i<arr.length;i++){
        map.put(arr[i],i);
    }
    long []dp=new long[arr.length];
    Arrays.fill(dp,1L);
    for(int i=0;i<arr.length;i++){
        for(int j=0;j<arr.length;j++){
            if(arr[i]%arr[j]==0){
              if(map.containsKey(arr[i]/arr[j])){
                 dp[i]=(dp[i]+dp[j]*dp[map.get(arr[i]/arr[j])])%mod;
              }
            }
        }
    }
    return (int)dp[arr.length-1];
    }
  public int gcd(int a,int b){
        while (b!=0){
            int temp=b;
            b=b%a;
            a=temp;
        }
        return a;
  }

}
