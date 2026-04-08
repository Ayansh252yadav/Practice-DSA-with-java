package OnlinePlatform;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class PermutationDiffereceBetweenString3146 {
    public static int findPermutationDifference(String s, String t) {
     Map<Character,Integer> track1=new LinkedHashMap<>();
     Map<Character,Integer> track2=new LinkedHashMap<>();
     for(int i=0;i<s.length();i++){
         track1.put(s.charAt(i),i);
     }
        for(int i=0;i<t.length();i++){
            track2.put(t.charAt(i),i);
        }
        int sum=0;

        for(int i=0;i<s.length();i++){
            int c1=track1.get(s.charAt(i));
            int c2=track2.get(s.charAt(i));
            sum+=Math.abs(c1-c2);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(findPermutationDifference("abc","bac"));
    }
}
