package OnlinePlatform;

import java.util.*;

public class BinaryGap868 {
    public static  int binaryGap(int n) {
     String str=Integer.toBinaryString(n);
     int adjDis=0;
        ArrayList<Integer>arr=new ArrayList<>();

     for(int i=0;i<str.length();i++) {
         if (str.charAt(i) == '1') {
             arr.add(i);

         }
     }
     int diff=0;
 for(int i=0;i<arr.size()-1;i++){
      diff=arr.get(i+1)- arr.get(i);
      adjDis=Math.max(diff,adjDis);
     }
     return adjDis;
    }

    public static void main(String[] args) {
        System.out.println(binaryGap(5));
    }
}
