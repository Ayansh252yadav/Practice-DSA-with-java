package Hashing38;

import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram242 {
    public static boolean isAnagram(String s, String t) {
   if(s.length()!=t.length()){
       return false;
   }
        HashMap<Character,Integer>map=new HashMap<>();
   for(int i=0;i<s.length();i++){
       map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
   }
   for(int i=0;i<s.length();i++){
       char ch=t.charAt(i);
       if(map.get(ch)!=null){
           if(map.get(ch)==1){
               map.remove(ch);
           }else{
               map.put(ch,map.get(ch)-1);
           }
       }else{
           return false;
       }
   }
   return map.isEmpty();
    }
    public boolean isAnagram1(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        char[] ch1=s.toCharArray();
        char[] ch2=t.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);

        for(int i=0; i<s.length(); i++){
            if(ch1[i]!=ch2[i]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram","nagaram"));
    }
}
