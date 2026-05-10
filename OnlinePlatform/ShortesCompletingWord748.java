package OnlinePlatform;

import java.util.HashMap;
import java.util.Map;

public class ShortesCompletingWord748 {
    public static boolean isValid(String s,Map<Character,Integer>m1,String t){
        Map<Character,Integer>m2=new HashMap<>();
        for(char ch:s.toCharArray()){
            if(m2.containsKey(ch)){
                m2.put(ch,m2.getOrDefault(ch,0)+1);
            }else{
                m2.put(ch,1);
            }
        }
        for(int i=0;i<t.length();i++){
            if(m2.containsKey(t.charAt(i))){
                if(!(m2.get(t.charAt(i))>=m1.get(t.charAt(i)))){
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }
    public static String shortestCompletingWord(String licensePlate, String[] words) {
        StringBuilder  sb=new StringBuilder();
        for(char ch:licensePlate.toCharArray()){
            if(Character.isLetter(ch)){
                sb.append(ch);
            }
        }
        String temp=sb.toString().toLowerCase();
        Map<Character,Integer>m1=new HashMap<>();
        for(char ch:temp.toCharArray()){
            if(m1.containsKey(ch)){
                m1.put(ch,m1.getOrDefault(ch,0)+1);
            }else{
                m1.put(ch,1);
            }
        }
        String res=null;
        for(String s:words){
            if(isValid(s.toLowerCase(),m1,temp)){
              if(res==null || res.length()>s.length()){
                  res=s;
              }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String licensePlate = "1s3 PSt";
        String []words = {"step","steps","stripe","stepple"};
        System.out.println(shortestCompletingWord(licensePlate,words));
    }
}
