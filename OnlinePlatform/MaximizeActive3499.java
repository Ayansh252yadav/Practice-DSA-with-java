package OnlinePlatform;

import java.util.ArrayList;
import java.util.List;

public class MaximizeActive3499 {
    public static int maxActiveSectionsAfterTrade(String s) {
     int n = s.length();
     int ones=0;
     for(char c:s.toCharArray()){
         if(c=='1'){
             ones++;
         }
     }
     List<Character>type=new ArrayList<>();
     List<Integer>len=new ArrayList<>();
     int i=0;
     while(i<n){
         char ch=s.charAt(i);
         int j=i;
         while(j<n&&ch==s.charAt(j)){
             j++;
         }
         type.add(ch);
         len.add(j-i);
         i=j;
     }
     int maxGain=0;
        for (int k = 1; k < len.size() - 1; k++) {
            if (type.get(k) == '1'
                    && type.get(k - 1) == '0'
                    && type.get(k + 1) == '0') {
                int gain = len.get(k - 1) + len.get(k + 1);
                maxGain = Math.max(maxGain, gain);
            }
        }
      return ones+maxGain;
    }

    public static void main(String[] args) {
        System.out.println(maxActiveSectionsAfterTrade("01010"));
    }
}
