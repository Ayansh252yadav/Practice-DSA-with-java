package OnlinePlatform;

import java.util.Arrays;

public class CountingBits338 {
    public static int[] countBits(int n) {
     int []ans=new int[n+1];
     for(int i=0;i<=n;i++){
         ans[i]=Integer.bitCount(i);
     }
     return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(5)));
    }
}
