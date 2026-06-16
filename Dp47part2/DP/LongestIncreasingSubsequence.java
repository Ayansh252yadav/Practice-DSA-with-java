package Dp47part2.DP;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int []arr={50,3,10,7,40,80};
        Arrays.sort(arr);
        HashSet<Integer>hs=new HashSet<>();
        for(int e:arr){
            hs.add(e);
        }
        int []temp=new int[arr.length];
        Iterator<Integer>it=hs.iterator();
        int k=0;
        while (it.hasNext()){
            temp[k++]=it.next();
        }
        System.out.println(Arrays.toString(temp));
        System.out.println(Arrays.toString(arr));
        int [][]dp=new int[arr.length+1][arr.length+1];
        for(int i=1;i<arr.length+1;i++){
            for(int j=1;j<arr.length+1;j++){
                if(arr[i-1]>=temp[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    int ans1=dp[i-1][j];
                    int ans2=dp[i][j-1];
                    dp[i][j]=Math.max(ans1,ans2);
                }
            }
        }
        System.out.println(dp[arr.length][arr.length]);
        System.out.println(Arrays.deepToString(dp));
    }
}
