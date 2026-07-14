package OnlinePlatform;


import java.util.Arrays;

public class SubSequence3336 {
    static final int MOD = 1000000007;
    public int gcd(int a,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
    public int  subSequence(int i,int g1,int g2,int []nums,int [][][]dp){
        if(i==nums.length){
            if (g1 != 0 && g2 != 0 && g1 == g2) {
                return 1;
            }
            return 0;
        }
         if(dp[i][g1][g2]!=-1){
             return dp[i][g1][g2];
         }
        //include in g1
       int s1= subSequence(i+1,gcd(g1,nums[i]),g2,nums,dp);
        //include in g2
       int s2= subSequence(i+1,g1,gcd(g2,nums[i]),nums,dp);
       //do not include
       int s3= subSequence(i+1,g1,g2,nums,dp);

       long ans=(s1 + s2 + s3) % MOD;
       dp[i][g1][g2]=(int)ans;
       return dp[i][g1][g2];
    }
    public int subsequencePairCount(int[] nums) {
    int [][][]dp=new int[nums.length][201][201];
        for (int i = 0; i < nums.length; i++) {
            for (int g1 = 0; g1 <= 200; g1++) {
                Arrays.fill(dp[i][g1], -1);
            }
        }
        int ans=subSequence(0,0,0,nums,dp);
        return ans;
    }

    public static void main(String[] args) {
        int []nums={1,2,3,4};
        SubSequence3336 sub=new SubSequence3336();
        System.out.println(sub.subsequencePairCount(nums));
    }
}
