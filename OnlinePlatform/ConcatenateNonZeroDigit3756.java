package OnlinePlatform;

import java.util.Arrays;

public class ConcatenateNonZeroDigit3756 {
    static long modulo=1000000007;
    public static int sumAndMultiply(String str) {
        long num=0;
        int sum=0;
            for (char c : str.toCharArray()) {
                if (c != '0') {
                    num = (num * 10 + (c - '0')) % modulo;
                    sum+=c-'0';
                }
            }

        return (int)((sum * num) % modulo);
    }
    public static int[] sumAndMultiply(String s, int[][] queries) {
        int []res=new int[queries.length];
        int i=0;
     for(int []e:queries){
       res[i++]=sumAndMultiply(s.substring(e[0],e[1]+1));
     }
     return res;
    }
    public static void main(String[] args) {
      String  s = "9876543210";
      int [][]queries = {{0,9}};
        System.out.println(Arrays.toString(sumAndMultiply(s,queries)));
    }
}
