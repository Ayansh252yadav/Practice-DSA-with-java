package OnlinePlatform;

import java.util.HashSet;
import java.util.Set;

public class NumberOfSubstring1358 {
    public static int numberOfSubstrings(String s) {
       int []freq=new int[3];
       int left=0;
       int ans=0;
       for(int right=0;right<s.length();right++){
           freq[s.charAt(right)-'a']++;
           while(freq[0]>0 && freq[1]>0 && freq[2]>0){
                ans+=s.length()-right;
                freq[s.charAt(left)-'a']--;
                left++;
           }
       }
       return ans;
    }
    public static void main(String[] args) {
        String s="abcabc";
        System.out.println(numberOfSubstrings(s));
    }
}
