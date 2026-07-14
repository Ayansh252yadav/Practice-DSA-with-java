package OnlinePlatform;

import java.util.Arrays;

public class NumberOfEvenOrOdd2595 {
    public static int[] evenOddBit(int n) {
      String s=Integer.toBinaryString(n);
      int even=0;
      int odd=0;
      int idx=s.length()-1;
//        110010.
      for(int i=s.length()-1;i>=0;i--){
          if(s.charAt(i)=='1'){
              if(Math.abs(idx-i)%2==0){
                even++;
              }else{
                  odd++;
              }
          }
      }
      return new int[]{even,odd};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(evenOddBit(50)));
    }
}
