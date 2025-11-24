package Backtracking24;

import java.util.ArrayList;

public class PermutationSet {
    public static void permutation(String str,String ans){
        if(str.length()==0){
            System.out.print(ans+" ");
            return;
        }
        for(int i=0;i<str.length();i++){
            char curr=str.charAt(i);
            String newStr=str.substring(0,i)+str.substring(i+1);
            permutation(newStr,ans+curr);
        }
    }

    public static void main(String[] args) {
        String str="abc";
        permutation(str,"");
        ArraylistPermutation arr=new ArraylistPermutation();
        System.out.println(arr.permutation(str,"",new ArrayList<>()));
    }
}
class ArraylistPermutation{
    public static ArrayList<String> permutation(String str,String prefix,ArrayList<String> ans){
        if(str.length()==0){
            ans.add(prefix);
            return ans;
        }
        for(int i=0;i<str.length();i++){
            char curr=str.charAt(i);
            String newPrefix=prefix+curr;
            String newStr=str.substring(0,i)+str.substring(i+1);
            permutation(newStr,newPrefix,ans);
        }
        return ans;
    }
}

