package OnlinePlatform;

import java.util.ArrayList;
import java.util.HashSet;

public class AllBinaryCodeOfSizeK {

    public static boolean hasAllCodes(String s, int k) {
        HashSet<String>hs=new HashSet<>();
      for(int i=0;i<=s.length()-k;i++){
          hs.add(s.substring(i,i+k));
      }
      int n=(int)Math.pow(2,k);
      if(hs.size()==n){
          return true;
      }
//        System.out.println(hs);
    return false;
    }

    public static void main(String[] args) {
        System.out.println(hasAllCodes("0110",2));
    }
}
