package Backtracking24;

import java.util.ArrayList;
import java.util.Arrays;

public class PermutationFind {
    public static void findPermutation(String str,String ans){
        if(str.length()==0){
            System.out.print(ans+" ,");
            return;
        }
        for(int i=0;i<str.length();i++){
            // Skip duplicates to avoid repeated permutations
            if (i > 0 && str.charAt(i) == str.charAt(i - 1)) continue;

            char curr=str.charAt(i);
            //"abcde"="ab"+"de"="abde"
            String newStr=str.substring(0,i)+str.substring(i+1);
            findPermutation(newStr,ans+curr);
        }
    }

    public static void main(String[] args) {
        String s="abc";
//        findPermutation(s,"");
        //for second solution
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        String sorted = new String(arr);
        Solution5 sc=new Solution5();
        System.out.println(sc.findPermutation(sorted,"",new ArrayList<>()));
    }
}
class Solution5 {
    public static ArrayList<String> findPermutation(String str, String prefix,ArrayList<String> ans){
        if(str.length()==0){
            ans.add(prefix);
          return ans;
        }
        for(int i=0;i<str.length();i++){
            char curr=str.charAt(i);
            String newPrefix=prefix+curr;
            //"abcde"="ab"+"de"="abde"
            String newStr=str.substring(0,i)+str.substring(i+1);

            findPermutation(newStr,newPrefix,ans);
        }
        return ans;
    }


}
