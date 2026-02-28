package OnlinePlatform;

public class ConcatinationofConsecutiveBinary {
    public static int concatenatedBinary(int n){
        String str="";
        for(int i=1;i<=n;i++){
            str+=Integer.toBinaryString(i);
        }
        long t=Long.parseLong(str,2);
        t=t%((long)(Math.pow(10,9))+7);
        System.out.println(t);
        return (int)t;
    }
// optimize approach
    public static int concatenatedBinary1(int n){
        long result = 0;
        int MOD = 1000000007;
        int len = 0; 
        for(int i = 1; i <= n; i++) {
            len=Integer.toBinaryString(i).length();
            result = ((result << len) + i) % MOD;
        }
        return (int) result;
    }
    public static void main(String[] args) {
        System.out.println(concatenatedBinary1(12));
    }
}
